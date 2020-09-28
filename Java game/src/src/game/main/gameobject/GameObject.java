package src.game.main.gameobject;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import src.game.util.ID;


public abstract class GameObject extends Object{
	
	protected double x,y;
	protected double velX,velY;
	protected ID id;
	
	public GameObject(int x,int y,ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public void tick() {
		x+=velX;
		y+=velY;
	}
	public void render(Graphics g) {
		BufferedImage x;
		
	}
	
	public abstract Rectangle getBounds();
	
	
	
	
	
	
//-------------------------------------GETTER--SETTER--------------------------------------------------------------------------------------	

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getVelX() {
		return velX;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}
}
