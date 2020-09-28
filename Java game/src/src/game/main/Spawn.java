package src.game.main;

import java.util.Random;

import src.game.main.gameobject.Coin;
import src.game.main.gameobject.GameObject;
import src.game.main.gameobject.enemy.AIEnemy;
import src.game.main.gameobject.enemy.BasicEnemy;
import src.game.main.gameobject.enemy.FastEnemy;
import src.game.main.gui_hud.HUD;
import src.game.util.ID;
import src.game.util.Sounds;

public class Spawn {

	private Handler handler;
	private HUD hud;
	private Random r = new Random();

	public Spawn(Handler j,HUD hud) {
		handler = j;
		this.hud = hud;
	}
	
	public void tick() {
		
		if(hud.getScore() >= 600) {
			hud.setScore(hud.getScore()-600);;
			hud.setLvl(hud.getLvl()+1);
			
			boolean coin = false;
			for (int i = 0; i < handler.getObjects().size(); i++) {
				GameObject go = handler.getObjects().get(i);
				if(go.getId() == ID.Coin) {
					coin = true;
				}
			}
			if(!coin) {
				Random r = new Random();
				handler.add(new Coin(r.nextInt(Game.size.width-32), r.nextInt(Game.size.height-32), ID.Coin, handler));
			}
			
			if(hud.getLvl() <= 3) {
				

				handler.add(new BasicEnemy(r.nextInt(Game.size.width-16), r.nextInt(Game.size.height-16), ID.BasicEnemy, handler));
				Sounds.spawn.play();
			
			}
			else if (hud.getLvl() >= 4 && hud.getLvl() <= 7) {
				handler.add(new FastEnemy(r.nextInt(Game.size.width-16),r.nextInt(Game.size.height-16),ID.FastEnemy,handler));
				Sounds.spawn.play();
			}
			else if (hud.getLvl() == 8) {
				handler.add(new AIEnemy(r.nextInt(Game.size.width-16),r.nextInt(Game.size.height-16),ID.AIEnemy,handler));
				Sounds.spawn.play();
			}
			else if (hud.getLvl() > 8) {
				int s = r.nextInt(3);
				Sounds.spawn.play();
				if(s == 0)
					handler.add(new FastEnemy(r.nextInt(Game.size.width-16),r.nextInt(Game.size.height-16),ID.FastEnemy,handler));
					
				else 
					handler.add(new BasicEnemy(r.nextInt(Game.size.width-16), r.nextInt(Game.size.height-16), ID.BasicEnemy, handler));
			}
		
		}
		
		
	}

}
