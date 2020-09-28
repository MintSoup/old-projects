package net.aang.javagame.util;

import mf.MFDownloadLinkFinder;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by DeLL on 07/06/2016.
 */
public class AutoUpdate {

    public static JSONObject versionData = null;
    public static final double VERSION = 0;

    public static void getVersionData() {

        try {
            URL versiondatalink = new URL("http://pastebin.com/raw.php?i=k5FbPswT");
            InputStream is;
            is = versiondatalink.openStream();
            versionData = new JSONObject(new JSONTokener(is));
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public static String checkForUpdates() {
        if (versionData == null) getVersionData();
        String s = "";
        try {
            s = versionData.getString("latest");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        for (UIManager.LookAndFeelInfo lafi : UIManager.getInstalledLookAndFeels()) {
            if (lafi.getName().equals("Nimbus")) {
                try {
                    UIManager.setLookAndFeel(lafi.getClassName());
                    break;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", 0);
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                        break;
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, "crap happened");
                        System.exit(767);
                    }
                }
            }

        }

        if (Double.parseDouble(s) > VERSION) {
            int x = JOptionPane.showConfirmDialog(null, String.format("New version found (%s). It is strongly recommended to update. Update?", s), "Update?", JOptionPane.YES_NO_OPTION);
            if (x == 0) {
                return s;
            } else return String.valueOf(VERSION);
        } else return String.valueOf(VERSION);

    }

    public static void update(String version) {
        try {
            String link = MFDownloadLinkFinder.findMediaFireDownloadLink(versionData.getString(version));
            System.out.println("lalalla");
            WordyUpdater updater = new WordyUpdater(link);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

