package Model;

public class CaseTableau {
	// ------------------- Attributs -------------------
	protected final Position position;
	protected boolean occupe=false;
	// ------------------- Constructeurr -------------------
	public CaseTableau(Position location) {
		this.position = location;
	}
	// ------------------- Getters / Setters -------------------
	public boolean isOccupe() {
		return occupe;
	}

	public void setOccupe(boolean occupe) {
		this.occupe = occupe;
	}

	public Position getPosition() {
		return position;
	}

	// ------------------- Fonctions -------------------
	public String toString() {
		return "CaseTableau [location=" + position + ", occupe=" + occupe + "]";
	}

	public CaseTableau CaseAdjacente(Direction direction){//jsp si le mettre ici ou en case tableau...
		CaseTableau r=this;
		if (direction==Direction.nord){
			if (this.getPosition().getLigne()!=Lignes.L)
				r=Tableau1.tableau[this.getPosition().getColonne()-1][this.getPosition().getLigne().getIntValue()+1];}
		
		if (direction==Direction.sud){
			if (this.getPosition().getLigne()!=Lignes.A)
				r=Tableau1.tableau[this.getPosition().getColonne()-1][this.getPosition().getLigne().getIntValue()-1];}
		
		if (direction==Direction.est){	
			if (this.getPosition().getColonne()!=12)
				r=Tableau1.tableau[this.getPosition().getColonne()][this.getPosition().getLigne().getIntValue()];}
				
		if (direction==Direction.ouest){
			if (this.getPosition().getColonne()!=1)
				r=Tableau1.tableau[this.getPosition().getColonne()-2][this.getPosition().getLigne().getIntValue()];}
		
	return r;}
	

}

	
