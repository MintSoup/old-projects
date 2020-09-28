import javax.swing.SwingUtilities;

public class Launch {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Menu menu = new Menu();
			}
		});
	}
}
