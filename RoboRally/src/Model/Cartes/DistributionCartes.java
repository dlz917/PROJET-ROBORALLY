package Model.Cartes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*--------------------------------Class Distribution Cartes -----------------------------
 * 	Atribut de la class:
 *    - ArrayList<CartesProgramme> listeCartes
 *    
 *  Les méthodes de la class : 
 *  
 *    - toString()
 *    		>affiche le nombre de carte distribuées et la liste de ces cartes
 *    
 *    - listeCartes (int n, ArrayList<CartesProgramme> stock)
 *    		>  ajout carte dans la liste de carte ?? REVOIR!!!!!
 *    
 *    - trierListe()
 *    		> tris la liste carte 
 *    
 * 
 */

public class DistributionCartes implements Serializable{
	
	/*-------------------------------------ATRIBUT-----------------------------------------*/
	ArrayList<CartesProgramme> listeCartes = new ArrayList<CartesProgramme>();
	
	
/* -----------------------------------CONSTRUCTEUR ----------------------------------*/
		public DistributionCartes() {
			
		}
	
		public ArrayList<CartesProgramme> getListeCartes() {
			return listeCartes;
		}
		
		public void setListeCartes(ArrayList<CartesProgramme> listeCartes) {
			this.listeCartes = listeCartes;
		}
		
/*--------------------------------- FONCTION------------------------------------*/
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
