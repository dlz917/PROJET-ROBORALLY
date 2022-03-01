package Model;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Iterator;
import java.util.Random;

import Projet.CartesProgrammePerso;


public class CartesProgramme implements Comparable<CartesProgramme> {
	private int vitesse= 0;
	private ActionCarte action = null;
	
	// ------------------- Constructeur -------------------
	
	public CartesProgramme(int vitesse, ActionCarte action) {
		this.vitesse= vitesse;
		this.action = action;
	}
	public CartesProgramme() {
	}
		
	// ------------------- Getters / Setters -------------------
	public int getVitesse() {
		return vitesse;
	}
	
	public ActionCarte getAction() {  
		return action;
	}
	
	// ------------------- Fonctions -------------------
	public String toString() {
		return "Action carte : "+getAction()+" / Vitesse carte : "+getVitesse()+"\n";
	}
	
	public boolean equals(CartesProgramme c) {
		return vitesse==c.getVitesse() && action==c.getAction();
	} 
	
	public int compareTo (CartesProgramme e) {
		if (vitesse < e.vitesse)
			return -1;
		if (vitesse > e.vitesse)
			return 1;
		return 0;
	}
	
}


