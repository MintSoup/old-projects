package src.game.main.gameobject.fx;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import src.game.main.Handler;
import src.game.main.gameobject.GameObject;
import src.game.util.ID;

public class BasicFX extends GameObject{


	private float alpha = 1;
	private Handler handler;
	private Color color;
	private int w,h;
	private float life;


	public BasicFX(int x, int y, ID id,int w,int h,Handler handler,Color img,float life) {
		super(x, y, id);
		this.handler = handler;
		color = img;
		this.w = w;
		this.h = h;
		this.life = life;
		
	}

	private AlphaComposite makeTransparent(float v){
		int type = AlphaComposite.SRC_OVER;
		return AlphaComposite.getInstance(type, v);
	}
	
	@Override
	public void tick() {
		
		super.tick();
		
		if(alpha > life) {
			alpha -= life-0.0001f;
		}else handler.remove(this);
		
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		g2d.setColor(color);
		g2d.fillRect((int)x, (int)y,w,h);

		g2d.setComposite(makeTransparent(1));
	}
	
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int) y,w,h);
	}

}
