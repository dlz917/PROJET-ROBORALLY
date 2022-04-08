package Model.Tableau;

import java.io.Serializable;

/*------------------------------------CLASS TROU----------------------------
 * MÉTHODE DE LA CLASS
 * 		-toString() 
 * 			> retourne affichage
 */


public class CaseTrou extends CaseTableau implements Serializable{

/*-------------------------------- CONSTRUCTEUR-------------------------------*/
	public CaseTrou(Position location) {
		super(location);
		setOccupe(true);
		this.setTypeCase(TypeCase.caseTrou);
	}
	
/*------------------------------- FONCTION----------------------------------*/	
	public String toString() {
		return "CaseTrou [position=" + getPosition() + ", occupe=" + isOccupe() + ", drapeau=" + isDrapeau() + "]";
	}

}
