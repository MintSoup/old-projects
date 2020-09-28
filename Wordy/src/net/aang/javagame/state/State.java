package net.aang.javagame.state;

import net.aang.javagame.util.Handler;

import java.awt.*;
import java.awt.event.MouseEvent;

public class State implements GameComponent{
	
	public int id;
	public Handler handler;
	public void init() {
		handler=new Handler();
	}
	
	@Override
	public void tick() {
		handler.tick();
	}

	@Override
	public void render(Graphics2D g) {
		handler.render(g);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		handler.mouseClicked(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		handler.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		handler.mouseReleased(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		handler.mouseDragged(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		handler.mouseMoved(e);
	}

	public void onEnterState(){

	}
}
