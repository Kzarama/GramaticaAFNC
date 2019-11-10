package viewFNC;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
/**
 * 
 * @author zaram
 * show the grammar in fnc
 */
public class GramaticOutFNC extends JDialog {
	/**
	 * relations
	 */
	private GramaticFNC i;
	/*
	 * attributes
	 */
	private ArrayList gramatic;
	private JTextArea labelGramatic;
	/**
	 * constructor of the class
	 * @param i
	 * @param gramatic
	 */
	public GramaticOutFNC(GramaticFNC i,ArrayList gramatic) {
		super(i, true);
		this.i = i;
		this.gramatic = gramatic;
		
		setTitle("Gramatica en FNC");
		setSize(500, 500);
		showGrammar();
		add(labelGramatic);
		pack();
	}
	/**
	 * add the grammar in fnc at the interface
	 */
	public void showGrammar() {
		String grammar = "GRAMATICA EN FNC\n";
		for (int i = 0; i < gramatic.size(); i++) {
			grammar += ((ArrayList) gramatic.get(i)).get(0);
			grammar += "->";
			grammar += ((ArrayList) gramatic.get(i)).get(1);
			grammar += "\n";
		}
		labelGramatic = new JTextArea(grammar);
		labelGramatic.setEditable(false);
	}
	
}
