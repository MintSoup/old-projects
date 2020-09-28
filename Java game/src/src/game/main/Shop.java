package src.game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JOptionPane;

import kuusisto.tinysound.TinySound;
import src.game.main.gui_hud.HUD;
import src.game.main.gui_hud.Slider;
import src.game.util.Utils;

public class Shop extends MouseAdapter{
	private Color[] buttonColor = {Color.red,Color.red};
	private Menu menu;
	private Slider s;

	public Shop(Menu m) {
		menu = m;
		
		s = new Slider(Color.white,Color.GREEN, Color.red, new Runnable() {
			public void run() {
				TinySound.setGlobalVolume(s.getValue()/100);
			}
		}, 430, 60, 250, 100, 8).setValue(50);
	}
	
	public void tick(){
		s.tick();
	}
	
	public void render(Graphics gr) {
		Graphics2D g = (Graphics2D) gr; 
		g.setColor(buttonColor[0]);
		g.fillRoundRect(60, 60, 250, 100, 15, 15);
		g.setFont(Utils.getDefaultFontBySizeAndType(70, Font.BOLD));
		g.setColor(Color.cyan);
		g.drawString("BACK", 105,130);
		
		g.setFont(Utils.getDefaultFontBySizeAndType(25, Font.PLAIN));
		g.setColor(Color.cyan);
		g.drawString("Volume: ", 370, 90);
		
		g.setColor(buttonColor[1]);
		g.fillRoundRect(60, 300, 180, 80, 15, 15);
		g.setFont(Utils.getDefaultFontBySizeAndType(30, Font.BOLD));
		g.setColor(Color.cyan);
		g.drawString("Fill HP", 95,340);
		g.setFont(Utils.getDefaultFontBySizeAndType(30, Font.BOLD));
		g.drawString("($80)", 95,370);
		
		s.render(g);
		
	}


	
	@Override
	public void mousePressed(MouseEvent e) {
		s.mousePressed(e);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		s.mouseReleased(e);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Point p = e.getPoint();
		
		if(new RoundRectangle2D.Double(60, 60, 250, 100, 15, 15).contains(p)) {
			menu.setShop(false);
			
		}
		else if (new RoundRectangle2D.Double(60, 300, 180, 80, 15, 15).contains(p)) {
			
			if(HUD.HP != 100 && menu.hud.getMoney() >= 80) {
				HUD.HP = 100;
				menu.hud.setMoney(menu.hud.getMoney() - 80);
				menu.setShop(false);
				Game.CurrentState = Game.STATE.GAME;
			}
			else { 
				JOptionPane.showMessageDialog(null, "You cannot fill your HP because \nMoney is less than 80 / HP = 100 / You didn't start playing", "Ahh,Crap!", 0);
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Point p = e.getPoint();
	
		if(new RoundRectangle2D.Double(60, 60, 250, 100, 15, 15).contains(p)) {
			buttonColor[0] = new Color(255,100,100);
		}
		else {
			buttonColor[0] = Color.red;
		}
		
		if(new RoundRectangle2D.Double(60, 300, 180, 80, 15, 15).contains(p)) {
			buttonColor[1] = new Color(255,100,100);
		}
		else {
			buttonColor[1] = Color.red;
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		s.mouseDragged(e);
	}

}
