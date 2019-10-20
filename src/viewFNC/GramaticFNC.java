package viewFNC;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GramaticFNC extends JFrame implements ActionListener {
	
	public GramaticFNC() {
		int numProductions  = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de producciones", "Gramatica a FNC", JOptionPane.INFORMATION_MESSAGE));
		createView(numProductions);
		
		setSize(500, 500);
		setLayout(new BorderLayout());
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		pack();
	}
	
	private void createView(int numProductions) {
		JTextField[] productions = new JTextField[numProductions];
		JPanel panelProductions = new JPanel(new GridLayout(numProductions + 1, 1));
		for (int i = 0; i < numProductions; i++) {
			productions[i] = new JTextField();
			panelProductions.add(productions[i]);
		}
		JButton button = new JButton("acept");
//		add(panelProductions, BorderLayout.CENTER);
//		add(button, BorderLayout.SOUTH);
		add(panelProductions);
//		add(button);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		GramaticFNC g = new GramaticFNC();
	}

}
