package src.game.util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import src.game.main.Game;
import src.game.main.Handler;
import src.game.main.gameobject.GameObject;
import src.game.main.gui_hud.HUD;
import src.game.main.launch.Launcher;
import src.game.util.HighscoreManager.Highscore;

public class KeyInput extends KeyAdapter {

	private Handler handler;

	
	public KeyInput(Handler handler) {
		this.handler = handler;
	
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
			
		if(key == KeyEvent.VK_ESCAPE) {
			Game.CurrentState = Game.STATE.MENU;
			return;
		}
		
		else if (key == KeyEvent.VK_R) {
			Launcher.game.restart();
			return;
		}
		else if (key == KeyEvent.VK_S) {
			if(Game.CurrentState == Game.STATE.LOST) {
				
				HighscoreManager.Highscore h = new HighscoreManager.Highscore(HUD.lvl, HUD.score, JOptionPane.showInputDialog("Enter Your name..."));
				HighscoreManager.add(h);
				HighscoreManager.save();
				return;
			} 
		}
		else if (key == KeyEvent.VK_H) {
			if(Game.CurrentState == Game.STATE.MENU) {
				StringBuilder highscores = new StringBuilder();
		
				for(int i = 0;i<HighscoreManager.highscores().size();i++) {
					highscores.append(i+1 + ")" + "\t" + HighscoreManager.highscores().get(i).getName() + "\t" + " - " + HighscoreManager.highscores().get(i).getLevel() + " : " + HighscoreManager.highscores().get(i).getScore() + "\n");
					
				}
				JOptionPane.showMessageDialog(null, highscores);
				return;
			}
		}
		
		try {
		for(GameObject go : handler.getObjects()) {
			if(go.getId() == ID.Player) {
				
				switch(key) {
				case KeyEvent.VK_UP:{
					go.setVelY(-3.6);
					break;
				}
				case KeyEvent.VK_DOWN:{
					go.setVelY(3.6);
					
					break;
				}
				case KeyEvent.VK_RIGHT:{
					go.setVelX(3.6);
				
					break;
				}
				case KeyEvent.VK_LEFT:{
					go.setVelX(-3.6);

					break;
				}
				
				}
				
				
			}
		}}catch(Exception x) {}
		
		Launcher.game.api.keyPressed(e.getKeyCode());
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		try {
		for(GameObject go : handler.getObjects()) {
			if(go.getId() == ID.Player) {
				
			
				switch(key) {
				case KeyEvent.VK_UP:{
					go.setVelY(0);
					
					break;
				}
				case KeyEvent.VK_DOWN:{
					go.setVelY(0);

					break;
				}
				case KeyEvent.VK_RIGHT:{
					go.setVelX(0);
					
					break;
				}
				case KeyEvent.VK_LEFT:{
					go.setVelX(0);
					
					break;
				}
				}
				
				
			
				
			}
		}}catch(Exception xc) {}
		Launcher.game.api.keyReleased(e.getKeyCode());
	}

	

}
