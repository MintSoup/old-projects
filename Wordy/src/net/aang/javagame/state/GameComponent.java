package net.aang.javagame.state;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public interface GameComponent{
	public void tick();
	public void render(Graphics2D g);
	public void mouseClicked(MouseEvent e);
	public void mousePressed(MouseEvent e);
	public void mouseReleased(MouseEvent e);
	public void mouseDragged(MouseEvent e);
	public void mouseMoved(MouseEvent e);
}
