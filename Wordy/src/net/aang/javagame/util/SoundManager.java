package net.aang.javagame.util;

import kuusisto.tinysound.Music;
import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by DeLL on 31/05/2016.
 */
public class SoundManager {

    public static HashMap<String, Sound> sounds = new HashMap<>();
    public static HashMap<String, Music> musics = new HashMap<>();

    public static void init() {
        try {
            Iterator<String> array = GameUtils.ref.keys();
            while (array.hasNext()) {
                String key = array.next();
                if (key.startsWith("sound.")) {
                    sounds.put(key, TinySound.loadSound(GameUtils.getRes(GameUtils.ref.getString(key))));
                }
                else if (key.startsWith("music.")) {
                    musics.put(key, TinySound.loadMusic(GameUtils.getRes(GameUtils.ref.getString(key))));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void playSound(String e){
        sounds.get(e).play();
    }
    public static void stopSound(String e){sounds.get(e).stop();}
    public static void playMusic(String e){ musics.get(e).play(true);}
    public static void stopMusic(String e){
        musics.get(e).stop();
    }
    public static boolean isPlaying(String e) {return musics.get(e).playing();}
    public static boolean done(String e) {return musics.get(e).done();}


}

