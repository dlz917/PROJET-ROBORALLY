package Model;

public class TestRobot {

	public static void main(String[] args) {
		
		//constructeur par default
		Robot robot =new Robot();
		System.out.println(robot+"\n");
		
		//robot du joueur1 (en position A2):
		Robot robot1 = new Robot("A2", 1, 5, 0, 0,"", 0);
		System.out.println(robot1);
		
		//////////////
		
		robot1.setPosition("B2");
		robot1.setNombreDeVie(4);


	}

}
