package Model.Tableau;

import java.io.Serializable;

import Model.Robot.Direction;
/*--------------------------------CLASS CASE TABLEAU------------------------------
 * 
 * ATTRIBUTS DE LA CLASS:
 * 		-Position position
 * 		- boolean occupe;
 * 		- boolean drapeau;
 * 		- TypeCase typeCase
 * 
 * MÉTHODE DE LA CLASS:
 * 		- toString()
 * 			> retourne affichage
 * 		
 * 		
 */
public class CaseTableau implements Serializable{
	
/*----------------------------------ATTRIBUTS ----------------------------------*/
	private final Position position;
	private boolean occupe=false;
	private boolean drapeau=false;
	private TypeCase typeCase;

/*-------------------------------- CONSTRUCTEURS-------------------------------*/
	public CaseTableau(Position location) {
		this.position = location;
		this.setTypeCase(TypeCase.caseNormal);
	}
	public CaseTableau(Position location,boolean drapeau) {
		this.position = location;
		this.setDrapeau(drapeau);
		this.setTypeCase(TypeCase.caseNormal);}
	
/*----------------------------- GETTERS/SETTERS ----------------------------*/
	public boolean isOccupe() {
		return occupe;
	}
	public void setOccupe(boolean occupe) {
		this.occupe = occupe;
	}

	public Position getPosition() {
		return position;
	}
	public TypeCase getTypeCase() {
		return typeCase;
	}
	public void setTypeCase(TypeCase typeCase) {
		this.typeCase = typeCase;
	}
	public boolean isDrapeau() {
		return drapeau;
	}
	public void setDrapeau(boolean drapeau) {
		this.drapeau = drapeau;
	}
	
/*------------------------------- FONCTIONS----------------------------------*/
	public String toString() {
		return "CaseTableau [location=" + position + ", occupe=" + occupe +", drapeau=" + isDrapeau() +  "]";
	}

	public CaseTableau CaseAdjacente(Direction direction){
		CaseTableau r=this;
		if (direction==Direction.nord){
			if (this.getPosition().getLigne()!=Lignes.L)
				r=Tableau1.getTableau()[this.getPosition().getColonne()-1][this.getPosition().getLigne().getIntValue()+1];}
		
		if (direction==Direction.sud){
			if (this.getPosition().getLigne()!=Lignes.A)
				r=Tableau1.getTableau()[this.getPosition().getColonne()-1][this.getPosition().getLigne().getIntValue()-1];}
		
		if (direction==Direction.est){	
			if (this.getPosition().getColonne()!=12)
				r=Tableau1.getTableau()[this.getPosition().getColonne()][this.getPosition().getLigne().getIntValue()];}
				
		if (direction==Direction.ouest){
			if (this.getPosition().getColonne()!=1)
				r=Tableau1.getTableau()[this.getPosition().getColonne()-2][this.getPosition().getLigne().getIntValue()];}
		
	return r;}
	

}

	
