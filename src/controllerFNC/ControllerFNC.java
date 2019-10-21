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
	GramaticFNC view;
	ModelFNC model;
	/**
	 * constructor of the method
	 */
	public ControllerFNC() {
		view = new GramaticFNC();
	}
	/**
	 * button accept
	 * @param data
	 */
	public void accept(ArrayList data) {
		model = new ModelFNC(data);
	}
	/**
	 * button reboot
	 */
	public void reboot() {
		view.reboot();
	}

}
