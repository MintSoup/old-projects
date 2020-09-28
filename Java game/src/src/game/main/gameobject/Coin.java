package src.game.main.gameobject;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import src.game.main.Handler;
import src.game.util.ID;
import src.game.util.Utils;

public class Coin extends GameObject{

	public int ticksLeft = 120 * 5;
	private Handler handler;
	private int value;
	public int getValue() {
		return value;
	}



	public Coin(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		this.handler = handler;
		value = new Random().nextInt(25-5) + 5;
	}
	
	

	@Override
	public void tick() {
		
		super.tick();
		
		ticksLeft--;
		if(ticksLeft <= 0) handler.remove(this); 
		else {
			
		}
	}



	@Override
	public void render(Graphics g) {
		super.render(g);
		g.drawImage(Utils.coin, (int)x, (int)y, null);
	}



	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y,32,32);
	}

}
