package bootcamp.UD20.ejercicio6;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoAltura;
	private JTextField campoPeso;
	private JTextField campoIMC;

	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		setTitle("Indice de Masa Corporal");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		campoAltura = new JTextField();
		campoAltura.setBounds(129, 21, 86, 20);
		contentPane.add(campoAltura);
		campoAltura.setColumns(10);
		
		JLabel lblAltura = new JLabel("Altura (metros)");
		lblAltura.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAltura.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltura.setBounds(10, 23, 109, 14);
		contentPane.add(lblAltura);
		
		JLabel lblkg = new JLabel("Peso(kg)");
		lblkg.setHorizontalAlignment(SwingConstants.CENTER);
		lblkg.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblkg.setBounds(236, 24, 79, 14);
		contentPane.add(lblkg);
		
		campoPeso = new JTextField();
		campoPeso.setBounds(325, 21, 86, 20);
		contentPane.add(campoPeso);
		campoPeso.setColumns(10);
		
		JButton botonCalcular = new JButton("Calcular IMC");
		botonCalcular.addActionListener(this);
		botonCalcular.setBackground(new Color(192, 192, 192));
		botonCalcular.setFont(new Font("Tahoma", Font.BOLD, 12));
		botonCalcular.setBounds(87, 65, 109, 29);
		contentPane.add(botonCalcular);
		
		JLabel lblImc = new JLabel("IMC");
		lblImc.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblImc.setHorizontalAlignment(SwingConstants.CENTER);
		lblImc.setBounds(206, 69, 46, 21);
		contentPane.add(lblImc);
		
		campoIMC = new JTextField();
		campoIMC.setBounds(262, 70, 86, 20);
		contentPane.add(campoIMC);
		campoIMC.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		double altura = Double.parseDouble(campoAltura.getText());
		double peso = Double.parseDouble(campoPeso.getText());
		double imc = peso/(Math.pow(altura, 2));
		double imcRound = Math.round(imc*100.0)/100.0;//Redondeamos a 2 decimales para que quepa en el textField
		campoIMC.setText(String.valueOf(imcRound));
	}

}
