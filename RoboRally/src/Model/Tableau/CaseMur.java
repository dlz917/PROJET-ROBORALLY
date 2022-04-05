package Model.Tableau;

import java.io.Serializable;

import Model.Robot.Direction;

public class CaseMur extends CaseTableau implements Serializable {

private Direction direction;

	public CaseMur(Position location,Direction direction) {
		super(location);
		this.direction=direction;
		this.setTypeCase(TypeCase.caseMur);}

	public Direction getDirection() {
		return direction;
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
		public String toString() {
		
		return "CaseMur [location=" + getPosition() + ", occupe=" + isOccupe() + "[direction=" + direction + "]";
	}}

