package src.game.util;

import kuusisto.tinysound.Music;
import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;

public class Sounds {
	public static final Music music = TinySound.loadMusic(Utils.getSoundURL("music.wav"));
	public static final Sound spawn = TinySound.loadSound(Utils.getSoundURL("spawn.wav"));
	public static final Sound coinCollect = TinySound.loadSound(Utils.getSoundURL("coinCollect.wav"));
}
