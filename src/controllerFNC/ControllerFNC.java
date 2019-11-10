package controllerFNC;

import java.util.ArrayList;

import modelFNC.ModelFNC;
import viewFNC.GramaticFNC;
/**
 * program that generates a grammar equivalent to fnc equivalent to a grammar g
 * @author kz
 * 01/10/2019
 * version 1.0
 */
public class ControllerFNC {
	/**
	 * relations
	 */
	private GramaticFNC view;
	private ModelFNC model;
	/**
	 * constructor of the method
	 */
	public ControllerFNC() {
		
	}
	/**
	 * button accept
	 * @param data
	 */
	public ArrayList accept(ArrayList data) {
		model = new ModelFNC(data);
		return model.fnc();
	}
	
}
