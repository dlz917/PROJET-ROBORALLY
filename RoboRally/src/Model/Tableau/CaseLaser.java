package Model.Tableau;

import Model.Robot.Direction;

public class CaseLaser extends CaseTableau {
	private Laser laser;
	public CaseLaser(Position location,Direction d) {
		super(location);
		this.laser=new Laser(d);
		this.setTypeCase(TypeCase.caseLaser);		
	}
	@Override
	public String toString() {
		return "CaseLaser [occupe=" + occupe + ", laser=" + laser + ", position=" + position + ", drapeau=" + drapeau
				+ "]";
	}

}
