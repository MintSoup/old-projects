package src.game.main.gui_hud;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.SwingUtilities;

import src.game.main.Game;

public class Slider {

	private Color lc,hc,fc;
	private int x,y;
	private int w,h;
	private Runnable change;
	private int lineY;
	private double value = 99;
	private double lastValue = value;
	private boolean canMove;
	public Slider(Color bgColor,Color filledColor,Color handlerColor,Runnable onValueChange,int x,int y,int w,int h,int lineY) {
		setLc(bgColor);
		setHc(handlerColor);
		setFc(filledColor);
		change = onValueChange;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = w;
		this.lineY = lineY;
	}

	
	
	public void render(Graphics gt) {
		Graphics2D g = (Graphics2D) gt.create(x, y, w, h);
		g.setColor(getLc());
		g.fillRoundRect(10, y/2-lineY, w-10, lineY, 10, 10);
		g.setColor(getFc());
		g.fillRoundRect(10, y/2-lineY, (int) ((value*w)/100)-10, lineY, 10, 10);
		g.setColor(getHc());
		int xmin = 6;
		while(((int)((value*w)/100)-xmin)<5) xmin--;
		g.fillRoundRect((int)((value*w)/100)-xmin, y/2-20, 5, 30, 10, 10);
				
	}
	
	public void tick() {
	
		if(lastValue != value) {
			change.run();
		}
		
		lastValue = value;
		
	}
	
	
	
	public void mousePressed(MouseEvent e) {
		
		Point p = e.getPoint();
		
		if (new RoundRectangle2D.Double(x+ ((int)((value*w)/100)-6), y + (y/2-20), 5, 30, 10, 10).contains(p)) {
			
			canMove = SwingUtilities.isLeftMouseButton(e);
			
		}
	}

	
	public void mouseReleased(MouseEvent e) {
	
		
		canMove = false;
		
	}
	
	public void mouseDragged(MouseEvent e) {
	
		
	
		if(canMove) {
			value = (e.getX() - x) / 3 + 10
				;
			value = Game.clamp(value, 0, 100);
			
		}		
			
			
		
	}

	
	
	
	
	
	
	
	
	
	
	public Color getHc() {
		return hc;
	}

	public Slider setHc(Color hc) {
		this.hc = hc;
		return this;
	}

	public Color getLc() {
		return lc;
	}

	public Slider setLc(Color lc) {
		this.lc = lc;
		return this;
	}



	public int getX() {
		return x;
	}



	public Slider setX(int x) {
		this.x = x;
		return this;
	}



	public int getY() {
		return y;
	}



	public Slider setY(int y) {
		this.y = y;
		return this;
	}



	public int getW() {
		return w;
	}



	public Slider setW(int w) {
		this.w = w;
		return this;
	}



	public int getH() {
		return h;
	}



	public Slider setH(int h) {
		this.h = h;
		return this;
	}



	public double getValue() {
		return value;
	}
	
	public Slider setValue(double v) {
		this.value = v;
		return this;
	}



	public Color getFc() {
		return fc;
	}



	public Slider setFc(Color fc) {
		this.fc = fc;
		return this;
	} 

}
