package Model;

public class Laser {
	protected Direction direction;
	
	public Laser() {
		double a=Math.random();
		if (a<= 0.25)
			this.direction=direction.sud;
		if (a> 0.25 && a<=0.50)
			this.direction=direction.nord;
		if (a> 0.5 && a<=0.75)			
			this.direction=direction.est;
		else
			this.direction=direction.ouest;}
	
	public Laser(Direction direction) {
			this.direction=direction;
		}

	}
