package Model;

public class CaseLaser extends CaseTableau {
	private Laser laser;
	public CaseLaser(Position location) {
		super(location);
		this.laser=new Laser();
	}
	@Override
	public String toString() {
		return "CaseLaser [occupe=" + occupe + ", laser=" + laser + ", position=" + position + ", drapeau=" + drapeau
				+ "]";
	}

}
