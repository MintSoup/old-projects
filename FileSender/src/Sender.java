import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Sender extends JFrame {

	private JPanel contentPane;
	private JButton btnChooseFile;
	private JTextField ipField;
	private JLabel lblIp;
	private JTextField portField;
	private JLabel lblPort;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private int returnVal;
	private File selectedFile;
	private JProgressBar pb;

	/*
	 JFileChooser chooser = new JFileChooser();
        
        int returnVal = chooser.showOpenDialog(Menu.this.getThis());
        if (returnVal == 0)
        {
          String ip = JOptionPane.showInputDialog("Enter the IP of the reciever (provided by the reciever)");
          int port = Integer.parseInt(JOptionPane.showInputDialog("Enter the port of the reciever (provided by the reciever"));
          String password = JOptionPane.showInputDialog("Enter the password.");
          try
          {
            Socket s = new Socket(InetAddress.getByName(ip), port);
            System.out.println("connected");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bw.write(password);
            bw.newLine();
            bw.flush();
            System.out.println("Password sent");
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String good = br.readLine();
            if (good.equals("true"))
            {
              System.out.println("Good password.");
              FileInputStream fis = new FileInputStream(chooser.getSelectedFile());
              bw.write(chooser.getSelectedFile().length());
              bw.newLine();
              bw.flush();
              
              byte[] buffer = new byte['?'];
              System.out.println("sending");
              final ProgressBarHolder pbh = new ProgressBarHolder();
              SwingUtilities.invokeLater(new Runnable()
              {
                public void run()
                {
                  Menu.this.initpbh(pbh);
                }
              });
              float size = (float)chooser.getSelectedFile().length();
              float read = 0.0F;
              int len;
              while ((len = fis.read(buffer)) > -1)
              {
                int len;
                s.getOutputStream().write(buffer, 0, len);
                s.getOutputStream().flush();
                read += len;
                pbh.getPB().setValue((int)(read * 100.0F / size));
              }
              s.getOutputStream().flush();
              bw.close();
              br.close();
              fis.close();
              s.close();
              pbh.close();
              JOptionPane.showMessageDialog(null, "Sent.");
            }
            else
            {
              s.close();
              JOptionPane.showMessageDialog(null, "Wrong password", "ERROR", 0);
              Menu.this.setVisible(false);
              Menu.this.dispose();
            }
          }
          catch (UnknownHostException e1)
          {
            e1.printStackTrace();
          }
          catch (IOException e1)
          {
            e1.printStackTrace();
          }
        }
      }
	 */
	
	
	public Sender() {
		setTitle("Sender");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(438,306);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		pb = new JProgressBar();
		pb.setStringPainted(true);
		pb.setBounds(10, 151, 416, 44);
		contentPane.add(pb);
		
		btnChooseFile = new JButton("Choose file");
		btnChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
		        
		        returnVal = chooser.showOpenDialog(getThis());
		        selectedFile = chooser.getSelectedFile();
			}
		});
		btnChooseFile.setFont(new Font("Arial", Font.PLAIN, 20));
		btnChooseFile.setBounds(10, 11, 146, 43);
		contentPane.add(btnChooseFile);
		
		ipField = new JTextField();
		ipField.setBounds(123, 56, 303, 28);
		contentPane.add(ipField);
		ipField.setColumns(10);
		
		lblIp = new JLabel("IP: ");
		lblIp.setFont(new Font("Arial", Font.PLAIN, 20));
		lblIp.setBounds(20, 61, 52, 18);
		contentPane.add(lblIp);
		
		portField = new JTextField();
		portField.setColumns(10);
		portField.setBounds(123, 86, 303, 28);
		contentPane.add(portField);
		
		lblPort = new JLabel("Port: ");
		lblPort.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPort.setBounds(20, 91, 52, 18);
		contentPane.add(lblPort);
		
		lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPassword.setBounds(20, 121, 100, 18);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(123, 118, 303, 28);
		contentPane.add(passwordField);
		
		btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runnable runnable = new Runnable() {

					@Override
					public void run() {
						 if (returnVal == 0)
					        {
					          
					          int port = Integer.parseInt(portField.getText());
					          String password = "";
					          for (char c : passwordField.getPassword()) {
					        	  password+=c;
					          }
					          try
					          {
					            Socket s = new Socket(InetAddress.getByName(ipField.getText()), port);
					            System.out.println("connected");
					            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
					            bw.write(password);
					            bw.newLine();
					            bw.flush();
					            System.out.println("Password sent");
					            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
					            String good = br.readLine();
					            if (good.equals("true"))
					            {
					              System.out.println("Good password.");
					              FileInputStream fis = new FileInputStream(selectedFile);
					              bw.write(selectedFile.length() + "");
					              bw.newLine();
					              bw.flush();
					              
					              byte[] buffer = new byte[1024];
					              System.out.println("sending");
					           
					            
					              float size = (float)selectedFile.length();
					              float read = 0.0F;
					              int len;
					              while ((len = fis.read(buffer)) > -1)
					              {
					              
					                s.getOutputStream().write(buffer, 0, len);
					                s.getOutputStream().flush();
					                read += len;
					                pb.setValue((int) (read*100/size));
					              }
					              s.getOutputStream().flush();
					              bw.close();
					              br.close();
					              fis.close();
					              s.close();
					             
					              JOptionPane.showMessageDialog(null, "Sent.");
					            }
					            else
					            {
					              s.close();
					              JOptionPane.showMessageDialog(null, "Wrong password", "ERROR", 0);
					              setVisible(false);
					              dispose();
					            }
					          }
					          catch (UnknownHostException e1)
					          {
					            e1.printStackTrace();
					          }
					          catch (IOException e1)
					          {
					            e1.printStackTrace();
					          }
					       
					       }
						
					}};
					Thread t = new Thread(runnable);
					t.start();
				}
			});
		
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 40));
		btnNewButton.setBounds(10, 207, 416, 59);
		contentPane.add(btnNewButton);
	
	}

	protected Sender getThis() {
		
		return this;
	}
}
