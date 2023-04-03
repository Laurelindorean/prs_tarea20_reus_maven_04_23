package bootcamp.U20.ejercicio2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class View extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton boton1, boton2;
	private String texto;
	private JLabel etiqueta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the frame.
	 */
	public View() {
		setTitle("Ventana con interacción");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 221);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 75, 5, 5));
		setVisible(true);
		setResizable(true);
		setContentPane(contentPane);
		
		boton1 = new JButton("Boton 1");
		boton1.addActionListener(this);
		
		boton2 = new JButton("Boton 2");
		boton2.setHorizontalAlignment(SwingConstants.RIGHT);
		boton2.addActionListener(this);
		
		etiqueta = new JLabel();
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPane.add(boton1);
		contentPane.add(boton2);
		contentPane.add(etiqueta);
	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==boton1) {
			texto = boton1.getText();
			etiqueta.setText("Has pulsado: " + texto);
		}
		if(e.getSource()==boton2) {
			texto = boton2.getText();
			etiqueta.setText("Has pulsado: " + texto);
		}
		
	}
}
