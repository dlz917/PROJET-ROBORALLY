package Model.Robot;

import java.util.ArrayList;


import Model.Cartes.ActionCarte;
import Model.Cartes.CartesProgramme;
import Model.Tableau.CaseMur;
import Model.Tableau.Position;
import Model.Tableau.Tableau1;
import Model.Tableau.TypeCase;

public class Robot {
/*-------------------------------------ATRIBUTS-----------------------------------------*/
	private Position position;
	private int numeroRobot;
	private int nombreDeVie = 3;
	private EtatRobot etat = EtatRobot.vivant;
	private int nbrPionDegat=0;
	private Direction direction=null;
	private int nbrDeCarteEquipement=9;
	private Position dernierPosition;
	private int nbrDeDrapeau =0;
	private Position positionProvisoire=position;
	private ArrayList<CartesProgramme> ListeCarteChoisi=new ArrayList<CartesProgramme>();
	private String pseudo;
	private ArrayList<CartesProgramme> cartesDistribuees = new ArrayList();
	private Tableau1 tab ;
	
/*----------------------------------CONSTRUCTEURS-----------------------------------*/
	
	public Robot(Position position, String pseudo, Tableau1 tab){
		this.position = position;
		this.dernierPosition = position;
		this.pseudo=pseudo;
		this.tab = tab;
		}

/*-----------------------------------GETTERS/ SETTERS----------------------------------*/
	
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

	public EtatRobot getEtat() {
		return etat;
	}

	public void setEtat(EtatRobot etat) {
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
	
	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public Position getPositionProvisoire() {
		return positionProvisoire;
	}
	public void setPositionProvisoire(Position positionProvisoire) {
		this.positionProvisoire = positionProvisoire;
	}
	public ArrayList<CartesProgramme> getListeCarteChoisi() {
		return ListeCarteChoisi;
	}


	public void setListeCarteChoisi(ArrayList<CartesProgramme> listeCarteChoisi) {
		ListeCarteChoisi = listeCarteChoisi;
	}


	public ArrayList<CartesProgramme> getCartesDistribuees() {
		return cartesDistribuees;
	}


	public void setCartesDistribuees(ArrayList<CartesProgramme> cartesDistribuees) {
		this.cartesDistribuees = cartesDistribuees;
	}


	public Tableau1 getTab() {
		return tab;
	}


	public void setTab(Tableau1 tab) {
		this.tab = tab;
	}
/*-------------------------------------------FONCTION------------------------------------------*/

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
	
	public void pousserAutreRobot(Robot robot) {
		if(carte.getAction()==ActionCarte.avancer1) {/* peut-etre mettre un autre if*/
			if(getDirection()==Direction.nord){
				
				robot.position.setLigne(1);/* changement de la position du robot adverse */
			}
			if(getDirection()==Direction.sud) {
				robot.position.setLigne(-1);
			}if(getDirection()==Direction.ouest) {
				robot.position.setColonne(-1);
			}if(getDirection()==Direction.est) {
				robot.dernierPosition.setColonne(1);
			}	
		}
		if(carte.getAction()==ActionCarte.reculer1) {/* peut-etre mettre un autre if*/
			if(getDirection()==Direction.nord) {
				robot.position.setLigne(-1);
			}if(getDirection()==Direction.sud) {
				robot.position.setLigne(1);
			}if(getDirection()==Direction.ouest) {
				robot.position.setColonne(1);
			}if(getDirection()==Direction.est) {
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
	
	public Robot robotAPousser(Position pos, ArrayList<Robot> listeRobots) {
		for (int i =0; i < listeRobots.size();i++) {
			if ( listeRobots.get(i).position.equals(pos) ) {
				return listeRobots.get(i);
			}
		}
		Robot r = new Robot(pos, pseudo, tab);/* seul constructeur possible */
		return r;
	}
	
	public Direction directionOpposee () {
		if ( getDirection() == Direction.sud ) {
			return Direction.nord;
			}
		if ( getDirection() == Direction.nord ) {
			return Direction.sud;
			}
		if ( getDirection() == Direction.est ) {
			return Direction.ouest;
			}
		if ( getDirection() == Direction.ouest ) {
			return Direction.est;
			}
		return getDirection();
		}
	
	public boolean possibleDavancer (ArrayList<Robot> listeRobot) {
		if(tab.chercherCase(getPositionProvisoire()).getTypeCase() == TypeCase.caseTrou) {
			setPosition(dernierPosition);
			return false;
		}
		else {
			if(tab.chercherCase(getPositionProvisoire()).isOccupe()) {
				Robot r2 = robotAPousser(getPositionProvisoire(), partie.getListeRobots());
				pousserAutreRobot(r2);
				return true;
			}
			else {
				if (tab.chercherCase(getPositionProvisoire()).getTypeCase() == TypeCase.caseMur) {
					CaseMur caseMur = (CaseMur)tab.chercherCase(getPositionProvisoire());
					if ( caseMur.getDirection() == directionOpposee() ) {
						return false; // y'a un mur
					}
					
				}
			}
		}
	}
		
	
		
	public void deplacer(CartesProgramme carte) {
		
		if(carte.getAction()==ActionCarte.avancer1) {
			avancer();
			if(possibleDavancer(partie.getTableau())) {
				position=positionProvisoire;
			}
			/*afficher message si il ne peut pas avancer ? */
			
		}
		else if(carte.getAction()==ActionCarte.avancer2) 
		{  avancer();
		if(possibleDavancer() {
			position=positionProvisoire;
		}avancer();
		if(possibleDavancer()) {
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
		
	

	}}
