package Model.Tableau;

import java.io.Serializable;

import Model.Robot.Direction;

/*----------------------------------CLASS CASE MUR-----------------------
 * 
 * ATTRIBUT DE LA CLASS:
 * 		-Direction direction
 * 
 * MÉTHONDE DE LA CLASS:
 * 		- toString() 
 * 			> retourne un affichage 
 * 
 */
public class CaseMur extends CaseTableau implements Serializable {
	
/*---------------------ATTRIBUT-------------------------*/

	private Direction direction;
	
/*----------------------CONSTRUCTEUR---------------------*/

	public CaseMur(Position location,Direction direction) {
		super(location);
		this.direction=direction;
		this.setTypeCase(TypeCase.caseMur);}
	
/*--------------------------GETTERS/SETTERS--------------*/
	public Direction getDirection() {
		return direction;
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
/*-----------------------------FONCTION-----------------*/
		public String toString() {
		
		return "CaseMur [location=" + getPosition() + ", occupe=" + isOccupe() + "[direction=" + direction + "]";
	}}

