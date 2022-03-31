package Model.Tableau;

public class CaseTrou extends CaseTableau {

	public CaseTrou(Position location) {
		super(location);
		setOccupe(true);
		this.setTypeCase(TypeCase.caseTrou);
	}
	public String toString() {
		return "CaseTrou [position=" + position + ", occupe=" + occupe + ", drapeau=" + drapeau + "]";
	}

}
