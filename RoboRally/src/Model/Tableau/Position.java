package Model.Tableau;

import java.io.Serializable;

public class Position implements Serializable{
	private int colonne;
	private Lignes ligne;
	
	// ------------------- Constructeur -------------------

	public Position(int colonne, Lignes ligne) {
		this.colonne = colonne;
		this.ligne = ligne;
	}
	public Position() {
	}
	// ------------------- Getters / Setters -------------------

	public  int getColonne() {
		return colonne;
	}
	public  Lignes getLigne() {
		return ligne;
	}
	public void setColonne(int i ) {
		this.colonne = i;
	}
	public void setLigne(Lignes l) {
		this.ligne = l;
	}
	
	// ------------------- Fonctions -------------------
	public String toString() {
		return "Position: colonne=" + colonne + ", ligne=" + ligne;
	}

	public boolean equals(Position p) {
		return colonne==p.getColonne() && ligne==p.getLigne();
	} 
	
	
}

