package bootcamp.UD20.ejercicio8;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class View extends JFrame {

	private JPanel contentPane;
	private JTextField textMoneda;
	private JButton btnMoneda;
	private JButton btnCambio;
	private JButton btnPtasAEuros;
	private JLabel lblFinal;
	private double pesetas;
	private double euros;
	private JLabel lblResultado;
	private JButton btnBorrar;

	public View() {
		setTitle("Calculadora cambio de monedas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblConvertir = new JLabel("Cantidad a convertir");
		lblConvertir.setHorizontalAlignment(SwingConstants.CENTER);
		lblConvertir.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConvertir.setBounds(10, 47, 137, 14);
		contentPane.add(lblConvertir);

		textMoneda = new JTextField();
		textMoneda.setBounds(148, 44, 86, 20);
		contentPane.add(textMoneda);
		textMoneda.setColumns(10);

		lblResultado = new JLabel("Resultado");
		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setBounds(244, 47, 68, 14);
		contentPane.add(lblResultado);

		lblFinal = new JLabel("");
		lblFinal.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lblFinal.setBounds(321, 44, 97, 20);
		contentPane.add(lblFinal);

		btnMoneda = new JButton("Euros a Ptas");
		btnMoneda.addActionListener(evento);

		btnPtasAEuros = new JButton("Ptas a Euros");
		btnPtasAEuros.addActionListener(evento);
		btnPtasAEuros.setVisible(false);
		btnPtasAEuros.setBounds(59, 94, 115, 23);
		contentPane.add(btnPtasAEuros);
		btnMoneda.setBounds(59, 94, 115, 23);
		contentPane.add(btnMoneda);

		btnCambio = new JButton("Cambiar");
		btnCambio.addActionListener(evento);
		btnCambio.setBounds(184, 94, 89, 23);
		contentPane.add(btnCambio);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(evento);
		btnBorrar.setBounds(283, 94, 89, 23);
		contentPane.add(btnBorrar);
	}

	ActionListener evento = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// Si accionamos el boton Cambio se intercambia la visibilidad de los botones.
			if (e.getSource() == btnCambio) {
				if (btnMoneda.isVisible()) {
					btnMoneda.setVisible(false);
					btnPtasAEuros.setVisible(true);
				} else {
					btnPtasAEuros.setVisible(false);
					btnMoneda.setVisible(true);
				}
			}
			// Calculamos el cambio de Euros a Pesetas
			if (e.getSource() == btnMoneda) {
				euros = Double.parseDouble(textMoneda.getText()) * 166.386;
				double eurosRound = Math.round(euros * 100.0) / 100.0;
				lblFinal.setText(String.valueOf(eurosRound));
			}
			// Calculamos el cambio de Pesetas a Euros
			if (e.getSource() == btnPtasAEuros) {
				pesetas = Double.parseDouble(textMoneda.getText()) * 0.0060;
				lblFinal.setText(String.valueOf(pesetas));
			}
			if(e.getSource() == btnBorrar) {
				textMoneda.setText("");
				lblFinal.setText("");
			}
		}
	};
	

}
