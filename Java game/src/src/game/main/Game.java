package src.game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.util.Date;

import org.python.tests.SomePyMethods;

import kuusisto.tinysound.TinySound;
import src.game.main.gameobject.Player;
import src.game.main.gui_hud.HUD;
import src.game.util.HighscoreManager;
import src.game.util.ID;
import src.game.util.KeyInput;
import src.game.util.Sounds;
import src.game.util.Utils;


public class Game extends Canvas implements Runnable{


	private static final long serialVersionUID = -6087797044036628660L;
	public static Dimension size = new Dimension(880,880/12*9);
	private Thread currentGame = null;
	private boolean isRunning = false;
	private static int _FPS;
	private static Handler handler;
	private static Spawn spawner;
	public static STATE CurrentState = STATE.LOADING;
	private static HUD hud;
	private Menu menu;
	private boolean hasGameListeners = true;
	public API api;
	public Game() throws URISyntaxException {

		handler = new Handler();
		api = new API(handler);

		new Window(size ,"Green", this);
		menu = new Menu(this,hud);
		hud = new HUD(); 

		spawner = new Spawn(handler,hud);
	
		
		this.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		
		
		handler.add(new Player(size.width/2-32, size.height/2-32, ID.Player,handler,hud));
		
		api.init();
		
	
		
	
		
	}


	
	public synchronized void start(){
		if(isRunning)return;
		
		isRunning = true;
		
		
		System.out.println("Starting Game...");
		
		
		HighscoreManager.load();

		currentGame = new Thread(this);
		currentGame.start();
		

		System.out.println("Game started");
	}
	

	public synchronized void stop() {
		if(!isRunning) return;
		
		try {
			System.out.println("Stopping game");
			isRunning = false;
			System.out.println("IsRunnning == false");
			currentGame.join();
			TinySound.shutdown();
			System.out.println("Game stopped");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
	
		this.requestFocus();
		double lastTime = System.nanoTime();
		double amountOfTicks = 120.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(isRunning) {
			
			long now = System.nanoTime();
		
			delta += (now-lastTime)/ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
				
				
			}
			
			if(isRunning) {
				render();
				frames++;
			}
			if(System.currentTimeMillis() -timer >= 1000) {
				_FPS = frames;
				frames = 0;
				timer += 1000;
				
			}
			
		}
		
		
	}

	public static double clamp(double i,double min,double max) {
		if(i >= max) 
			return i = max;
		else if (i<= min) 
			return i = min;
		else return i;
	}

	private void tick() {
	
		api.tick();
		if(CurrentState ==STATE.GAME) {
			handler.tick();
			hud.tick();
			spawner.tick();
			
			if(!hasGameListeners) {
				this.addKeyListener(new KeyInput(handler));
				this.removeMouseListener(menu);
				this.removeMouseMotionListener(menu);
				hasGameListeners = true;
			}
		}
		else if (CurrentState == STATE.MENU) {
			if(hasGameListeners) {
				this.removeKeyListener(new KeyInput(handler));
				this.addMouseListener(menu);
				this.addMouseMotionListener(menu);
				hasGameListeners = false;
			}
			
				menu.tick();
		}else if (CurrentState == STATE.LOADING) {
			initSoundStuff();
		}
		else if (CurrentState == STATE.LOST) {
			handler.tick();
		}
		
	}



	private void initSoundStuff() {
	
			TinySound.init();
			try {
				Thread.sleep(1500);
				Sounds.music.play(true);
				Sounds.music.setLoop(true);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			CurrentState = STATE.MENU;
		
		
	}



	private void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) { 
			this.createBufferStrategy(4);
			return;
		}
		
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(new Color(0,0,0));
		g.fillRect(0, 0, size.width,size.height);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
	
//--------------------------------------------------------------------		
		
			
			if(CurrentState == STATE.GAME) {
				handler.render(g2d);
				hud.render(g2d);
			}
			else if (CurrentState == STATE.MENU){
				menu.render(g2d);
			}
			else if (CurrentState == STATE.LOADING) {
				g2d.setColor(Color.red);
				g2d.setFont(Utils.getDefaultFontBySizeAndType(150, Font.BOLD));
				g2d.drawString("LOADING...", 110, 400);
				
			}
			else if (CurrentState == STATE.LOST) {
				
				g2d.setColor(Color.CYAN);
				g2d.setFont(Utils.getDefaultFontBySizeAndType(100, Font.BOLD));
				g2d.drawString("YOU LOST...", 100, 300);
				g2d.setFont(Utils.getDefaultFontBySizeAndType(30, Font.PLAIN));
				g2d.drawString("Level: " + hud.getLvl(), 110, 330);
				g2d.drawString("Score: " + hud.getScore(), 110, 355);
				g2d.drawString("Press [R] to start again...", 110, 380);
				g2d.drawString("Press [S] to save highscore...", 110, 408);
				handler.render(g2d);
			}
			api.render(g2d);
		
			
			
//-------------------------------------------------------------------	
			g2d.setColor(Color.BLUE);
			
			g2d.setFont(Utils.getDefaultFontBySizeAndType(16, 0));
			g2d.drawString("fps : " + _FPS, 1, 12);
			g2d.setFont(Utils.getDefaultFontBySizeAndType(20, Font.PLAIN));
			
			DateFormat df = DateFormat.getDateTimeInstance();
			g2d.drawString(df.format(new Date()), Game.size.width - 170, Game.size.height - (Game.size.height-17));
			g2d.dispose();
			bs.show();
		}
	public enum STATE{
		
		MENU,
		GAME,
		LOST,
		LOADING
		
	}
	public void restart() {
		handler = new Handler();
		hud = new HUD();
		handler.add(new Player(size.width/2-32, size.height/2-32, ID.Player,handler, hud));
		spawner = new Spawn(handler, hud);
		addKeyListener(new KeyInput(handler));
		CurrentState = STATE.GAME;
	}


}
