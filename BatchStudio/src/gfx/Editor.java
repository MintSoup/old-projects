package gfx;

import static tools.Methods.getTheme;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

import tools.Methods;

public class Editor extends JFrame {
	
	protected RSyntaxTextArea textPane;
	protected File file;
	private JPanel contentPane;
	private JMenu mnProject;
	private JMenuItem mntmCommandlineArguments;
	
	
//---------------------------------------------------------------------------------------------------
	
	
	public File getFile() {
		return file;
	}
	public Editor(File file,final Window w) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Editor.class.getResource("/img/icon.png")));
		
	
	
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				saveOld();
				w.setVisible(true);
				setVisible(false);
			}
		});
		setTitle("BatchStudio 1.1");
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
		this.file = file;
		
		setResizable(false);
		setVisible(true);
		setTitle(file.getAbsolutePath());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 779, 537);
		contentPane = new JPanel();
		contentPane.setBackground(getTheme().bg);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(getTheme().buttonBg);
		btnNewButton.setIcon(new ImageIcon(Editor.class.getResource("/img/save.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		btnNewButton.setFocusPainted(false);
		
		btnNewButton.setBounds(10, 30, 48,48);
		contentPane.add(btnNewButton);
		
	      textPane = new RSyntaxTextArea();
	      
	      textPane.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_WINDOWS_BATCH);
	      textPane.setCodeFoldingEnabled(false);
	      textPane.setBackground(getTheme().editorBg);
	      RTextScrollPane sp = new RTextScrollPane(textPane);
	      sp.setVerticalScrollBarPolicy(RTextScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	      sp.setHorizontalScrollBarPolicy(RTextScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	      sp.setBounds(10, 89, 753, 408);
	      
	      contentPane.add(sp);
	      try {
	    	  FileReader fr = new FileReader(file);
			textPane.read(fr, null);
			fr.close();
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		JButton button = new JButton("");
		button.setBackground(getTheme().buttonBg);
		button.setIcon(new ImageIcon(Editor.class.getResource("/img/open.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 openFile(w);
			}
		});
		
	  
		button.setFocusPainted(false);
		button.setBounds(100, 30, 48, 48);
		contentPane.add(button);
		
		
		JButton button_1 = new JButton("");
		button_1.setBackground(getTheme().bg);
		button_1.setIcon(new ImageIcon(Editor.class.getResource("/img/run.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				run();
			}
		});
		button_1.setBounds(190, 30, 48, 48);
	
		contentPane.add(button_1);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 936, 21);
		contentPane.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		mnFile.add(mntmSave);
		
		JMenuItem mntmSaveAs = new JMenuItem("Save as");
		mntmSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				saveOld();
			
				JFileChooser jfc = new JFileChooser(System.getProperty("user.home")+"/Desktop");
				
				  FileNameExtensionFilter filter = new FileNameExtensionFilter(
					      "Batch Files (BAT, CMD)", "bat", "cmd");
				    jfc.setFileFilter(filter);
				int op = jfc.showSaveDialog(null);
				if(op==JFileChooser.APPROVE_OPTION){
					  File theFile = jfc.getSelectedFile();
					  if(!(theFile.getAbsolutePath().endsWith(".bat") || theFile.getAbsolutePath().endsWith(".cmd"))){theFile = new File(theFile.getAbsolutePath()+".cmd");}
					int conf = JOptionPane.showConfirmDialog(null, "The file " + theFile.getAbsolutePath() +" will be opened.","Confirm", JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
					
					  if(conf == 0){
						  
						  FileOutputStream fos = new FileOutputStream(theFile);
						  FileInputStream fis = new FileInputStream(getFile());
						  
						  int len;
						  byte[] b = new byte[2048];
						  
						  while((len = fis.read(b))> 0) {
							  fos.write(b, 0, len);
						  }
						  fos.close();
						  fis.close();
						  Methods.newEditor(theFile,w);
					  }
				}
				else{};
				
				}catch(Exception exx){exx.printStackTrace();System.exit(1);}	    
			}

			
		});
		
		mnFile.add(mntmSaveAs);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile(w);
			}
		});
		mnFile.add(mntmOpen);
		
		mnProject = new JMenu("Project");
		menuBar.add(mnProject);
		
		mntmCommandlineArguments = new JMenuItem("Command-line arguments...");
		mntmCommandlineArguments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CmdLineArguments();
			}
		});
		mnProject.add(mntmCommandlineArguments);
		
		try {
			FileInputStream fis = new FileInputStream(file);
			fis.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		save();
	
	}
	protected void run() {
	
		
	
		try {
			ArrayList<String> temp = new ArrayList<String>();
			temp.addAll(Arrays.asList(new String[] {"cmd","/k","start \"",file.getCanonicalPath(), "\""}));
			temp.addAll(Arrays.asList(Methods.getCmdline()));
			
			String [] concatedArgs = temp.toArray(new String[new String[] {"cmd","/k","start \"",file.getCanonicalPath(), "\""}.length+Methods.getCmdline().length]);
			ProcessBuilder pb = new ProcessBuilder(concatedArgs);
			pb.directory(file.getParentFile());
			Process p = pb.start();
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	public void openFile(Window w) {
		saveOld();
		 JFileChooser chooser = new JFileChooser(System.getProperty("user.home")+"/Desktop");
		  FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "Batch Files (BAT, CMD)", "bat", "cmd");
		    chooser.setFileFilter(filter);
		    
		  int x = chooser.showSaveDialog(this);
		  if(x==JFileChooser.APPROVE_OPTION){
			  
			  File theFile = chooser.getSelectedFile();
			  if(theFile.exists()) {
			  if(!(theFile.getAbsolutePath().endsWith(".bat") || theFile.getAbsolutePath().endsWith(".cmd"))){theFile = new File(theFile.getAbsolutePath()+".cmd");}
			int conf = JOptionPane.showConfirmDialog(null, "The file " + theFile.getAbsolutePath() +" will be opened.","Confirm", JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
			  if(conf == 0){Methods.newEditor(theFile,w);}
			  else return;
		  }
			  else {
					JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
					return;
			  }
		  }
		  else{
			 return; 
		  }
	}
		
	private void save() {
		try {
			FileWriter fw = new FileWriter(file);
			
			textPane.write(fw);
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void setTitle(String title){
		super.setTitle(title + " - BatchStudio");
		
	}
	protected void saveOld(){
		int a;
		a = JOptionPane.showConfirmDialog(null, "Do you want to save file " + getFile().getAbsolutePath() + "?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(a == 0){
			save();
		}
		else{};
		
	}
}
