package src.game.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;

public class Window extends Canvas{

	private static final long serialVersionUID = 8694490071911892220L;
	
	public Window(Dimension d,String title,final Game game){
		JFrame frame = new JFrame(title);
		frame.setUndecorated(true);
		frame.add(game);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
	
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/favicon.PNG")));
		frame.setSize(d.width + 30,d.height+30);
		frame.setLocationRelativeTo(null);
		frame.setShape(new RoundRectangle2D.Double(0, 0, 880, 880/12*9, 15, 15));
		

		
		frame.setVisible(true);
		

		frame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				game.stop();
				System.exit(0);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		game.start();
		
	}

}
