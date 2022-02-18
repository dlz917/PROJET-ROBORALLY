package Projet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DistributionCartes {
	ArrayList<CartesProgramme> listeCartes = new ArrayList<CartesProgramme>();
	
	// ------------------- Constructeurs -------------------
	
		public ArrayList<CartesProgramme> getListeCartes() {
			return listeCartes;
		}
		
		public void setListeCartes(ArrayList<CartesProgramme> listeCartes) {
			this.listeCartes = listeCartes;
		}
		
		// ------------------- Fonctions -------------------
		public String toString() {
			return "Nombre de cartes distribuées : "+getListeCartes().size()+"\nContenu :\n" + getListeCartes();
		}
		
		public void listeCartes (int n, ArrayList<CartesProgramme> stock){
			//créer exception si n<0 ou n>stockCartesPerso.size()
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
