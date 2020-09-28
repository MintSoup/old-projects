package src.game.util;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Utils {
	
	public static boolean DEVMODE;
	public static final BufferedImage coin = loadImage("coin");
	public static boolean jar;
	public static boolean isDevmodeEnabled() {
		return DEVMODE;
	}
	
	public static Font getDefaultFontBySizeAndType(int size,int type) {
		return new Font("AR CENA",type,size);
	}
	
	public static URL getSoundURL(String name) {
		return Utils.class.getResource("/assets/audio/" + name );
	}
	
	private static BufferedImage loadImage(String name){
		try {
			return ImageIO.read(Utils.class.getResource("/assets/textures/" + name + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
