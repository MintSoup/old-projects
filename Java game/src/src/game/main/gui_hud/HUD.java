package src.game.main.gui_hud;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import src.game.main.Game;
import src.game.util.Utils;

public class HUD {

	public static double HP = 100;
	public static int score = 0;
	public static int lvl = 0;
	private short gv = 255;
	public static int money;

	public HUD() {
		HP = 100;
		score = 0;
		lvl = 0;
		gv = 255;
		money = 0;
	}
	
	public void tick() {
		HP = Game.clamp(HP, 0, 100);
		money = (int) Game.clamp(money, 0, Integer.MAX_VALUE);
		gv = (short) Game.clamp(gv,0,255);
		
		gv = (short) (HP * 2);
		
		if (HP > 0) {
			score++;
			
		}
		else {
			Game.CurrentState = Game.STATE.LOST;
		}
		
		
		
	
	}
	

	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
	
		
		
		
		g2d.setColor(Color.GRAY);
		g2d.fillRoundRect((Game.size.width/2)-150, 15, 300, 30,10,10);
	
		g2d.setColor(new Color(75,(int)gv,0));
		g2d.fillRoundRect((Game.size.width/2-150), 15, (int)HP*3, 30,10,10);
		g2d.setFont(Utils.getDefaultFontBySizeAndType(20, Font.PLAIN));
		g2d.drawString("Level: " + lvl, 6,Game.size.height-43);
		g2d.drawString("Score: " + score, 6,Game.size.height-25);
		g2d.drawString("Money: " + money + "$", 6, Game.size.height-7);
		
		
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	

}
