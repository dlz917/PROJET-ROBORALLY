package Model;

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
