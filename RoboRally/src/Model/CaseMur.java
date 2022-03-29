package Model;

public class CaseMur extends CaseTableau {

private Direction direction;
	
	public CaseMur(Position location,Direction direction) {
		super(location);
		this.direction=direction;
		this.setTypeCase(TypeCase.caseMur);}

	@Override
	public String toString() {
		
		return "CaseMur [location=" + position + ", occupe=" + occupe + "[direction=" + direction + "]";
	}}

