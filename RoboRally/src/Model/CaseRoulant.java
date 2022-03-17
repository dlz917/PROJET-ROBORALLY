package Model;

public class CaseRoulant extends CaseTableau {
	private Direction direction;
	
	public CaseRoulant(Position location,Direction direction) {
		super(location);
		this.setDirection(direction);}

	public Direction getDirection() {
		return direction;}
	
	public void setDirection(Direction direction) {
		this.direction = direction;}

	@Override
	public String toString() {
		return "CaseRoulant [direction=" + direction + ", position=" + position + ", occupe=" + occupe + ", drapeau="
				+ drapeau + "]";
	}
		
	
	}
