package src.game.main;

import java.awt.Graphics;
import java.util.LinkedList;

import src.game.main.gameobject.GameObject;

public class Handler {
	LinkedList<GameObject> objects = new LinkedList<GameObject>();
	
	public void tick() {
		for (int x = 0; x<objects.size();x++) {
			objects.get(x).tick();
		}
		
	}
	public void render(Graphics g) {
		for (int x = 0; x<objects.size();x++) {
			objects.get(x).render(g);
		}
	}
	
	public void add(GameObject go) {
		objects.add(go);
	}
	public void remove(GameObject go) {
		objects.remove(go);
		
	}
	public LinkedList<GameObject> getObjects() {
		
		return objects;
	}
}
