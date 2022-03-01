package Model;

public class CaseTableau {
	// ------------------- Attributs -------------------
	private final Position position;
	private boolean occupe=false;
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



}

	
