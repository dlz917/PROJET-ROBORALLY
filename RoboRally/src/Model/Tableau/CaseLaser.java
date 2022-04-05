package Model.Tableau;

import java.io.Serializable;

import Model.Robot.Direction;

public class CaseLaser extends CaseTableau implements Serializable {
	private Laser laser;
	
	public CaseLaser(Position location,Direction d) {
		super(location);
		this.laser=new Laser(d);
		this.setTypeCase(TypeCase.caseLaser);		
	}
	@Override
	public String toString() {
		return "CaseLaser [occupe=" + isOccupe() + ", laser=" + laser + ", position=" + getPosition() + ", drapeau=" + isDrapeau()
				+ "]";
	}

}
