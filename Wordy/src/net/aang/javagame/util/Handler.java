package net.aang.javagame.util;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import net.aang.javagame.state.GameComponent;

public class Handler implements GameComponent {

	public List<GameComponent> gos = new ArrayList<GameComponent>();
	
	public void add(GameComponent e) {
		gos.add(e);
	}
	
	public void destroy(GameComponent e) {
		gos.remove(e);
	}
	
	@Override
	public void tick() {
		for(GameComponent gc : gos) {
			gc.tick();
		}
	}

	@Override
	public void render(Graphics2D g) {
		for(GameComponent gc : gos) {
			gc.render(g);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for(GameComponent gc : gos) {
			gc.mouseClicked(e);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		for(GameComponent gc : gos) {
			gc.mousePressed(e);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		for(GameComponent gc : gos) {
			gc.mouseReleased(e);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		for(GameComponent gc : gos) {
			gc.mouseDragged(e);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		for(GameComponent gc : gos) {
			gc.mouseMoved(e);
		}
	}

}
