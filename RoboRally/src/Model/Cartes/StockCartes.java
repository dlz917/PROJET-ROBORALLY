package Model.Cartes;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


/*----------------------------------------Class Stock Cartes------------------------------------
 * 
 *  Atribut de la class:
 * 
 * 		-ArrayList<CartesProgramme> stock
 * 
 * 	Les méthodes de la class:
 * 
 * 		- toString()
 * 			> affiche le nombre de carte disponible et le contenu du stock 
 * 	
 * 		- stockCartesTriees()
 * 			> retourne l'inventaire des cartes triers dans l'odre croissant 
 * 
 * 		- retraitCarteStock(CartesProgramme carteARetirer)
 * 			> retire les cartes du stock 
 * 
 * 		- ajoutCarteStock(CartesProgramme carteAAjouter)
 * 				>ajoute les cartes dans Stock
 * 
 * 
 */
public class StockCartes implements Serializable{
	
	/*-------------------------------------ATRIBUT-----------------------------------------*/
	
	ArrayList<CartesProgramme> stock = new ArrayList<CartesProgramme>();
	
	// ------------------- Constructeurs -------------------
	
	public void StockCartes(){
		int vitesse = 1;
		for (int i = 0; i<18; i++) {
			CartesProgramme carte = new CartesProgramme(vitesse, ActionCarte.avancer1);
			getStock().add(carte);
			vitesse +=5;
		}
		vitesse = 4;
		for (int i = 0; i<12; i++) {
			CartesProgramme carte = new CartesProgramme(vitesse, ActionCarte.avancer2);
			getStock().add(carte);
			if (i%2==0)
				vitesse +=10;
			else
				vitesse+=5;
		}
		vitesse = 9;
		for (int i = 0; i<6; i++) {
			CartesProgramme carte = new CartesProgramme(vitesse, ActionCarte.avancer3);
			getStock().add(carte);
			vitesse+=15;
		}
		vitesse = 5;
		for (int i = 0; i<6; i++) {
			CartesProgramme carte = new CartesProgramme(vitesse, ActionCarte.reculer1);
			getStock().add(carte);
			vitesse+=15;
		}
		vitesse = 2;
		for (int i = 0; i<18; i++) {
			CartesProgramme carte = new CartesProgramme(vitesse, ActionCarte.tournerD);
			getStock().add(carte);
			vitesse+=5;
		}
		vitesse = 3;
		for (int i = 0; i<18; i++) {
			CartesProgramme carte = new CartesProgramme(vitesse, ActionCarte.tournerG);
			getStock().add(carte);
			vitesse+=5;
		}
		vitesse = 15;
		for (int i = 0; i<6; i++) {
			CartesProgramme carte = new CartesProgramme(vitesse, ActionCarte.demitour);
			getStock().add(carte);
			vitesse+=15;
		}
	}
	public ArrayList<CartesProgramme> getStock() {
		return stock;
	}
	
	public void setStock(ArrayList<CartesProgramme> stockCartes) {
		this.stock = stockCartes;
	}
	
	// ------------------- Fonctions -------------------
	public String toString() {
		return "Nombre de cartes disponibles : "+getStock().size()+"\nContenu du stock\n" + getStock();
	}
	
	public ArrayList<CartesProgramme> stockCartesTriees(){
		ArrayList<CartesProgramme> inventaireCartes = new ArrayList<CartesProgramme>(getStock());
		Collections.sort(inventaireCartes);
		return inventaireCartes;
	}
	
	public void retraitCarteStock(CartesProgramme carteARetirer) {
		Iterator<CartesProgramme> i = getStock().iterator();
		while (i.hasNext()) {
			CartesProgramme carte = i.next();
			if (carte.equals(carteARetirer))
				i.remove();
		}
	}
	
	public void ajoutCarteStock(CartesProgramme carteAAjouter) {
		getStock().add(carteAAjouter);
	}

}

