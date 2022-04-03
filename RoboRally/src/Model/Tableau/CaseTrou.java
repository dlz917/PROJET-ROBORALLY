package Model.Tableau;

import java.io.Serializable;

public class CaseTrou extends CaseTableau implements Serializable{

	public CaseTrou(Position location) {
		super(location);
		setOccupe(true);
		this.setTypeCase(TypeCase.caseTrou);
	}
	public String toString() {
		return "CaseTrou [position=" + position + ", occupe=" + occupe + ", drapeau=" + drapeau + "]";
	}

}
