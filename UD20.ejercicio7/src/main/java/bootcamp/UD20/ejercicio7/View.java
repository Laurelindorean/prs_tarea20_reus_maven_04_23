package bootcamp.UD20.ejercicio7;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final double CAMBIO_EUROS = 166.386;
	private static final double CAMBIO_PTAS = 0.00601;
	
	private JPanel contentPane;
	private JTextField textMoneda;
	private JButton btnMoneda;
	private JButton btnCambio;
	private JButton btnPtasAEuros;
	private JLabel lblFinal;
	private double pesetas;
	private double euros;
	private JLabel lblResultado;

	/**
	 * Create the frame.
	 */
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
		btnPtasAEuros.setBounds(87, 94, 115, 23);
		contentPane.add(btnPtasAEuros);
		btnMoneda.setBounds(87, 94, 115, 23);
		contentPane.add(btnMoneda);

		btnCambio = new JButton("Cambiar");
		btnCambio.addActionListener(evento);
		btnCambio.setBounds(244, 94, 89, 23);
		contentPane.add(btnCambio);
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
				euros = Double.parseDouble(textMoneda.getText()) * CAMBIO_EUROS;
				double eurosRound = Math.round(euros * 100.0) / 100.0;
				lblFinal.setText(String.valueOf(eurosRound));
			}
			// Calculamos el cambio de Pesetas a Euros
			if (e.getSource() == btnPtasAEuros) {
				pesetas = Double.parseDouble(textMoneda.getText()) * CAMBIO_PTAS;
				double ptasRound = Math.round(pesetas * 100.0) / 100.0;
				lblFinal.setText(String.valueOf(ptasRound));
			}
		}
	};

}
