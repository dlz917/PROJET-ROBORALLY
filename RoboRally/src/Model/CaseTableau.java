package Model;

public class CaseTableau {
	// ------------------- Attributs -------------------
	private final Position location;
	private boolean occupe=false;
	// ------------------- Constructeurr -------------------
	public CaseTableau(Position location) {
		this.location = location;
	}
	// ------------------- Getters / Setters -------------------
	public boolean isOccupe() {
		return occupe;
	}

	public void setOccupe(boolean occupe) {
		this.occupe = occupe;
	}

	public Position getLocation() {
		return location;
	}

	// ------------------- Fonctions -------------------
	public String toString() {
		return "CaseTableau [location=" + location + ", occupe=" + occupe + "]";
	}



}

	
