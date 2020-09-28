package src.game.main.gameobject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import src.game.main.Game;
import src.game.main.Handler;
import src.game.main.gameobject.fx.BasicFX;
import src.game.main.gui_hud.HUD;
import src.game.util.ID;
import src.game.util.Sounds;
import src.game.util.Utils;

public class Player extends GameObject {
	
	private Handler handler;
	private HUD hud;
	
	public Player(int x, int y, ID id,Handler handler,HUD hud) {
		super(x, y, id);
		this.handler = handler;
		this.hud = hud;
	
	}

	@Override
	public void tick() {
		super.tick();
	
		x = Game.clamp(x, 0, Game.size.width-32);
		y = Game.clamp(y, 0, Game.size.height - 32);

		collide();

		handler.add(new BasicFX((int)x,(int)y,ID.FX,32,32,handler,new Color(0,255,0,100),0.12f));
	}

	private void collide() {
	
		for (int i = 0; i < handler.getObjects().size(); i++) {
			GameObject go = handler.getObjects().get(i);
			
			if (getBounds().intersects(go.getBounds()))
			{
				if(go.id == ID.BasicEnemy || go.id == ID.FastEnemy || go.id == ID.AIEnemy) {
					
				if(!Utils.isDevmodeEnabled())HUD.HP -= 1;
				
				}else if (go.getId() == ID.Coin) {
					Coin c = (Coin) go;
					hud.setMoney(hud.getMoney() + c.getValue());
					handler.remove(go);
					Sounds.coinCollect.play();
				}
			
				
			}
		}
	}
	
	@Override
	public void render(Graphics g) {
			
		g.setColor(Color.green);
		g.fillRect((int)x,(int)y,32,32);

		
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,32,32);
	}



}
