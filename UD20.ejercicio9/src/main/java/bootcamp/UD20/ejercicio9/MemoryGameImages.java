package bootcamp.UD20.ejercicio9;
/**
 * @author Palmira
 */


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.Timer;


//Versión de mi MemoryGame pero con imagenes en vez de colores

public class MemoryGameImages extends JFrame implements ActionListener{

	private static final long serialVersionUID = -5468290645557986484L;
	private JPanel contentPane;
	private ArrayList<JToggleButton> listaBotones = new ArrayList<>();
	ImageIcon imagen1 = new ImageIcon("src/main/java/images/1.png");
	ImageIcon imagen2 = new ImageIcon("src/main/java/images/2.png");
	ImageIcon imagen3 = new ImageIcon("src/main/java/images/3.png");
	ImageIcon imagen4 = new ImageIcon("src/main/java/images/4.png");
	ImageIcon imagen5 = new ImageIcon("src/main/java/images/5.png");
	ImageIcon imagen6 = new ImageIcon("src/main/java/images/6.png");
	ImageIcon imagen7 = new ImageIcon("src/main/java/images/7.png");
	ImageIcon imagen8 = new ImageIcon("src/main/java/images/8.png");
	ImageIcon image9 = new ImageIcon("src/main/java/images/questionMark.png");
	
	//Creamos un array de ImageIcon
	private ImageIcon[] imagenes = { imagen1, imagen2, imagen3, imagen4, imagen5, imagen6,
			imagen7, imagen8 };

	private static int turno = 0;
	private JToggleButton botonPrev = null;
	private JToggleButton botonPost = null;
	private Timer timer;
	private int intentos;

	/**
	 * Create the frame.
	 */
	public MemoryGameImages() {
		setTitle("Memory Game with Images");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 4, 1, 1));
		

		for (ImageIcon image : imagenes) {
			//Rellenamos 2 veces la lista de botones con imagenes
			listaBotones.add(this.crearJToggleButton(image));
			listaBotones.add(this.crearJToggleButton(image));
			
		}
		//Mezclamos las imagenes
		Collections.shuffle(listaBotones);
		for (JToggleButton button : listaBotones) {
			contentPane.add(button);
		
		}
	}

	private JToggleButton crearJToggleButton(ImageIcon image) {
		JToggleButton button = new JToggleButton();
		
		button.addActionListener(this);
		button.setName(image.toString());
		button.setIcon(image);
		button.setSelected(true);
		//Indicamos que de fondo nos ponga otra imagen 
		button.setSelectedIcon(image9);
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
			/*
			for(JToggleButton button : listaBotones) {
				button.setEnabled(false);
			}*/
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
			if (botonPrev.getIcon().equals(botonPost.getIcon())) {
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
