package net.aang.javagame.util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MouseInput extends MouseAdapter {

	
	public void mouseClicked(MouseEvent e) {
		GameUtils.instance.mouseClicked(e);
	}

	
	public void mousePressed(MouseEvent e) {
		GameUtils.instance.mousePressed(e);
	}

	
	public void mouseReleased(MouseEvent e) {
		GameUtils.instance.mouseReleased(e);
	}

	
	public void mouseEntered(MouseEvent e) {
	
	}

	
	public void mouseExited(MouseEvent e) {
		
	}

	
	public void mouseWheelMoved(MouseWheelEvent e) {
		
	}

	
	public void mouseDragged(MouseEvent e) {
		GameUtils.instance.mouseDragged(e);
	}

	
	public void mouseMoved(MouseEvent e) {
		GameUtils.instance.mouseMoved(e);
	}
	
	
	
}
