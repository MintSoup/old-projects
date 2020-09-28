package net.aang.javagame;

import kuusisto.tinysound.TinySound;
import net.aang.javagame.state.State;
import net.aang.javagame.util.GameUtils;
import net.aang.javagame.util.MouseInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = -3082472049498808372L;

    public boolean isRunning = false;
    public Thread currentGame;
    public double delta = 0;
    public int _FPS = 0;
    public int _UPS = 0;
    public volatile State  currentState;
    public int frames;
    public long lastRender;


    public Game(JFrame f) {
        f.add(this);
        currentState = GameUtils.getState(GameUtils.getInt("state.menu"));
        MouseInput mi = new MouseInput();
        this.addMouseListener(mi);
        this.addMouseMotionListener(mi);
        this.addMouseWheelListener(mi);
        
    }

    public synchronized void start() {
        if (isRunning) return;

        isRunning = true;

        currentGame = new Thread(this);
        currentGame.start();

    }


    public synchronized void stop() {
        if (!isRunning) return;

        try {
            isRunning = false;
            currentGame.join();
            TinySound.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {

        this.requestFocus();
        double lastTime = System.nanoTime();
        double amountOfTicks = 30;
        double ns = 1000000000 / amountOfTicks;
        long timer = System.currentTimeMillis();
        int ticks = 0;
        int frames = 0;

        while (isRunning) {

            long now = System.nanoTime();

            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
                ticks++;

            }


            if (isRunning) {

                if (render()) frames++;
            }
            if (System.currentTimeMillis() - timer >= 200) {
                _FPS = frames;
                _UPS = ticks;
                ticks=0;
                frames = 0;
                timer += 1000;

            }
        }
    }


    public synchronized void setCurrentState(State currentState) {
        this.currentState = currentState;
        currentState.onEnterState();
    }

    public void tick() {

        currentState.tick();
    }

    public boolean render() {
        long x = System.nanoTime() - lastRender;
        if ((x) >= (30000000)) {

            frames++;
            BufferStrategy bs = this.getBufferStrategy();
            if (bs == null) {
                this.createBufferStrategy(2);
                return false;
            }

            Graphics g2 = bs.getDrawGraphics();
            g2.setColor(Color.black);
            g2.fillRect(0, 0, 1000, 500);

            Graphics2D graphics = (Graphics2D) g2;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics.setFont(new Font("Calibri", Font.PLAIN, 30));
            graphics.setColor(Color.green);
            graphics.drawString("FPS: " + _FPS, 900, 30);
            graphics.drawString("TPS: " + _UPS, 900, 60);

            currentState.render(graphics);

            //-------------------------------------------------------------------

            graphics.dispose();
            bs.show();
            lastRender = System.nanoTime();
            return true;
        } else return false;
    }

    public void mouseClicked(MouseEvent e) {
        currentState.mouseClicked(e);
    }

    public void mousePressed(MouseEvent e) {
        currentState.mousePressed(e);
    }

    public void mouseReleased(MouseEvent e) {
        currentState.mouseReleased(e);
    }

    public void mouseDragged(MouseEvent e) {
        currentState.mouseDragged(e);
    }

    public void mouseMoved(MouseEvent e) {
        currentState.mouseMoved(e);
    }

}
