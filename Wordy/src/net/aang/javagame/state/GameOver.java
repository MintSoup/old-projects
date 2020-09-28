package net.aang.javagame.state;

import net.aang.javagame.util.GameUtils;
import net.aang.javagame.util.SoundManager;

import java.awt.*;

import static java.awt.Color.cyan;

/**
 * Created by DeLL on 30/05/2016.
 */
public class GameOver extends State{

    public int level;
    public int points;
    public StateGame game;
    public int tickslived;

    public GameOver() {
    }

    @Override
    public void init() {
        id=2;
        super.init();

    }

    @Override
    public void tick() {
        super.tick();
        tickslived++;
        if(tickslived>=3*GameUtils.instance._UPS){
            GameUtils.instance.setCurrentState(GameUtils.getState(GameUtils.getInt("state.menu")));
        }
    }

    @Override
    public void render(Graphics2D g1) {
        g1.setColor(new Color(255, 50, 0));
        g1.setFont(new Font("Calibri",Font.BOLD,100));
        g1.drawString("GAME OVER",200,100);
        g1.setFont(new Font("Calibri",Font.BOLD,50));
        g1.setColor(cyan);
        g1.drawString(String.format("Points: %d/%d", game.points,game.lvl-1),325,175);
    }

    @Override
    public void onEnterState() {
        super.onEnterState();
        tickslived=0;
        SoundManager.stopMusic("music.timer");
        game = (StateGame)(GameUtils.getState(GameUtils.getInt("state.play")));
    }
}
