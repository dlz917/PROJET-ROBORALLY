package Model;


public class Robot {
	private Position position;
	private int numeroRobot;
	private int nombreDeVie;
	private Etat etat = Etat.vivant;
	private int nbrPionDegat;
	private Direction direction=null;
	private int nbrDeCarteEquipement;
	private Position dernierPosition;
	private int nbrDeDrapeau
	private Position positionProvisoire=position;
	
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

	public Position getDernierPosition() {
		return dernierPosition;
	}

	public void setDernierPosition(Position dernierPosition) {
		if (dernierPosition!=null)
			this.dernierPosition = dernierPosition;/*drapeau ou point de départ*/
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
		if(carte.getAction()==ActionCarte.avancer1) {/* peut-etre mettre un autre if*/
			if(robotQuiPousse.getDirection()==Direction.nord){
				
				robot.position.setLigne(1);/* changement de la position du robot adverse */
			}
			if(robotQuiPousse.getDirection()==Direction.sud) {
				robot.position.setLigne(-1);
			}if(robotQuiPousse.getDirection()==Direction.ouest) {
				robot.position.setColonne(-1);
			}if(robotQuiPousse.getDirection()==Direction.est) {
				robot.dernierPosition.setColonne(1);
			}
		
			
		}
		if(carte.getAction()==ActionCarte.reculer1) {/* peut-etre mettre un autre if*/
			if(robotQuiPousse.getDirection()==Direction.nord) {
				robot.position.setLigne(-1);
			}if(robotQuiPousse.getDirection()==Direction.sud) {
				robot.position.setLigne(1);
			}if(robotQuiPousse.getDirection()==Direction.ouest) {
				robot.position.setColonne(1);
			}if(robotQuiPousse.getDirection()==Direction.est) {
				robot.position.setColonne(-1);
			}
		}
		
		
					
		
	}
	
	public void toucherAvecLaser(Robot robotQuiTouche, Robot robot) {
		degat();
		
	}
	
	public void avancer() {
		if(getDirection()==Direction.nord) {
			positionProvisoire.setLigne(1);
		}if(getDirection()==Direction.sud) {
			positionProvisoire.setLigne(-1);
		}if(getDirection()==Direction.ouest) {
			positionProvisoire.setColonne(-1);
		}if(getDirection()==Direction.est) {
			positionProvisoire.setColonne(1);
		}
	}
	public void reculer() {
		if(getDirection()==Direction.nord) {
			positionProvisoire.setLigne(-1);
		}if(getDirection()==Direction.sud) {
			positionProvisoire.setLigne(1);
		}if(getDirection()==Direction.ouest) {
			positionProvisoire.setColonne(1);
		}if(getDirection()==Direction.est) {
			positionProvisoire.setColonne(-1);
		}
	}
	public void tournerD() {
		if(getDirection()==Direction.nord) {
			direction=Direction.est;
		}if(getDirection()==Direction.sud) {
			direction=Direction.ouest;
		}if(getDirection()==Direction.ouest) {
			direction=Direction.nord;
		}if(getDirection()==Direction.est) {
			direction=Direction.sud;
		}
	}
	
	public void tournerG() {
		if(getDirection()==Direction.nord) {
			direction=Direction.ouest;
		}if(getDirection()==Direction.sud) {
			direction=Direction.est;
		}if(getDirection()==Direction.ouest) {
			direction=Direction.sud;
		}if(getDirection()==Direction.est) {
			direction=Direction.nord;
		}
	}
		
	public void demiTour() {
		if(getDirection()==Direction.nord) {
			direction=Direction.sud;
		}if(getDirection()==Direction.sud) {
			direction=Direction.nord;
		}if(getDirection()==Direction.ouest) {
			direction=Direction.est;
		}if(getDirection()==Direction.est) {
			direction=Direction.ouest;
		}
	}
	 public boolean possibleDavancer() {
			if(positionProvisoire==CaseTableau.occupe) {
				if(positionProvisoire.equals(CaseMur.position)) {
					return true;
					//si mur robot reste sur place
					
				}
				if(positionProvisoire==Robot.position)/* position des autres robits prendre valeur dans la liste*/ {
					pousserAutreRobot();
					return false;
					
					avancer();//dans meme sens que le robot qui pousse
				}
				if(positionProvisoire.equals(CaseTrou.position)) {
					position=dernierPosition;//robot retourne derniere position
					return true;
				}
					
				}
					
				 
			
		
		 
	 }
		
		
		
	public void deplacer(CartesProgramme carte) {
		boolean mur=false;
		
		if(carte.getAction()==ActionCarte.avancer1) {
			avancer();
			if(possibleDavancer()==false) {
				position=positionProvisoire;
			}
			/*afficher message si il ne peut pas avancer ? */
			
		}
		else if(carte.getAction()==ActionCarte.avancer2) 
		{  avancer();
		if(possibleDavancer()==false) {
			position=positionProvisoire;
		}avancer();
		if(possibleDavancer()==false) {
			position=positionProvisoire;
		}
		}
		else if(carte.getAction()==ActionCarte.avancer3) {
			avancer();
			if(possibleDavancer()==false) {
				position=positionProvisoire;
			}
			avancer();
			if(possibleDavancer()==false) {
				position=positionProvisoire;
			}
			avancer();
			if(possibleDavancer()==false) {
				position=positionProvisoire;
			}
		}
		else if(carte.getAction()==ActionCarte.reculer1) {
			reculer();
			if(possibleDavancer()==false) {
				position=positionProvisoire;
			}
		else if(carte.getAction()==ActionCarte.tournerD) {
			//besoin de verifier vu qu'il reste sur place ???
			tournerD();
			}
		
		else if(carte.getAction()==ActionCarte.tournerG) {
			//besoin de verifier vu qu'il reste sur place ???
			tournerG();
			}
		else if(carte.getAction()==ActionCarte.demitour) {
			//besoin de verifier vu qu'il reste sur place ???
			demiTour();
		}
	
	}
		
	

}
