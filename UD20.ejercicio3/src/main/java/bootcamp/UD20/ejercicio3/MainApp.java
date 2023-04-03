package bootcamp.UD20.ejercicio3;

import java.awt.EventQueue;

/**
 * Hello world!
 *
 */
public class MainApp {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
