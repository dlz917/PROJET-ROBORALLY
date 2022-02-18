package Projet;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class StockCartes {
	ArrayList<CartesProgramme> stockCartes = new ArrayList<CartesProgramme>();
	
	// ------------------- Constructeurs -------------------
	
	public ArrayList<CartesProgramme> getStockCartes() {
		return stockCartes;
	}
	
	public void setStockCartes(ArrayList<CartesProgramme> stockCartes) {
		this.stockCartes = stockCartes;
	}
	
	// ------------------- Fonctions -------------------
	public String toString() {
		return "Nombre de cartes disponibles : "+getStockCartes().size()+"\nContenu du stock\n" + getStockCartes();
	}
	
	public void stockCartesInitial() {
		int vitesse = 1;
		for (int i = 0; i<18; i++) {
			CartesProgramme carte = new CartesProgramme(vitesse, ActionCarte.avancer1);
			getStockCartes().add(carte);
			vitesse +=5;
		}
		vitesse = 4;
		for (int i = 0; i<12; i++) {
			CartesProgramme carte = new CartesProgramme(vitesse, ActionCarte.avancer2);
			getStockCartes().add(carte);
			if (i%2==0)
				vitesse +=10;
			else
				vitesse+=5;
		}
		vitesse = 9;
		for (int i = 0; i<6; i++) {
			CartesProgramme carte = new CartesProgramme(vitesse, ActionCarte.avancer3);
			getStockCartes().add(carte);
			vitesse+=15;
		}
		vitesse = 5;
		for (int i = 0; i<6; i++) {
			CartesProgramme carte = new CartesProgramme(vitesse, ActionCarte.reculer1);
			getStockCartes().add(carte);
			vitesse+=15;
		}
		vitesse = 2;
		for (int i = 0; i<18; i++) {
			CartesProgramme carte = new CartesProgramme(vitesse, ActionCarte.tournerD);
			getStockCartes().add(carte);
			vitesse+=5;
		}
		vitesse = 3;
		for (int i = 0; i<18; i++) {
			CartesProgramme carte = new CartesProgramme(vitesse, ActionCarte.tournerG);
			getStockCartes().add(carte);
			vitesse+=5;
		}
		vitesse = 15;
		for (int i = 0; i<6; i++) {
			CartesProgramme carte = new CartesProgramme(vitesse, ActionCarte.demitour);
			getStockCartes().add(carte);
			vitesse+=15;
		}
	}
	
	public ArrayList<CartesProgramme> stockCartesTriees(){
		ArrayList<CartesProgramme> inventaireCartes = new ArrayList<CartesProgramme>(getStockCartes());
		Collections.sort(inventaireCartes);
		return inventaireCartes;
	}
	
	public void retraitCarteStock(CartesProgramme carteARetirer) {
		Iterator<CartesProgramme> i = getStockCartes().iterator();
		while (i.hasNext()) {
			CartesProgramme carte = i.next();
			if (carte.equals(carteARetirer))
				i.remove();
		}
	}
	
	public void ajoutCarteStock(CartesProgramme carteAAjouter) {
		getStockCartes().add(carteAAjouter);
	}

}

