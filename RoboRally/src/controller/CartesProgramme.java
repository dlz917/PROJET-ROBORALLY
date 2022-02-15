package Projet;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Iterator;
import java.util.Random;


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
	
	public int compareTo (CartesProgramme e) {
		if (vitesse < e.vitesse)
			return -1;
		if (vitesse > e.vitesse)
			return 1;
		return 0;
	}
	
	public ArrayList<CartesProgramme> InventaireCartesTriees(){
		ArrayList<CartesProgramme> inventaireCartes = new ArrayList<CartesProgramme>(InventaireCartes());
		Collections.sort(inventaireCartes);
		return inventaireCartes;
	}
	
	public ArrayList<CartesProgramme> InventaireCartes() {
		ArrayList<CartesProgramme> InventaireCartes = new ArrayList<CartesProgramme>();
		int vitesse = 1;
		for (int i = 0; i<18; i++) {
			CartesProgramme carte = new CartesProgramme(vitesse, ActionCarte.avancer1);
			InventaireCartes.add(carte);
			vitesse +=5;
		}
		vitesse = 4;
		for (int i = 0; i<12; i++) {
			CartesProgramme carte = new CartesProgramme(vitesse, ActionCarte.avancer2);
			InventaireCartes.add(carte);
			if (i%2==0)
				vitesse +=10;
			else
				vitesse+=5;
		}
		vitesse = 9;
		for (int i = 0; i<6; i++) {
			CartesProgramme carte = new CartesProgramme(vitesse, ActionCarte.avancer3);
			InventaireCartes.add(carte);
			vitesse+=15;
		}
		vitesse = 5;
		for (int i = 0; i<6; i++) {
			CartesProgramme carte = new CartesProgramme(vitesse, ActionCarte.reculer1);
			InventaireCartes.add(carte);
			vitesse+=15;
		}
		vitesse = 2;
		for (int i = 0; i<18; i++) {
			CartesProgramme carte = new CartesProgramme(vitesse, ActionCarte.tournerD);
			InventaireCartes.add(carte);
			vitesse+=5;
		}
		vitesse = 3;
		for (int i = 0; i<18; i++) {
			CartesProgramme carte = new CartesProgramme(vitesse, ActionCarte.tournerG);
			InventaireCartes.add(carte);
			vitesse+=5;
		}
		vitesse = 15;
		for (int i = 0; i<6; i++) {
			CartesProgramme carte = new CartesProgramme(vitesse, ActionCarte.demitour);
			InventaireCartes.add(carte);
			vitesse+=15;
		}
		return InventaireCartes;
	}
	
	public ArrayList<CartesProgramme> CartesTriees(ArrayList<CartesProgramme> liste){
		Collections.sort(liste);
		return liste;
	}
	
	public ArrayList<CartesProgramme> ListeCartes(int n){
		//créer exception si n<0 ou n>84
		ArrayList<CartesProgramme> inventaireCartes = new ArrayList<CartesProgramme>(InventaireCartes());
		ArrayList<CartesProgramme> listeCartes = new ArrayList<CartesProgramme>();
		if (n >=0 && n<=84) {
			for (int i = 0; i<n; i++) {
				Random r = new Random();
				int j = r.nextInt(inventaireCartes.size());
				if ( listeCartes.contains(inventaireCartes.get(j)) )
					i-=1;
				else
					listeCartes.add(inventaireCartes.get(j));
			}
		}
		return listeCartes;
		}
}


