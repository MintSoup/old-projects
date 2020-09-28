package gfx;

import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import tools.Methods;

public class AboutWindow extends JFrame {

	private JPanel contentPane;

	public AboutWindow() throws IOException {
		setVisible(true);
		setTitle("BatchStudio 1.0");
		
		for(LookAndFeelInfo lafi : UIManager.getInstalledLookAndFeels()){
			if(lafi.getName().equals("Nimbus")){
				try {
					UIManager.setLookAndFeel(lafi.getClassName());
					break;
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(),"Error",0);
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						break;
					} catch (Exception e1) {
						 JOptionPane.showMessageDialog(null,"WTF!!!");
						 System.exit(666);
					}
				}
			}
			
		}
	
		setTitle("About BatchStudio");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600,300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Methods.getTheme().bg);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 10, 574, 249);
		contentPane.add(scrollPane);
		Reader r=null;
		r = new InputStreamReader(getClass().getResourceAsStream("/bs/about.bstxt"));
		
		JTextArea textArea = new JTextArea();
	
		textArea.setEditable(false);
	
		scrollPane.setViewportView(textArea);
		textArea.setBackground(Methods.getTheme().editorBg);
		textArea.setFont(new Font("Calibri", Font.PLAIN, 20));
		textArea.read(r, null);
		
		
		setIconImage(ImageIO.read(getClass().getResource("/img/icon.png")));
	}
}
