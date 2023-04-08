package bootcamp.UD20.ejercicio9;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.Timer;

public class MemoryGame extends JFrame implements ActionListener {

	/**
	 * @author Palmira
	 */
	private static final long serialVersionUID = -5468290645557986484L;
	private JPanel contentPane;
	private ArrayList<JToggleButton> listaBotones = new ArrayList<>();
	private Color[] colores = { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA, Color.ORANGE,
			Color.PINK, Color.CYAN };

	private static int turno = 0;
	private JToggleButton botonPrev = null;
	private JToggleButton botonPost = null;
	private Timer timer;
	private int intentos;


	/**
	 * Create the frame.
	 */
	public MemoryGame() {
		setTitle("Memory Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 4, 1, 1));


		for (Color color : colores) {
			listaBotones.add(this.crearJToggleButton(color));
			listaBotones.add(this.crearJToggleButton(color));
		}

		Collections.shuffle(listaBotones);
		for (JToggleButton button : listaBotones) {
			contentPane.add(button);
		}
	}

	private JToggleButton crearJToggleButton(Color color) {
		JToggleButton button = new JToggleButton();
		button.setBackground(color);
		button.addActionListener(this);
		button.setName(color.toString());
		button.setSelected(true);

		return button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (turno) {
		case 0:
			this.botonPrev = (JToggleButton) e.getSource();
			this.botonPrev.setSelected(false);		
			turno++;
			break;
		case 1:
			this.botonPost = (JToggleButton) e.getSource();
			timer = new Timer(500, timerEvent);
			intentos++;
			
			for(JToggleButton button : listaBotones) {
				button.setEnabled(false);
			}
			timer.setRepeats(false);
			timer.start();
			break;
		}
				
		for(JToggleButton button: listaBotones) {
			if(button.isSelected()) {
				return;
			}
		}
		
		JOptionPane.showMessageDialog(this, String.format("¡Has ganado! Has usado %s intentos", intentos), "Fin de la partida", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private ActionListener timerEvent = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (botonPrev.getBackground().equals(botonPost.getBackground())) {
				botonPrev.setVisible(false);
				botonPost.setVisible(false);
			} else {
				botonPrev.setSelected(true);
				botonPost.setSelected(true);
			}
			turno = 0;
			botonPrev = null;
			botonPost = null;
			for(JToggleButton button : listaBotones) {
				button.setEnabled(true);
			}
		}
	};
}