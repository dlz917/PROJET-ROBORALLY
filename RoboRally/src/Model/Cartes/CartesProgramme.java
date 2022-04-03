package Model.Cartes;

//import java.util.Iterator;



public class CartesProgramme implements Comparable<CartesProgramme> {
	private int vitesse= 0;
	private ActionCarte action = null;
	private int robotAttribue =-1 ;
	
	// ------------------- Constructeur -------------------
	
	public CartesProgramme(int vitesse, ActionCarte action) {
		this.vitesse= vitesse;
		this.action = action;
	}
	public CartesProgramme() {
	}
		
	// ------------------- Getters / Setters -------------------
	public int getVitesse() {
		return vitesse;
	}
	
	public ActionCarte getAction() {  
		return action;
	}
	public int getRobotAttribue() {
		return robotAttribue;
	}
	public void setRobotAttribue(int robotAttribue) {
		this.robotAttribue = robotAttribue;
	}
	
	
	// ------------------- Fonctions -------------------
	public String toString() {
		return "Action carte : "+getAction()+" / Vitesse carte : "+getVitesse()+"\n";
	}
	
	public boolean equals(CartesProgramme c) {
		return vitesse==c.getVitesse() && action==c.getAction();
	} 
	
	public int compareTo (CartesProgramme e) {
		if (vitesse < e.vitesse)
			return -1;
		if (vitesse > e.vitesse)
			return 1;
		return 0;
	}
	
}


