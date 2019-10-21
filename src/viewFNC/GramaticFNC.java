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

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

import controllerFNC.ControllerFNC;
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
		int numProductions  = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de producciones", "Gramatica a FNC", JOptionPane.INFORMATION_MESSAGE));
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
		JLabel labMessage = new JLabel("Ingrese aqui las producciones");
		JButton buttonAccept = new JButton("aceptar");
		buttonAccept.setActionCommand("ACCEPT");
		buttonAccept.addActionListener(this);
		JButton buttonReboot = new JButton("Reiniciar");
		buttonReboot.setActionCommand("REBOOT");
		buttonReboot.addActionListener(this);
		JPanel panelButtons = new JPanel(new GridLayout(1,2));
		panelButtons.add(buttonAccept);
		panelButtons.add(buttonReboot);
		aux.add(labMessage, BorderLayout.NORTH);
		aux.add(panelProductions, BorderLayout.CENTER);
		aux.add(panelButtons, BorderLayout.SOUTH);
	}
	/**
	 * take the data of the grammar
	 * @return
	 */
	public ArrayList takeData() {
		ArrayList data = new ArrayList();
		for (int i = 0; i < productions.length; i++) {
			ArrayList dataAux = new ArrayList();
			for (int j = 0; j < 2; j++) {
				dataAux.add(productions[i][j]);
			}
			data.add(dataAux);
		}
		return data;
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
			controller.accept(takeData());
		} else {
			controller.reboot();
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
