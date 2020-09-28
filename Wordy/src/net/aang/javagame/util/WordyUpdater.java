package net.aang.javagame.util;

import org.json.JSONException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class WordyUpdater extends JFrame {

    private JPanel contentPane;
    private JLabel label1;
    private JProgressBar bar;
    public String link;

    public void startDownload() {


        try {

            URL url = new URL(link);
            URLConnection urlc = url.openConnection();

            int size = urlc.getContentLength();

            label1.setText("Downloading: " + (size / 1000000 + "MB"));
            bar.setMaximum(size);

            InputStream is = urlc.getInputStream();
            FileOutputStream fos = new FileOutputStream(String.format("Wordy-%s.jar", AutoUpdate.versionData.getString("latest")));

            int n = 0;
            float downloaded = 0;
            byte[] buffer = new byte[1024];
            while ((n = is.read(buffer)) > 0) {
                fos.write(buffer, 0, n);
                downloaded += n;
                bar.setValue((int) downloaded);
            }
            is.close();
            fos.close();
            JOptionPane.showMessageDialog(null,String.format("File downloaded (%s)",String.format("Wordy-%s.jar", AutoUpdate.versionData.getString("latest"))));
            System.exit(0);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public WordyUpdater(String link) {

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


        this.link = link;
        setResizable(false);
        setTitle("Downloading");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(326, 110);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);

        label1 = new JLabel("Downloading...");
        label1.setFont(new Font("Calibri", Font.BOLD, 23));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setBounds(10, 11, 300, 26);
        contentPane.add(label1);

        bar = new JProgressBar();
        bar.setStringPainted(true);
        bar.setBounds(10, 48, 300, 22);
        contentPane.add(bar);


        startDownload();
    }
}
