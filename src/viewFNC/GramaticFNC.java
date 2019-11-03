package viewFNC;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllerFNC.ControllerFNC;
import jdk.nashorn.internal.scripts.JO;
/**
 * program that generates a grammar equivalent to fnc equivalent to a grammar g
 * @author kz
 * 01/10/2019
 * version 1.0
 */
public class GramaticFNC extends JFrame implements ActionListener {
	/**
	 * relations
	 */
	private ControllerFNC controller;
	private GramaticOutFNC gramaticOut;
	/**
	 * attributes
	 */
	JPanel aux = new JPanel(new BorderLayout());
	JTextField[][] productions;
	/**
	 * constructor of the class
	 */
	public GramaticFNC() {
		controller = new ControllerFNC();
		int numProductions = 0;
		try {
			numProductions = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de producciones", "Gramatica a FNC", JOptionPane.INFORMATION_MESSAGE));
			if (numProductions == 0) {
				System.exit(0);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "chistoso xdd (ejecutar de nuevo y solo ingresar numeros)");
			System.exit(0);
		}
		createView(numProductions);
		add(aux);
		setSize(500, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}
	/**
	 * create the view of the program
	 * @param numProductions
	 */
	private void createView(int numProductions) {
		productions = new JTextField[numProductions][2];
		JPanel panelProductions = new JPanel(new GridLayout(numProductions, 3));
		for (int i = 0; i < numProductions; i++) {
			productions[i][0] = new JTextField();			
			panelProductions.add(productions[i][0]);
			JLabel arrow = new JLabel("-->");
			panelProductions.add(arrow);
			productions[i][1] = new JTextField();
			panelProductions.add(productions[i][1]);
		}
//		JLabel labMessage = new JLabel("Ingrese aqui las producciones(para lambda ingrese _)");
		JLabel labMessage = new JLabel("<html><big>Ingrese aqui las producciones</big><br>(para lambda ingrese _)</html>");
		JButton buttonAccept = new JButton("ACEPTAR");
		buttonAccept.setActionCommand("ACCEPT");
		buttonAccept.addActionListener(this);
		aux.add(labMessage, BorderLayout.NORTH);
		aux.add(panelProductions, BorderLayout.CENTER);
		aux.add(buttonAccept, BorderLayout.SOUTH);
	}
	/**
	 * take the data of the grammar
	 * @return
	 */
	public ArrayList takeData() {
		ArrayList data = new ArrayList();
		for (int i = 0; i < productions.length; i++) {
			ArrayList dataAux = new ArrayList();
			dataAux.add(productions[i][0].getText());
			ArrayList productionsAux = new ArrayList();
			String[] aux = productions[i][1].getText().split(",");
			for (int j = 0; j < aux.length; j++) {
				productionsAux.add(aux[j]);
			}
			dataAux.add(productionsAux);
			data.add(dataAux);
		}
		return data;
	}
	
	private void showData(ArrayList grammar) {
		gramaticOut = new GramaticOutFNC(this, grammar);
		gramaticOut.setLocationRelativeTo(this);
		gramaticOut.setVisible(true);
	}
	/**
	 * reboot the program
	 */
	public void reboot() {
		GramaticFNC g = new GramaticFNC();
	}
	/**
	 * action of the buttons
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("ACCEPT")) {
			showData(controller.accept(takeData()));
		}
	}
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		GramaticFNC g = new GramaticFNC();
	}

}
