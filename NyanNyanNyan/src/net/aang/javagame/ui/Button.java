package net.aang.javagame.ui;

import net.aang.javagame.state.GameComponent;
import net.aang.javagame.util.SoundManager;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Button implements GameComponent {

	public String text;
	public Font font;
	public Color bgcolor;
	public Color stringColor;
	public int x;
	public int y;
	public int w;
	public int h;
	public int sx;
	public int sy;
	public Runnable onClick;
	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(bgcolor);
		g.setFont(font);
		g.fillRoundRect(x, y, w, h, 15, 15);
		g.setColor(stringColor);
		g.drawString(text, sx+x, sy+y);
	}

	public Button(String text, Font font, Color bgcolor, Color stringColor, int x, int y, int w, int h,
			int sx, int sy) {
		super();
		this.text = text;
		this.font = font;
		this.bgcolor = bgcolor;
		this.stringColor = stringColor;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.sx = sx;
		this.sy = sy;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(new Rectangle(x,y,w,h).contains(e.getPoint())) {
			SoundManager.playSound("sound.click");
			onClick.run();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override	
	public void mouseMoved(MouseEvent e) {

		if(new Rectangle(x,y,w,h).contains(e.getPoint())) {
			bgcolor=new Color(255,100,100);
		}
		else {
			bgcolor=Color.red;
		}

	}



}
