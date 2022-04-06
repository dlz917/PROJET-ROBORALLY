package Model.Cartes;

import java.io.Serializable;

//import java.util.Iterator;

/*--------------------------------Class Cartes Programme ----------------------------:
 * 
 * Les attributs de la class :
 * 
 * 		- int vitesse;
 * 		- ActionCarte action 
 * 		- int robotAttribue
 * 
 * Les méthodes de la class:
 * 
 * 		- toString() 
 * 			> affiche action d'une carte et sa vitesse 
 * 	
 * 	    - equals(CartesProgramme c)
 * 			> retourne dans vitesse la vitesse de la carte c et dans action l'action de la carte c 
 * 		
 * 		- compareTo (CartesProgramme e) 
 * 			> range les cartes 
 * 
 */

/*-------------------------------------ATRIBUTS-----------------------------------------*/
public class CartesProgramme implements Comparable<CartesProgramme>, Serializable {
	private int vitesse= 0;
	private ActionCarte action = null;
	private int robotAttribue =-1 ;
	
/*-------------------------------------CONSTRUCTEUR-----------------------------------------*/
	
	public CartesProgramme(int vitesse, ActionCarte action) {
		this.vitesse= vitesse;
		this.action = action;
	}
	public CartesProgramme() {
	}
		
/*-------------------------------------------GETTERS/ SETTERS------------------------------------------*/
	public int getVitesse() {
		return vitesse;
	}
	
	public ActionCarte getAction() {  
		return action;
	}
	public int getRobotAttribue() {
		return robotAttribue;
	}
	public void setRobotAttribue(int robotAttribue) {
		this.robotAttribue = robotAttribue;
	}
	
	
	/*-------------------------------------------FONCTION------------------------------------------*/
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


