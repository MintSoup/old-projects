package net.aang.javagame.state;

import net.aang.javagame.ui.Button;
import net.aang.javagame.util.GameUtils;
import net.aang.javagame.util.SoundManager;
import org.json.JSONException;
import org.json.JSONObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static java.awt.Color.cyan;
import static java.awt.Color.red;

public class StateGame extends State {

    public int lvl = 0;
    public int lastIncrease = 0;
    public Button[] answers;
    public int difficultyIncrease;
    public Random r;
    public int letter = 4;
    public String word;
    public String correct;
    public int points;
    public double timeout = 5000;
    public double initialTimeout = timeout;
    public boolean reduce = true;

    @Override
    public void init() {
        id = 1;
        super.init();
        try {
            difficultyIncrease = GameUtils.data.getInt("difficultyIncrease");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        answers = new Button[5];
        answers[0] = new Button("A", new Font("Calibri", Font.PLAIN, 60), red, cyan, 10, 390, 180, 100, 60, 65);
        answers[1] = new Button("B", new Font("Calibri", Font.PLAIN, 60), red, cyan, 210, 390, 180, 100, 60, 65);
        answers[2] = new Button("C", new Font("Calibri", Font.PLAIN, 60), red, cyan, 410, 390, 180, 100, 60, 65);
        answers[3] = new Button("D", new Font("Calibri", Font.PLAIN, 60), red, cyan, 610, 390, 180, 100, 60, 65);
        answers[4] = new Button("E", new Font("Calibri", Font.PLAIN, 60), red, cyan, 810, 390, 180, 100, 60, 65);


        for (Button b :
                answers) {
            if (b != null) handler.add(b);
        }
        r = new Random();
    }

    @Override
    public void onEnterState() {
        super.onEnterState();
        lvl = 0;
        points = 0;
        letter = 4;
        lastIncrease = 0;
        try {
            GameUtils.loadJson();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        refresh();
    }

    @Override
    public void tick() {
        if(lvl!=0) {
            super.tick();
            if (reduce) {
                int dvd = GameUtils.instance._UPS != 0 ? GameUtils.instance._UPS : 30;
                timeout -= 1000 / dvd;

                if (!SoundManager.isPlaying("music.timer")) {
                    SoundManager.playMusic("music.timer");
                }
            } else {
                if (SoundManager.isPlaying("music.timer")) {
                    SoundManager.stopMusic("music.timer");
                }
            }
            if (timeout <= 0) {
                GameUtils.instance.setCurrentState(GameUtils.getState(GameUtils.getInt("state.gameover")));
                timeout = initialTimeout;
            }
        }
    }

    @Override
    public void render(Graphics2D g) {
        if(lvl!=0) {
            super.render(g);
            g.setColor(Color.blue);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Level " + lvl, 5, 20);
            g.drawString("Points: " + points, 5, 40);
            g.setFont(new Font("Calibri", Font.PLAIN, 100));

            FontMetrics fm = g.getFontMetrics();
            int x = ((1000 - fm.stringWidth(word)) / 2);


            g.drawString(word, x, 150);
            g.setColor(Color.gray);
            g.fillRoundRect(150, 50, 700, 15, 15, 15);
            g.setColor(Color.green);
            g.fillRoundRect(150, 50, (int) (timeout / (initialTimeout / 700)), 15, 15, 15);
        }else{
            g.setFont(new Font("Calibri", Font.PLAIN, 75));
            g.setColor(Color.cyan);
            g.drawString("Searching for a good word...", 50, 150);
        }
//        g.drawImage(camera.getImage(),0,0,null);
    }

    public void refresh() {
        if (lvl - lastIncrease >= difficultyIncrease) {
            lastIncrease = lvl;
            letter++;
        }
        timeout = initialTimeout;
        try {
            ArrayList<JSONObject> array = new ArrayList<JSONObject>();
            HashMap<JSONObject, Integer> maps = new HashMap<>();
            for (int i = 0; i < GameUtils.data.getJSONArray("words").length(); i++) {
                JSONObject e = GameUtils.data.getJSONArray("words").getJSONObject(i);
                if (e.getString("word").length() == letter) {
                    array.add(e);
                    maps.put(e, i);
                }
            }
            if (array.size() <= 0) {
                GameUtils.loadJson();
                lvl = 1;
                letter = 4;
                GameUtils.instance.setCurrentState(GameUtils.getState(GameUtils.getInt("state.menu")));
                return;
            }

            JSONObject e = array.get(r.nextInt(array.size()));
            GameUtils.data.getJSONArray("words").remove(maps.get(e));

            e.put("answers", GameUtils.shuffleString(e.getString("answers")));

            System.out.println(e.toString(4));

            for (int y = 0; y < e.getString("answers").toCharArray().length; y++) {

                answers[y].text = e.getString("answers").toUpperCase().toCharArray()[y] + "";
                if (answers[y].text.toLowerCase().equals(e.getString("correct"))) {
                    answers[y].onClick = () -> {
                        points++;
                        word = correct;
                        try {
                            reduce = false;
                            Thread.sleep(1500);
                            timeout = initialTimeout;
                            reduce = true;
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                        refresh();
                    };
                } else {
                    answers[y].onClick = () -> {
                        for (Button b : answers) {
                            try {
                                if (b.text.toLowerCase().equals(e.getString("correct"))) {
                                    b.bgcolor = new Color(0, 255, 0);
                                    word=correct;
                                    reduce = false;
                                    Thread.sleep(1500);
                                    timeout = initialTimeout;
                                    reduce = true;
                                }
                            } catch (JSONException | InterruptedException e1) {
                                e1.printStackTrace();
                            }
                        }
                        refresh();
                    };
                }
            }
            word = e.getString("mixed");
            correct = e.getString("word");
            correct = Character.toUpperCase(correct.charAt(0))+correct.substring(1,correct.length());
            lvl++;
        } catch (JSONException je) {
            je.printStackTrace();
        }
    }
}
