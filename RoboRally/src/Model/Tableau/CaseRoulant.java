package Model.Tableau;

import java.io.Serializable;

import Model.Robot.Direction;

public class CaseRoulant extends CaseTableau implements Serializable{
	private Direction direction;
	
	public CaseRoulant(Position location,Direction direction) {
		super(location);
		this.setDirection(direction);
		this.setTypeCase(TypeCase.caseRoulant);}

	public Direction getDirection() {
		return direction;}
	
	public void setDirection(Direction direction) {
		this.direction = direction;}

	@Override
	public String toString() {
		return "CaseRoulant [direction=" + direction + ", position=" + getPosition() + ", occupe=" + isOccupe() + ", drapeau="
				+ isDrapeau() + "]";
	}
		
	
	}
