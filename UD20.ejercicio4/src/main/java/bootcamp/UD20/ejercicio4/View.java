package bootcamp.UD20.ejercicio4;

/**
 * Palmira
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class View extends JFrame implements WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;

	public View() {
		setTitle("Eventos Ventana");
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);//No queremos que la ventana se cierre para poder ver los diferentes eventos de ventana
		setBounds(100, 100, 450, 300);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		addWindowListener(this);

		setContentPane(contentPane);

		JLabel eventos = new JLabel("Eventos");
		eventos.setBounds(10, 108, 49, 15);
		eventos.setFont(new Font("Tahoma", Font.BOLD, 12));

		textArea = new JTextArea();
		textArea.setBounds(69, 33, 353, 196);
		textArea.setRows(50);
		textArea.setColumns(20);
		textArea.setText("Area de texto para los eventos:");
		contentPane.setLayout(null);
		contentPane.add(eventos);
		contentPane.add(textArea);

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		textArea.setText("Ventana Activada");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		textArea.setText("Ventana cerrandose");

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		textArea.setText("Ventana cerrada");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		textArea.setText("Ventana minimizada");
		//Añadimos algunos mensajes emergentes para poder comprobar los eventos que quedarian en segundo plano
		JOptionPane.showMessageDialog(null, "Ventana minimizada");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		textArea.setText("Ventana restaurada");
		//Añadimos algunos mensajes emergentes para poder comprobar los eventos que quedarian en segundo plano
		JOptionPane.showMessageDialog(null, "Ventana restaurada");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		textArea.setText("Ventana abierta");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		textArea.setText("Ventana desactivada");
	}
}
