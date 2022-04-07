package Model.Tableau;

import java.io.Serializable;

import Model.Robot.Direction;

/*-------------------------------------CLASS LASER---------------------------------
 * 
 * ATTRIBUT DE LA CLASS:
 *	 -Laser laser
 * 
 * LES MÉTHODES DE LA CLASS:
 *   -toString() 
 *   	>return un affichage
 */

public class CaseLaser extends CaseTableau implements Serializable {

/*-------------------------------ATTRIBUT---------------------------------*/
	private Laser laser;

/*------------------------------CONSTRUTEUR--------------------------*/
	public CaseLaser(Position location,Direction d) {
		super(location);
		this.laser=new Laser(d);
		this.setTypeCase(TypeCase.caseLaser);		
	}
	@Override
	
/*----------------------------------FONCTION------------------------------*/
	public String toString() {
		return "CaseLaser [occupe=" + isOccupe() + ", laser=" + laser + ", position=" + getPosition() + ", drapeau=" + isDrapeau()
				+ "]";
	}

}
