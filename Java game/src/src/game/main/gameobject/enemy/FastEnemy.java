package src.game.main.gameobject.enemy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import src.game.main.Game;
import src.game.main.Handler;
import src.game.main.gameobject.GameObject;
import src.game.main.gameobject.fx.BasicFX;
import src.game.util.ID;

public class FastEnemy extends GameObject {

	private Handler handler;
	
	public FastEnemy(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		
		Random r = new Random();
		
		boolean vX = 1 == r.nextInt(2);
		boolean vY = 1 == r.nextInt(2);
		
		velX = 3.7;
		velY = 3.7;
		
		if(vX) velX*=-1;
		if(vY) velY*=-1;
		
		this.handler = handler;
	}

	@Override
	public void tick() {
		super.tick();
	
		
		if(y <= 0 || y>=Game.size.height-16) velY *= -1;
		if(x <= 0 || x>=Game.size.width-16) velX *= -1;
		
	
		
		handler.add(new BasicFX((int)x,(int)y,ID.FX,16,16,handler,Color.ORANGE,0.05f));
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect((int)x, (int)y, 16, 16);
		
	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle((int)x,(int)y,32,32);
	}
	
	

}
