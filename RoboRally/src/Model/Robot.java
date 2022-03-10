package Model;


public class Robot {
	private Position position;
	private int numeroRobot;
	private int nombreDeVie;
	private Etat etat = Etat.vivant;
	private int nbrPionDegat;
	private Direction direction=null;
	private int nbrDeCarteEquipement;
	private String dernierPosition;
	private int nbrDeDrapeau;
	
	Robot(){};
	
	Robot(Position position, int numeroRobot, int nombreDeVie, int nbrPionDegat, int nbrDeCarteEquipement,
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
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
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
	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		if(direction!=null)
			this.direction = direction;
	}

	public String toString() {
		return 	("Robot : " + getNumeroRobot() +",\nPosition : "+getPosition()+ ",\nNombre de vie : " + getNombreDeVie() +",\nEtat : "+ getEtat()+
				",\nNombre de pion degat : "+getNbrPionDegat()+",\nNombre de carte equipement : "+ getNbrDeCarteEquipement()+
				",\nDerniere position : "+getDernierPosition()+",\nNombre de drapeau : "+ getNbrDeDrapeau());
	}
	
	/*public String seDeplacer(Boolean siMur, Boolean siRobotDevant) {
		if (!siMur && !siRobotDevant)
			setPosition("");
			//position??
		return position;
	}*/
	
	
	
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
	

	
	public void mourir() {
		setNombreDeVie(0);
		Etat etat=Etat.mort; // � revoir
		setEtat(etat);
		
	}
	
	public void pousserAutreRobot(Robot robotQuiPousse, Robot robot) {
		//setPosition.robot("");
	}
	
	public void toucherAvecLaser(Robot robotQuiTouche, Robot robot) {
		degat();
		
	}
	
	public void avancer() {
		if(getDirection()==Direction.nord) {
			position.setLigne(1);
		}if(getDirection()==Direction.sud) {
			position.setLigne(-1);
		}if(getDirection()==Direction.ouest) {
			position.setColonne(-1);
		}if(getDirection()==Direction.est) {
			position.setColonne(1);
		}
	}
		
		
	public void deplacer(CartesProgramme carte) {
		if(carte.getAction()==ActionCarte.avancer1) {
			//verif que case d'apres est pas un mur
			avancer();
		}
		else if(carte.getAction()==ActionCarte.avancer2) 
		{
			//verif que case d'apres est pas un mur
			avancer();
			//verif que case d'apres est pas un mur
			avancer();
		}else if(carte.getAction()==ActionCarte.avancer3) {
			//verif que case d'apres est pas un mur
			avancer();
			//verif que case d'apres est pas un mur
			avancer();
			//verif que case d'apres est pas un mur
			avancer();
		}
		else if(carte.getAction()==ActionCarte.reculer1) {
			position=ligne-1;}
		else if(carte.getAction()==ActionCarte.tournerD) {
			/*position=colonne+1 ou direction.est*/}
		
		else if(carte.getAction()==ActionCarte.tournerG) {
			/* position= colonne+1 ou direction.ouest;
	
			 */}
		else if(carte.getAction()==ActionCarte.demitour) {
			/* position=ligne -1 et direction.sud;*/
		}
		
		
		return position;
	}
		
	}

}
