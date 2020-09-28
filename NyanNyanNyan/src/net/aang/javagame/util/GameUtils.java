package net.aang.javagame.util;

import kuusisto.tinysound.TinySound;
import net.aang.javagame.Game;
import net.aang.javagame.state.GameOver;
import net.aang.javagame.state.Menu;
import net.aang.javagame.state.State;
import net.aang.javagame.state.StateGame;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GameUtils {

    public static JSONObject data;
    public static JSONObject ref;
    public static Game instance;
    public static ArrayList<State> states = new ArrayList<State>();

    public static URL getRes(String path) {
        return GameUtils.class.getResource(path);
    }

    public static InputStream getResStream(String path) {
        ;
        try {
            return getRes(path).openStream();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static void init() {
        try {
            loadJson();
            states.add(new Menu());
            states.add(new StateGame());
            states.add(new GameOver());

            for (State s : states) {
                s.init();
            }
            TinySound.init();
            SoundManager.init();

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static String fmt(double d)
    {
        if(d == (long) d)
            return String.format("%d",(long)d);
        else
            return String.format("%s",d);
    }


    public static double clamp(double i, double min, double max) {
        if (i >= max)
            return i = max;
        else if (i <= min)
            return i = min;
        else return i;
    }

    public static void loadJson() throws JSONException {
        long then = System.currentTimeMillis();
        data = new JSONObject(new JSONTokener(getResStream("/dictionary.json")));
        System.out.println("Time Taken " + (System.currentTimeMillis()-then)/1000);
        ref = new JSONObject(new JSONTokener(getResStream("/resref.json")));
    }

    public static String getString(String id) {
        try {
            return ref.getString(id);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static int getInt(String id) {
        try {
            return ref.getInt(id);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Integer.MIN_VALUE;
    }

    public static State getState(int id) {
        for (State t : states) {
            if (t.id == id) return t;
        }
        return null;
    }

    public static String shuffleString(String input) {
        List<Character> characters = new ArrayList<Character>();
        for(char c:input.toCharArray()){
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(input.length());
        while(characters.size()!=0){
            int randPicker = (int)(Math.random()*characters.size());
            output.append(characters.remove(randPicker));
        }
        return output.toString();
    }

}
