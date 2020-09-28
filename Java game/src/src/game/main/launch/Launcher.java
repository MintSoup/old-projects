package src.game.main.launch;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.net.URISyntaxException;

import src.game.main.Game;
import src.game.util.Utils;

public class Launcher {
	public static Game game;

	
	public static void main(String[] areg) {
		
		try {
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(Font.createFont(Font.TRUETYPE_FONT, Launcher.class.getResourceAsStream("/assets/font/ARCENA.fnt")));
		} catch (FontFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			if(areg[0].equals("-ENABLE_DEVMODE")) {
				Utils.DEVMODE = true;
				System.out.println("----------LAUNCHING WITH DEVMODE ENABLED----------");
			}
			else Utils.DEVMODE = false;
			if(areg[1].equals("-nojar") || areg[0].equals("-nojar")) {
				Utils.jar = false;
			}
			else Utils.jar = true;
		}catch(ArrayIndexOutOfBoundsException e) {}
		
		
		try {
			game = new Game();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
