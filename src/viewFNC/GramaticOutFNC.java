package viewFNC;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class GramaticOutFNC extends JDialog {
	
	private GramaticFNC i;
	
	private ArrayList gramatic;
	private JTextArea labelGramatic;
	
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
