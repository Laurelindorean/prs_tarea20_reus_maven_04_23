package bootcamp.UD20.ejercicio5;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputAdapter;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.ActionEvent;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton boton;
	private JTextArea texto;

	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);
		setContentPane(contentPane);

		contentPane.setLayout(null);

		boton = new JButton("Limpiar");
		boton.setBounds(172, 10, 89, 23);
		contentPane.add(boton);
		texto = new JTextArea();
		texto.setBounds(47, 63, 334, 143);
		contentPane.add(texto);

		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Cuando clickemos el botón se borrará el texto
				texto.setText("");
			}
		});
		MouseListener eventoR = new EventosRaton();
		texto.addMouseListener(eventoR);
		


	}

	class EventosRaton extends MouseInputAdapter {
		//Contemplamos los eventos de ratón más importantes. 
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseClicked(e);
			texto.setText("Has clickado");
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mousePressed(e);
			texto.setText("Estas presionando el ratón");
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseReleased(e);
			texto.setText("Has soltado el ratón");
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseEntered(e);
			texto.setText("El puntero está en el area de texto");
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseExited(e);
			texto.setText("El puntero está fuera del area de texto");
		}

	}
}
