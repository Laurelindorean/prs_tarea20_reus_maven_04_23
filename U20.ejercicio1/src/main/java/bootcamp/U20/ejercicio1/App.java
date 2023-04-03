package bootcamp.U20.ejercicio1;

import java.awt.EventQueue;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
