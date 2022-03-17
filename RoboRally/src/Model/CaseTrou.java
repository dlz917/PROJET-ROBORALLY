package Model;

public class CaseTrou extends CaseTableau {

	public CaseTrou(Position location) {
		super(location);
		setOccupe(true);
	}
	public String toString() {
		return "CaseTrou [position=" + position + ", occupe=" + occupe + ", drapeau=" + drapeau + "]";
	}

}
