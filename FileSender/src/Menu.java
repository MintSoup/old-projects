import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnRecieveFiles;

	public Menu() {
		setResizable(false);
		setTitle("File Sender");
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
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(356,178);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		btnNewButton = new JButton("Send files");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Sender();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 11, 330, 56);
		contentPane.add(btnNewButton);
		
		btnRecieveFiles = new JButton("Recieve files");
		btnRecieveFiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new Reciever();
					}
				});
			}
		});
		btnRecieveFiles.setFont(new Font("Arial", Font.PLAIN, 20));
		btnRecieveFiles.setBounds(10, 79, 330, 56);
		contentPane.add(btnRecieveFiles);
	}

	protected Menu getThis() {
		
		return this;
	}
	
}
