package bootcamp.UD20.ejercicio3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class View extends JFrame implements ActionListener{


	private static final long serialVersionUID = 1L;
	private JButton boton1, boton2;
	private JLabel lblboton1, lblboton2;
	private int contadorBoton1 = 0;
	private int contadorBoton2 = 0;

	/**
	 * Create the frame.
	 */
	public View() {
		setTitle("Ventana con más interacción");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 322);
		getContentPane().setLayout(null);
	
		
		boton1 = new JButton("Boton 1");
		boton1.addActionListener(this);
		boton1.setBounds(58, 77, 89, 23);
		getContentPane().add(boton1);
		
		boton2 = new JButton("Boton 2");
		boton2.addActionListener(this);
		boton2.setBounds(212, 77, 89, 23);
		getContentPane().add(boton2);
		
		lblboton1 = new JLabel("Boton 1: 0 veces");
		lblboton1.setHorizontalAlignment(SwingConstants.CENTER);
		lblboton1.setBounds(45, 34, 113, 23);
		getContentPane().add(lblboton1);
		
		lblboton2 = new JLabel("Boton 2: 0 veces");
		lblboton2.setHorizontalAlignment(SwingConstants.CENTER);
		lblboton2.setBounds(199, 33, 113, 25);
		getContentPane().add(lblboton2);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==boton1) {		
			contadorBoton1++;
			lblboton1.setText("Boton 1: " + contadorBoton1 + " veces.");
		}
		if(e.getSource()==boton2) {
			contadorBoton2++;
			lblboton2.setText("Boton 2: " + contadorBoton2 + " veces.");
		}
		
	}
	
	

}
