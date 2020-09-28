package src.game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import src.game.main.gui_hud.HUD;
import src.game.util.Utils;

public class Menu extends MouseAdapter	{

	private Color[] color = {Color.RED,Color.RED,Color.RED};
	private Color bgColor;
	private Shop shop;
	private Game game;
	public HUD hud;
	private boolean isShop = false;
	
	public Menu(Game g,HUD hud) {
		this.game = g;
		shop = new Shop(this);
		this.hud = hud;
	}
	
	public void tick() {
		if(!isShop) {
			
		}
		else {
			shop.tick();
		}
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if(!isShop ) {
	
		
		
	
		
		
		
		g2d.setColor(bgColor);
		
		g.fillRect(0, 0, Game.size.width,Game.size.height);
		
		
		
		g2d.setFont(Utils.getDefaultFontBySizeAndType(125, Font.BOLD));
		g2d.setColor(Color.cyan);
		g2d.drawString("MENU", 240, 120);
		
		if(Utils.isDevmodeEnabled()) {
			g2d.setFont(Utils.getDefaultFontBySizeAndType(30, Font.PLAIN));
			g2d.setColor(Color.red);
			g2d.drawString("DEVMODE ENABLED", 275, 180);
			
		}
		
		g2d.setFont(Utils.getDefaultFontBySizeAndType(90, Font.BOLD));
		
		
		
		g2d.setColor(color[0]);
		g2d.fillRoundRect(230, 220, 330, 100, 15, 15);
		
		g2d.setColor(Color.CYAN);
		g2d.drawString("PLAY", 300, 300);
		
		g2d.setColor(color[1]);
		g2d.fillRoundRect(230, 370, 330, 100,15,15);
		
		g2d.setFont(Utils.getDefaultFontBySizeAndType(48, Font.BOLD));
		g2d.setColor(Color.CYAN);
		g2d.drawString("SETTINGS/SHOP", 230, 438);
		
		
		g2d.setColor(color[2]);
		g2d.fillRoundRect(230, 520, 330, 100,15,15);
		g2d.setFont(Utils.getDefaultFontBySizeAndType(80, Font.BOLD));
		g2d.setColor(Color.CYAN);
		g2d.drawString("EXIT", 310, 600);
	}else {
		shop.render(g);
	}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(!isShop)
		{
			
		}
		
		else {
			shop.mouseDragged(e);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(!isShop) {
		Point p = e.getPoint();
		if(!isShop) {
		if(new Rectangle(230, 220, 330, 100).contains(p)) {
			
			Game.CurrentState = Game.STATE.GAME;
			color[0] = Color.red;
			
		}
		else if(new Rectangle(230, 520, 330, 100).contains(p)) {
			
			game.stop();
			System.exit(0);
			
		}
		else if (new Rectangle(230, 370, 330, 100).contains(p)) {
			color[1] = Color.red;
			isShop = true;
		}
		}
		}else {
			shop.mouseClicked(e);
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(!isShop) {
			
		}
		else {
			shop.mousePressed(e);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(!isShop) {
			
		}
		else {
			shop.mouseReleased(e);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(!isShop){
		Point p = e.getPoint();
		if(!isShop) {
		if(new Rectangle(230, 220, 330, 100).contains(p)) {
			
			color[0] = new Color(255,100,100);
			
		} else {
			color[0] = Color.red;
		}
		if(new Rectangle(230, 370, 330, 100).contains(p)) {
			
			color[1] = new Color(255,100,100);
			
		} else {
			color[1] = Color.RED;
		}
		if(new Rectangle(230, 520, 330, 100).contains(p)) {
			
			color[2] = new Color(255,100,100);
			
		} else {
			color[2] = Color.RED;
		}
		}
		
		}else {
			
			shop.mouseMoved(e);
		
		
		}
		}

	public boolean isShop() {
		return isShop;
	}

	public void setShop(boolean isShop) {
		this.isShop = isShop;
	}
	 



}
