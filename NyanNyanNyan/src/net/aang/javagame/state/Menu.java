package net.aang.javagame.state;

import net.aang.javagame.ui.Button;
import net.aang.javagame.util.GameUtils;
import net.aang.javagame.util.SoundManager;

import java.awt.*;

public class Menu extends State {

	public Button play;

	@Override
	public void onEnterState() {
        StateGame g = (StateGame) GameUtils.getState(GameUtils.getInt("state.play"));
		SoundManager.stopMusic("music.timer");

    }

	@Override
	public void init() {
		id=-1;
		super.init();
		this.play = new Button("Play", new Font("Arial",Font.BOLD,50), Color.RED, Color.CYAN, 50, 50, 200, 100, 40,60);
		play.onClick = () -> GameUtils.instance.setCurrentState(GameUtils.getState(GameUtils.getInt("state.play")));
		handler.add(this.play);
	}
	
	@Override
	public void tick() {
		super.tick();
	}

	@Override
	public void render(Graphics2D g) {
		super.render(g);
	}

}
