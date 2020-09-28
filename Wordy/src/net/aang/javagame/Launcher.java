package net.aang.javagame;

import net.aang.javagame.util.AutoUpdate;
import net.aang.javagame.util.GameUtils;
import org.json.JSONException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Launcher {
    public static void main(String[] args) {
        GameUtils.init();

        String version = AutoUpdate.checkForUpdates();
        if (Double.parseDouble(version) > AutoUpdate.VERSION) {
            AutoUpdate.update(version);
        }

        JFrame frame = null;

        try {
            frame = new JFrame(GameUtils.data.getString("title"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        frame.getContentPane().setPreferredSize(new Dimension(1000, 500));
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        GameUtils.instance = new

                Game(frame);

        frame.addWindowListener(new

                                        WindowListener() {
                                            @Override
                                            public void windowOpened(WindowEvent e) {

                                            }

                                            @Override
                                            public void windowClosing(WindowEvent e) {
                                                GameUtils.instance.stop();
                                                System.exit(0);
                                            }

                                            @Override
                                            public void windowClosed(WindowEvent e) {


                                            }

                                            @Override
                                            public void windowIconified(WindowEvent e) {

                                            }

                                            @Override
                                            public void windowDeiconified(WindowEvent e) {

                                            }

                                            @Override
                                            public void windowActivated(WindowEvent e) {

                                            }

                                            @Override
                                            public void windowDeactivated(WindowEvent e) {

                                            }
                                        }

        );

        for (int i = 0; i < 5 && GameUtils.instance.getPreferredSize().width != GameUtils.instance.getSize().width; i++)
            frame.pack();

        frame.setVisible(true);
        GameUtils.instance.start();


    }
}
