package bootcamp.U20.ejercicio1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class View extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public View() {
		setTitle("Ejercicio 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel etiqueta = new JLabel("Etiqueta Custom");
		etiqueta.setBounds(134, 50, 147, 30);
		etiqueta.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(etiqueta);
		setResizable(true);
		setVisible(true);
	}
}
