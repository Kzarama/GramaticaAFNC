package viewFNC;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

import controllerFNC.ControllerFNC;

public class GramaticFNC extends JFrame implements ActionListener {
	
	private ControllerFNC controller;
	
	JPanel aux = new JPanel(new BorderLayout());
	
	public GramaticFNC() {
		int numProductions  = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de producciones", "Gramatica a FNC", JOptionPane.INFORMATION_MESSAGE));
		createView(numProductions);
		add(aux);
		setSize(500, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}
	
	private void createView(int numProductions) {
		JTextField[][] productions = new JTextField[numProductions][2];
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("ACCEPT")) {
			controller.accept();
		} else {
			controller.reboot();
		}
	}
	
	public static void main(String[] args) {
		GramaticFNC g = new GramaticFNC();
	}

}
