package Model.Cartes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DistributionCartes implements Serializable{
	ArrayList<CartesProgramme> listeCartes = new ArrayList<CartesProgramme>();
	
	// ------------------- Constructeurs -------------------
		public DistributionCartes() {
			
		}
	
		public ArrayList<CartesProgramme> getListeCartes() {
			return listeCartes;
		}
		
		public void setListeCartes(ArrayList<CartesProgramme> listeCartes) {
			this.listeCartes = listeCartes;
		}
		
		// ------------------- Fonctions -------------------
		public String toString() {
			String affichage = "Nombre de cartes distribuees : "+getListeCartes().size()+"\nContenu :";
			for (int i = 0; i<getListeCartes().size(); i++) {
				affichage += getListeCartes().get(i).toString();
			}
			return affichage;
		} 
		
		public void listeCartes (int n, ArrayList<CartesProgramme> stock){
			if (n >=0 && n<= stock.size()) {
				for (int i = 0; i<n; i++) {
					Random r = new Random();
					int j = r.nextInt(stock.size());
					if ( getListeCartes().contains(stock.get(j)) )
						i-=1;
					else
						getListeCartes().add(stock.get(j));
				}
			}
		}
		
		public void trierListe(){
			Collections.sort(getListeCartes());
		}
	

}
