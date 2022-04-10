package Model.Cartes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*--------------------------------CLASS DISTRIBUTION CARTES -----------------------------
 * 	ATTRIBUT DE LA CLASS:
 *    - ArrayList<CartesProgramme> listeCartes
 *    
 *  LES MÉTHODES DE LA CLASS : 
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
	
	/*-------------------------------------ATTRIBUT-----------------------------------------*/
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
			String affichage = "Nombre de cartes distribuees : "+getListeCartes().size()+"\nContenu :\n";
			for (int i = 0; i<getListeCartes().size(); i++) {
				affichage += getListeCartes().get(i).toString();
			}
			return affichage;
		} 
		
		public void listeCartes (int n, ArrayList<CartesProgramme> stock, int numJoueur){
			if (n >=0 && n<= stock.size()) {
				for (int i = 0; i<n; i++) {
					Random r = new Random();
					int j = r.nextInt(stock.size());
					if ( getListeCartes().contains(stock.get(j)) )
						i-=1;
					else {
						getListeCartes().add(stock.get(j));
						stock.get(j).setRobotAttribue(numJoueur);
						stock.remove(j);
					}
				}
			}
		}
		
		public void trierListe(){
			Collections.sort(getListeCartes());
		}}