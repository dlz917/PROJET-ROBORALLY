package Model;


public class Robot {
	private String position;
	private int numeroRobot;
	private int nombreDeVie;
	private Etat etat = Etat.HT;
	private int nbrPionDegat;
	//private String direction; � revoir
	private int nbrDeCarteEquipement;
	private String dernierPosition;
	private int nbrDeDrapeau;
	
	Robot(){};
	
	Robot(String position, int numeroRobot, int nombreDeVie, int nbrPionDegat, int nbrDeCarteEquipement,
			String dernierPosition, int nbrDeDrapeau){
		setPosition(position);
		setNumeroRobot(numeroRobot);
		setNombreDeVie(nombreDeVie);
		setNbrPionDegat(nbrPionDegat);
		//setDirection(direction);
		setNbrDeCarteEquipement(nbrDeCarteEquipement);
		setDernierPosition(dernierPosition);
		setNbrDeDrapeau(nbrDeDrapeau);
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		if (position != null)
			this.position = position;
		else
			System.err.println("[setPosition] error : " + position);
	}

	public int getNumeroRobot() {
		return numeroRobot;
	}

	public void setNumeroRobot(int numeroRobot) {
		if (numeroRobot >0) // se mettre d'accord sur les numero des robots
			this.numeroRobot = numeroRobot;
		else
			System.err.println("[setNum_obot] error : " + numeroRobot);
	}

	public int getNombreDeVie() {
		return nombreDeVie;
	}

	public void setNombreDeVie(int nombreDeVie) {
		if (nombreDeVie>=0 && nombreDeVie <6)
			this.nombreDeVie = nombreDeVie;
		else
			System.err.println("[setNum_obot] error : " + nombreDeVie);
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		if (etat != null)
			this.etat = etat;
	else
		System.err.println("[setEtat] error : "+etat);
	}

	public int getNbrPionDegat() {
		return nbrPionDegat;
	}

	public void setNbrPionDegat(int nbrPionDegat) {
		if(nbrPionDegat>=0)
			this.nbrPionDegat = nbrPionDegat;
		else
			System.err.println("[setNbrPionDegat] error : "+nbrPionDegat);
	}

	/*public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		if(direction!=null) 
			this.direction = direction;
		else
			System.err.println("[setDirection] error : "+direction);
	}*/

	public int getNbrDeCarteEquipement() {
		return nbrDeCarteEquipement;
	}

	public void setNbrDeCarteEquipement(int nbrDeCarteEquipement) {
		if (nbrDeCarteEquipement>=0)
			this.nbrDeCarteEquipement = nbrDeCarteEquipement;
		else
			System.err.println("[setNbrDeCarteEquipement] error : "+nbrDeCarteEquipement);
	}

	public String getDernierPosition() {
		return dernierPosition;
	}

	public void setDernierPosition(String dernierPosition) {
		if (dernierPosition!=null)
			this.dernierPosition = dernierPosition;
		else
			System.err.println("[setDernierPosition] error : "+dernierPosition);
	}

	public int getNbrDeDrapeau() {
		return nbrDeDrapeau;
	}

	public void setNbrDeDrapeau(int nbrDeDrapeau) {
		if(nbrDeDrapeau>=0) 
			this.nbrDeDrapeau = nbrDeDrapeau;
		else
			System.err.println("[setNbrDeDrapeau] error : "+nbrDeDrapeau);
	}
	
	public String toString() {
		return 	("Robot : " + getNumeroRobot() +",\nPosition : "+getPosition()+ ",\nNombre de vie : " + getNombreDeVie() +",\nEtat : "+ getEtat()+
				",\nNombre de pion degat : "+getNbrPionDegat()+",\nNombre de carte equipement : "+ getNbrDeCarteEquipement()+
				",\nDerniere position : "+getDernierPosition()+",\nNombre de drapeau : "+ getNbrDeDrapeau());
	}
	
	public String seDeplacer(Boolean siMur, Boolean siRobotDevant) {
		if (!siMur && !siRobotDevant)
			setPosition("");
			//position??
		return position;
	}
	
	public int perdreUneVie() {
		nombreDeVie -= 1;
		return nombreDeVie;
	}
	
	public int degat() {
		nbrPionDegat+=1;
		if (nbrPionDegat == 10)
			perdreUneVie();
			nbrPionDegat =0;
		return nbrPionDegat;
	}
	
	//Pour changer d'�tat : utilisation setteur OU
	public Etat changerEtat(Etat etatNouveau) {
		etat = etatNouveau;
		return etat;
	}
	

	
	public void mourir() {
		setNombreDeVie(0);
		Etat HT = null; // � revoir
		setEtat(HT);
		
	}
	
	public void pousserAutreRobot(Robot robotQuiPousse, Robot robot) {
		//setPosition.robot("");
	}
	
	public void toucherAvecLaser(Robot robotQuiTouche, Robot robot) {
		degat();
		
	}

}
