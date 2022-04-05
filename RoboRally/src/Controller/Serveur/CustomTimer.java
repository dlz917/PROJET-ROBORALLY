package Controller.Serveur;

import java.util.TimerTask;

public class CustomTimer extends TimerTask{
	
	private int time = 120;
	
	public void run() {
		try{
			if (time == 60)
					System.out.println("Il reste 60sec!");
			if (time==0)
				cancel();
			time--;
		}catch(Exception exp) {System.out.println(exp);}		
	}

}
