package Model.Tableau;

import java.io.Serializable;

import Model.Robot.Direction;


/*--------------------------------------CLASS CASE ROULANT------------------------------
 * 
 * ATTRIBUT DE LA CLASS:
 * 		- Direction direction
 * 
 * MÉTHODES DE LA CLASS:
 * 		-toString() 
 * 			>retourne affichage
 */
public class CaseRoulant extends CaseTableau implements Serializable{
	
/*--------------------------------ATTRIBUT--------------------------------*/
	private Direction direction;
	
	
/*-------------------------------CONSTRUCTEUR-------------------------------*/
	public CaseRoulant(Position location,Direction direction) {
		super(location);
		this.setDirection(direction);
		this.setTypeCase(TypeCase.caseRoulant);}

/*------------------------------GETTERS/SETTERS-----------------------------*/
	public void setDirection(Direction direction) {
		this.direction = direction;}
	
	public Direction getDirection() {
		return direction;
	}
	

/*----------------------------------FONCTION----------------------------------*/
	public String toString() {
		return "CaseRoulant [direction=" + direction + ", position=" + getPosition() + ", occupe=" + isOccupe() + ", drapeau="
				+ isDrapeau() + "]";
	}
		
	
	}
