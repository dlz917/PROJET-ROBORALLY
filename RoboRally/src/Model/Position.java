package Model;

public class Position {
	private final int colonne;
	private final Lignes ligne;
	
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
	public int setColonne() {
		return colonne;
	}
	public Lignes setLigne() {
		return ligne;
	}
	
	// ------------------- Fonctions -------------------
	public String toString() {
		return "Position: colonne=" + colonne + ", ligne=" + ligne;
	}
	
}

