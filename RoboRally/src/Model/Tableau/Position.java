package Model.Tableau;

public class Position {
	private int colonne;
	private Lignes ligne;
	
	// ------------------- Constructeur -------------------

	public Position(int colonne, Lignes ligne) {
		this.colonne = colonne;
		this.ligne = ligne;
	}
	// ------------------- Getters / Setters -------------------

	public  int getColonne() {
		return colonne;
	}
	public  Lignes getLigne() {
		return ligne;
	}
	public void setColonne(int i ) {
		colonne+=i;
	}
	public void setLigne(int i) {
		ligne.next();
	}
	
	// ------------------- Fonctions -------------------
	public String toString() {
		return "Position: colonne=" + colonne + ", ligne=" + ligne;
	}

	public boolean equals(Position p) {
		return colonne==p.getColonne() && ligne==p.getLigne();
	} 
	
	
}

