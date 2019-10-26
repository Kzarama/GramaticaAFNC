package modelFNC;

import java.util.ArrayList;
/**
 * model of program
 * @author kz
 * 01/10/2019
 * version 1.0
 */
public class ModelFNC {
	/**
	 * attributes
	 */
	ArrayList gramatic;
	/**
	 * constructor
	 * @param data
	 */
	public ModelFNC(ArrayList data) {
		gramatic = data;
	}
	public ArrayList fnc() {
		useless();
		terminals();
		attainable();
		voidable();
		unitary();
		changeTerminals();
		binary();
		return gramatic;
	}
	/**
	 * method that delete useless variables
	 */
	public void useless() {
		for (int i = 0; i < gramatic.size(); i++) {
			if(((ArrayList) gramatic.get(i)).get(1).equals("")) {
				gramatic.remove(i);
				i = -1;
			}
		}
	}
	public void terminals() {
		ArrayList productionsNonTerminals = new ArrayList();
		for (int i = 0; i < gramatic.size(); i++) {
			boolean terminal = false;
			for (int j = 0; j < ((ArrayList) ((ArrayList) gramatic.get(i)).get(1)).size(); j++) {
				String production = (String) ( (ArrayList) ((ArrayList) gramatic.get(i)).get(1)).get(j);
				if(production.equals(production.toLowerCase())) {
					terminal = true;
					break;
				}
			}
			if (!terminal) {
				productionsNonTerminals.add(gramatic.remove(i));
				i = -1;
			}
		}
		System.out.println(productionsNonTerminals);
		for (int i = 0; i < gramatic.size(); i++) {
			for (int j = 0; j < ((ArrayList) ((ArrayList) gramatic.get(i)).get(1)).size(); j++) {
				String production = (String) ( (ArrayList) ((ArrayList) gramatic.get(i)).get(1)).get(j);
				for (int k = 0; k < productionsNonTerminals.size(); k++) {
					if (production.contains((CharSequence) ((ArrayList) productionsNonTerminals.get(k)).get(0))) {
						((ArrayList) ((ArrayList) gramatic.get(i)).get(1)).remove(j);
						j = -1;
					}
				}
			}
		}
		
	}
	public void attainable() {
		
	}
	
	public void voidable() {
		
	}
	
	public void unitary() {
		
	}
	
	public void changeTerminals() {
		
	}
	
	public void binary() {
		
	}
	
//	private void haveTerminals(ArrayList prove) {
//		boolean haveTerminals = false;
//		for (int i = 0; i < prove.size(); i++) {
//			if()
//		}
//	}
	
}
