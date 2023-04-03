package bootcamp.UD20.ejercicio2;

import java.awt.EventQueue;

public class MainApp {
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
