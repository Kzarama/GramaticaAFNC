package modelFNC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
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
		reachable();
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
	/**
	 * make a copy of the a grammar
	 * @return
	 */
	private ArrayList makeACopy(ArrayList grammarToCopy) {
		ArrayList copy = new ArrayList();
		for (int i = 0; i < grammarToCopy.size(); i++) {
			ArrayList aux1 = new ArrayList();
			for (int j = 0; j < 1; j++) {
				String auxP = (String) ((ArrayList) grammarToCopy.get(i)).get(0);
				aux1.add(auxP);
				ArrayList copyProductions = new ArrayList();
				for (int k = 0; k < ((ArrayList) ((ArrayList) grammarToCopy.get(i)).get(1)).size(); k++) {
					String productions = (String) ((ArrayList) ((ArrayList) grammarToCopy.get(i)).get(1)).get(k);
					copyProductions.add(productions);
				}
				aux1.add(copyProductions);
			}
			copy.add(aux1);
		}
		return copy;
	}
	/**
	 * say if two grammars are equals
	 * @return
	 */
	private boolean areGrammarEquals(ArrayList grammar1, ArrayList grammar2) {
		boolean equals = true;
		if (grammar1.size() != grammar2.size()) {
			return false;
		}
		for (int i = 0; i < grammar1.size(); i++) {
			if (!((String) ((ArrayList) grammar1.get(i)).get(0)).equals((String) ((ArrayList) grammar2.get(i)).get(0))) {
				equals = false;
			}
			for (int j = 0; j < ((ArrayList) ((ArrayList) grammar1.get(i)).get(1)).size(); j++) {
				if (!((String) ((ArrayList) ((ArrayList) grammar1.get(i)).get(1)).get(j)).equals((String) ((ArrayList) ((ArrayList) grammar2.get(i)).get(1)).get(j))) {
					equals = false;
				}
			}
		}
		return equals;
	}
	/**
	 * remove variables non terminals
	 */
	public void terminals() {
		ArrayList productionsNonTerminals = new ArrayList();
		ArrayList productionsTerminals = new ArrayList();
		ArrayList iDK = new ArrayList();
		//terminals 1
		for (int i = 0; i < gramatic.size(); i++) {
			boolean terminal = false;
			for (int j = 0; j < ((ArrayList) ((ArrayList) gramatic.get(i)).get(1)).size(); j++) {
				String production = (String) ((ArrayList) ((ArrayList) gramatic.get(i)).get(1)).get(j);
				if(production.equals(production.toLowerCase())) {
					productionsTerminals.add(gramatic.get(i));
					terminal = true;
					break;
				}
			}
			if (!terminal) {
				iDK.add(gramatic.get(i));
			}
		}
		//terminals 2-n
		boolean equals = true;
		while (equals) {
			ArrayList aux = makeACopy(productionsTerminals);
			for (int i = 0; i < iDK.size(); i++) {
				 boolean terminal = false;
				 for (int j = 0; j < ((ArrayList) ((ArrayList) iDK.get(i)).get(1)).size(); j++) {
					 String production = (String) ((ArrayList) ((ArrayList) iDK.get(i)).get(1)).get(j);
					 for (int k = 0; k < production.length(); k++) {
						for (int l = 0; l < productionsTerminals.size(); l++) {
							if (production.charAt(k) == ((String) ((ArrayList) productionsTerminals.get(l)).get(0)).charAt(0)) {
								terminal = true;
							}
						}
					}
				}
				if (terminal) {
					productionsTerminals.add(iDK.remove(i));
					i = -1;
				}
			}
			equals = !areGrammarEquals(aux, productionsTerminals);
		}
		//remove variables non terminals
		for (int i = 0; i < gramatic.size(); i++) {
			for (int j = 0; j < iDK.size(); j++) {
				if (((ArrayList) gramatic.get(i)).get(0).equals(((ArrayList) iDK.get(j)).get(0))) {
					gramatic.remove(i);
					i = -1;
					break;
				}
			}
		}
		//remove productions with non terminals
		for (int i = 0; i < gramatic.size(); i++) {
			for (int j = 0; j < ((ArrayList) ((ArrayList) gramatic.get(i)).get(1)).size(); j++) {
				String production = (String) ((ArrayList) ((ArrayList) gramatic.get(i)).get(1)).get(j);
				for (int k = 0; k < iDK.size(); k++) {
					if (production.contains((CharSequence) ((ArrayList) iDK.get(k)).get(0))) {
						((ArrayList) ((ArrayList) gramatic.get(i)).get(1)).remove(j);
						j = -1;
					}
				}
			}
		}
	}
	/**
	 * remove variables non reachable of the grammar
	 */
	public void reachable() {
		String[] variables = new String[gramatic.size()];
		for (int i = 0; i < variables.length; i++) {
			variables[i] = (String) ((ArrayList) gramatic.get(i)).get(0);
		}
		Queue queue = new LinkedList();
		boolean[] isAttainable = new boolean[gramatic.size()];
		for (int i = 0; i < isAttainable.length; i++) {
			isAttainable[i] = false;
		}
		queue.add(gramatic.get(0));
		isAttainable[0] = true;
		while(!queue.isEmpty()) {
			ArrayList elementQueue = (ArrayList) queue.poll();
			for (int i = 0; i < ((ArrayList) elementQueue.get(1)).size(); i++) {
				String production = (String) ((ArrayList) elementQueue.get(1)).get(i);
				for (int j = 1; j < variables.length; j++) {
					if (isAttainable[j] != true && production.contains(variables[j])) {
						isAttainable[j] = true;
						queue.add(gramatic.get(j));
					}
				}
			}
		}
		for (int i = gramatic.size()-1; i > 0; i--) {
			System.out.println(i);
			if (isAttainable[i] == false) {
				gramatic.remove(i);
			}
		}
	}
	
	public void voidable() {
		
	}
	
	public void unitary() {
		
	}
	
	public void changeTerminals() {
		
	}
	
	public void binary() {
		
	}
	
}
