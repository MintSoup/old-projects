import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class Reciever extends JFrame implements Runnable {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JPasswordField passwordField;
	private JProgressBar progressBar;

	public Reciever() {
		
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
	
		Thread t = new Thread(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(425,216);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setTitle("Reciever");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Please fill in the form");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 231, 24);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("Start listening");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.start();
			}
		});
		btnNewButton.setBounds(10, 139, 157, 42);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("PASSWORD:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 96, 133, 32);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('X');
		passwordField.setBounds(153, 96, 218, 32);
		contentPane.add(passwordField);
		
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setBounds(10, 47, 403, 37);
		contentPane.add(progressBar);
		
		
		
		
		
	}
	
	
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(0,2);
			JOptionPane.showMessageDialog(null, "Started Listening.\nPort: " + ss.getLocalPort());
			lblNewLabel.setText("Listening on " + ss.getLocalPort());
			System.out.println(ss.getLocalPort());
			InputStream is;
			OutputStream os;
			Socket s;
			while(true) {
				s = ss.accept();
				is = s.getInputStream();
				os = s.getOutputStream();
				break;
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
			System.out.println("created i/o stuff");
			String password = br.readLine();
			System.out.println("password recieved");
			String pass = "";
			for (char c : passwordField.getPassword()) {
				System.out.println("wiiii");
				pass+=c;
			}
			if(password.equals(pass)) {
				System.out.println("good password!");
				bw.write("true");
				bw.newLine();
				bw.flush();
				float size = Float.parseFloat(br.readLine());
				
				FileOutputStream fos = new FileOutputStream("downloaded-file." + JOptionPane.showInputDialog("Enter the file format to save with (Without \".\""));
				int len;
				byte[] byt = new byte[1024];
				float downloaded = 0;
				
				System.out.println("recieving");
				while((len = is.read(byt)) > -1) {
					fos.write(byt,0,len);
					downloaded+=len;
					float percent = downloaded*100/size;
					progressBar.setValue((int) percent);
					
				}
				fos.close();
				ss.close();
				s.close();
				JOptionPane.showMessageDialog(null, "Done");
			}
			else {
				bw.write("false");
				bw.newLine();
				bw.flush();
				System.out.println("wrong password thingy");
				System.out.println(pass);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
