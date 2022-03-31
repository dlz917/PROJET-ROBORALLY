package Model.Tableau;

import Model.Robot.Direction;

public class Laser {
	protected Direction direction;
	
	public Laser(Direction direction) {
			this.direction=direction;
		}

	@Override
	public String toString() {
		return "Laser [direction=" + direction + "]";
	}

	}
