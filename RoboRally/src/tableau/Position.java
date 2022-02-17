package tableau;

public class Position {
	private final int colonne;
	private final Lignes ligne;
	private final  String nom;
	
	// ------------------- Constructeur -------------------

	public Position(int colonne, Lignes ligne) {
		this.colonne = colonne;
		this.ligne = ligne;
		this.nom= ligne.toString()+colonne;
	}
	// ------------------- Getters / Setters -------------------

	public int getColonne() {
		return colonne;
	}
	public Lignes getLigne() {
		return ligne;
	}
	public String getNom() {
		return nom;
	}
	// ------------------- Fonctions -------------------
	public String toString() {
		return "Position [colonne=" + colonne + ", ligne=" + ligne + ", nom=" + nom + "]";
	}
	
}

