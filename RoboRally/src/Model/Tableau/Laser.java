package Model.Tableau;

import java.io.Serializable;

import Model.Robot.Direction;

public class Laser implements Serializable{
	protected Direction direction;
	
	public Laser(Direction direction) {
			this.direction=direction;
		}

	@Override
	public String toString() {
		return "Laser [direction=" + direction + "]";
	}

	}
