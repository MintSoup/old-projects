package src.game.main.gameobject.enemy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import src.game.main.Handler;
import src.game.main.gameobject.GameObject;
import src.game.main.gameobject.Player;
import src.game.main.gameobject.fx.BasicFX;
import src.game.util.ID;

public class AIEnemy extends GameObject {

	private Handler handler;
	private GameObject player;
	public AIEnemy(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		for (GameObject go : handler.getObjects()) {
			if (go.getId() == ID.Player) {
				player = (Player) go;
			}
		}
		this.handler = handler;
	}

	@Override
	public void tick() {
		super.tick();
		
		  float diffX = (float) (x - player.getX() - 8);
          float diffY = (float) (y - player.getY() - 8);
          float distance = (float) Math.sqrt((x-player.getX())*(x-player.getX())+(y-player.getY())*(y-player.getY()));
          velX = ((-2 / distance) * diffX);
          velY = ((-2 / distance) * diffY);
          try {
          for (GameObject go : handler.getObjects()) {
        	  if (go.getId() == ID.AIEnemy && go != this) {
        		  if (getBounds().intersects(go.getBounds())) {
        			  handler.remove(go);
        		  }
        	  }
          }
          }catch(Exception e) {}
	
		handler.add(new BasicFX((int)x,(int)y,ID.FX,16,16,handler,new Color(100,30,30),0.05f));
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(new Color(100,30,30));
		g.fillRect((int)x, (int)y, 16, 16);
		
	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle((int)x,(int)y,32,32);
	}
	
	

}
