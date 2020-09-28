package gfx;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import tools.Methods;
import static tools.Methods.*;
public class Window extends JFrame {

	private JPanel contentPane;
	private JSeparator separator;
	public Window(){

		setTitle("BatchStudio 1.5");
		
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
	
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(626, 393);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Methods.getTheme().bg);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel wlc = new JLabel("Welcome to BatchStudio 1.5");
		wlc.setForeground(Methods.getTheme().labelFg);
		wlc.setFont(new Font("Calibri", Font.BOLD, 40));
		wlc.setBounds(50, 33, 507, 43);
		contentPane.add(wlc);
		
		JButton btnNewButton = new JButton("New Project");
		btnNewButton.setVisible(true);
		btnNewButton.setBackground(getTheme().buttonBg);
		btnNewButton.setForeground(getTheme().buttonTxt);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newProject();
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 36));
		btnNewButton.setBounds(37, 101, 222, 92);
		contentPane.add(btnNewButton);
		
		JButton btnOpenFile = new JButton("Open file");
		btnOpenFile.setBackground(getTheme().buttonBg);
		btnOpenFile.setForeground(getTheme().buttonTxt);
		btnOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open();
				    
			}
		});
		btnOpenFile.setFont(new Font("Calibri", Font.BOLD, 36));
		btnOpenFile.setBounds(352, 101, 222, 92);
		contentPane.add(btnOpenFile);
		
		JButton btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{new AboutWindow();}catch(Exception ex){ex.printStackTrace();JOptionPane.showMessageDialog(null, "Couldn't find the about.bstxt file.","Error",0);}
			}
		});
		btnAbout.setBackground(getTheme().buttonBg);
		btnAbout.setForeground(getTheme().buttonTxt);
		btnAbout.setFont(new Font("Calibri", Font.BOLD, 36));
		btnAbout.setBounds(37, 225, 222, 92);
		contentPane.add(btnAbout);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBackground(getTheme().buttonBg);
		btnExit.setForeground(getTheme().buttonTxt);
		btnExit.setFont(new Font("Calibri", Font.BOLD, 36));
		btnExit.setBounds(352, 225, 222, 92);
		contentPane.add(btnExit);
		
		separator = new JSeparator();
		separator.setBounds(37, 76, 537, 14);
		contentPane.add(separator);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/img/icon.png")));
	}
	protected void open() {
		 JFileChooser chooser = new JFileChooser(System.getProperty("user.home")+"/Desktop");
		  FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "Batch Files (BAT, CMD)", "bat", "cmd");
		    chooser.setFileFilter(filter);
			  int x = chooser.showOpenDialog(this);
			  if(x==JFileChooser.APPROVE_OPTION){
				  File theFile = chooser.getSelectedFile();
					
					if (!(theFile.exists())){
						JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					else{
					
				int conf = JOptionPane.showConfirmDialog(null, "The file " + theFile.getAbsolutePath() +" will be opened.","Confirm", JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
				  if(conf == 0){Methods.newEditor(theFile,this);setVisible(false);}
				  else return;
					}
			  }
			  else{
				 return; 
			  }
	}
	protected void newProject() {
		  JFileChooser chooser = new JFileChooser(System.getProperty("user.home")+"/Desktop");
		  FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "Batch Files (BAT, CMD)", "bat", "cmd");
		    chooser.setFileFilter(filter);
		    
		  int x = chooser.showSaveDialog(this);
		  if(x==JFileChooser.APPROVE_OPTION){
			  File theFile = chooser.getSelectedFile();
			  if(!(theFile.getAbsolutePath().endsWith(".bat") || theFile.getAbsolutePath().endsWith(".cmd"))){theFile = new File(theFile.getAbsolutePath()+".cmd");}
			int conf = JOptionPane.showConfirmDialog(null, "The file " + theFile.getAbsolutePath() +" will be opened.","Confirm", JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
			  if(conf == 0){try {
				Methods.newFile(theFile);
				Methods.newEditor(theFile,this);
				setVisible(false);
			} catch (IOException e1) {
				e1.printStackTrace();
			}}
			  else return;
		  }
		  else{
			 return; 
		  }
		
	}
}
