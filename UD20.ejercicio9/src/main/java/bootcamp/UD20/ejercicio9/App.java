package bootcamp.UD20.ejercicio9;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

public class App {
	public static void main(String[] args) {
		String opcion = JOptionPane.showInputDialog("Que ejercicio quieres corregir? 1 - MemoryGame con colores \n2- MemoryGame con Imagenes");
		switch(opcion){
		case "1":
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						MemoryGame frame = new MemoryGame();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
			break;
		case "2":
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						MemoryGameImages frame = new MemoryGameImages();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			break;
			default:
				JOptionPane.showMessageDialog(null, "Debes Introducir un 1 o un 2");		
		}
		
	}
}
