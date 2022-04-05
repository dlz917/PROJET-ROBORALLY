package Model.Robot;

import java.io.Serializable;
import java.util.ArrayList;


import Model.Cartes.ActionCarte;
import Model.Cartes.CartesProgramme;
import Model.Tableau.CaseMur;
import Model.Tableau.CaseRoulant;
import Model.Tableau.Lignes;
import Model.Tableau.Position;
import Model.Tableau.Tableau1;
import Model.Tableau.TypeCase;

public class Robot implements Serializable{
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
	public Robot() {
	}
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
	
	
/*-------------------------------------------FONCTIONS------------------------------------------*/

	public String toString() {
		return 	("Robot : " + getNumeroRobot() +",\nPosition : "+getPosition()+ ",\nNombre de vie : " + getNombreDeVie() +",\nEtat : "+ getEtat()+
				",\nNombre de pion degat : "+getNbrPionDegat()+",\nNombre de carte equipement : "+ getNbrDeCarteEquipement()+
				",\nDerniere position : "+getDernierPosition()+",\nNombre de drapeau : "+ getNbrDeDrapeau());
	}
	
	// fonctions degat du robot
	public int perdreUneVie() {
		setNombreDeVie(getNombreDeVie()-1);
		setNbrPionDegat(10);
		if (getNombreDeVie()<=0) {
			setEtat(EtatRobot.mort);
		}
		return nombreDeVie;
	}
	
	public void degat() {
		setNbrPionDegat(getNbrPionDegat()-1);
		if (getNbrPionDegat() == 10) {
			perdreUneVie();
			setNbrPionDegat(0);
		}
	}
	// fonctions actions du tableau
	public void toucherAvecLaser(Robot robotQuiTouche, Robot robot) {
		degat();
	}
	
	public void verifDrapeau() {
		if (tab.chercherCase(getPosition()).isDrapeau()){
			setNbrDeDrapeau(getNbrDeDrapeau()+1);
			setDernierPosition(getPosition());
		}
	}
	
	public void caseRoulant() {
		if (tab.chercherCase(getPosition()).getTypeCase() == TypeCase.caseRoulant) {
			CaseRoulant caseRoulant = new CaseRoulant(getPosition(),getDirection());
				if(caseRoulant.getDirection() == Direction.nord){
					getPosition().setLigne(getPosition().getLigne().next());
				}
				else if(caseRoulant.getDirection() == Direction.sud){
					getPosition().setLigne(getPosition().getLigne().previous());
				}
				else if(caseRoulant.getDirection() == Direction.ouest){
					getPosition().setColonne(getPosition().getColonne()-1);
				}
				else if(caseRoulant.getDirection() == Direction.est){
					getPosition().setColonne(getPosition().getColonne()+1);
				}
		}
	}
	
	public void lasers(ArrayList<Robot> listeRobots) {
		if ( getDirection() == Direction.est ) {
			boolean fin = false;
			int i = getPosition().getColonne();
			while (!fin && i<=11) {
				Position pos = new Position(i, getPosition().getLigne());
				if (tab.chercherCase(pos).isOccupe()) {
					robotAPousser(pos,listeRobots).degat();
					fin=true;
				}
				i++;
			}
		}
		else if ( getDirection() == Direction.ouest ) {
			boolean fin = false;
			int i = getPosition().getColonne();
			while (!fin && i>=0) {
				Position pos = new Position(i, getPosition().getLigne());
				if (tab.chercherCase(pos).isOccupe()) {
					robotAPousser(pos,listeRobots).degat();
					fin=true;
				}
				i--;
			}
		}
		else if ( getDirection() == Direction.sud ) {
			boolean fin = false;
			Lignes l = getPosition().getLigne();
			while (!fin && l.equals(Lignes.A) ){
				Position pos = new Position(getPosition().getColonne(),l);
				if (tab.chercherCase(pos).isOccupe()) {
					robotAPousser(pos,listeRobots).degat();
					fin=true;
				}
				l.previous();
			}
		}
		else if ( getDirection() == Direction.nord ) {
			boolean fin = false;
			Lignes l = getPosition().getLigne();
			while (!fin && l.equals(Lignes.L) ){
				Position pos = new Position(getPosition().getColonne(),l);
				if (tab.chercherCase(pos).isOccupe()) {
					robotAPousser(pos,listeRobots).degat();
					fin=true;
				}
				l.next();
			}
		}
	}
	
	
	// fonctions pour avancer
	
	public int natureDeplacement(CartesProgramme carte) {
		// action avancer = 0 ; action reculer = 1 ; action tourner = -1
		if ( (carte.getAction() == ActionCarte.avancer1) || (carte.getAction() == ActionCarte.avancer2) || (carte.getAction() == ActionCarte.avancer3) ) {
			return 0;
		}
		else if (carte.getAction() == ActionCarte.reculer1) {
			return 1;
		}
		else
			return -1;
	}
	
	public void pousserAutreRobot(Robot robot, CartesProgramme carte, ArrayList<Robot> listeRobot) {
		if (robot.possibleDavancer(listeRobot, carte)){
			if( (getDirection()==Direction.nord && natureDeplacement(carte)==0) || (getDirection()==Direction.sud && natureDeplacement(carte)==1)){
				robot.getPosition().setLigne(robot.getPosition().getLigne().next());
			}
			else if( (getDirection()==Direction.sud && natureDeplacement(carte)==0) || (getDirection()==Direction.nord && natureDeplacement(carte)==1)){
				robot.getPosition().setLigne(robot.getPosition().getLigne().previous());
			}
			else if( (getDirection()==Direction.ouest && natureDeplacement(carte)==0) || (getDirection()==Direction.est && natureDeplacement(carte)==1)){
				robot.getPosition().setColonne(robot.getPosition().getColonne()-1);
			}
			else if( (getDirection()==Direction.est && natureDeplacement(carte)==0) || (getDirection()==Direction.ouest && natureDeplacement(carte)==1)){
				robot.getPosition().setColonne(robot.getPosition().getColonne()+1);
			}
		}
	}
	
	
	public void avancer() {
		if(getDirection()==Direction.nord) {
			getPositionProvisoire().setLigne(getPosition().getLigne().next());
		}if(getDirection()==Direction.sud) {
			getPositionProvisoire().setLigne(getPosition().getLigne().previous());
		}if(getDirection()==Direction.ouest) {
			getPositionProvisoire().setColonne(-1);
		}if(getDirection()==Direction.est) {
			getPositionProvisoire().setColonne(1);
		}
	}
	public void reculer() {
		if(getDirection()==Direction.nord) {
			getPositionProvisoire().setLigne(getPosition().getLigne().previous());
		}if(getDirection()==Direction.sud) {
			getPositionProvisoire().setLigne(getPosition().getLigne().next());
		}if(getDirection()==Direction.ouest) {
			getPositionProvisoire().setColonne(1);
		}if(getDirection()==Direction.est) {
			getPositionProvisoire().setColonne(-1);
		}
	}
	public void tournerD() {
		if(getDirection()==Direction.nord) {
			setDirection(Direction.est);
		}if(getDirection()==Direction.sud) {
			setDirection(Direction.ouest);
		}if(getDirection()==Direction.ouest) {
			setDirection(Direction.nord);
		}if(getDirection()==Direction.est) {
			setDirection(Direction.sud);
		}
	}
	
	public void tournerG() {
		if(getDirection()==Direction.nord) {
			setDirection(Direction.ouest);
		}if(getDirection()==Direction.sud) {
			setDirection(Direction.est);
		}if(getDirection()==Direction.ouest) {
			setDirection(Direction.sud);
		}if(getDirection()==Direction.est) {
			setDirection(Direction.nord);
		}
	}
		
	public void demiTour() {
		if(getDirection()==Direction.nord) {
			setDirection(Direction.sud);
		}if(getDirection()==Direction.sud) {
			setDirection(Direction.nord);
		}if(getDirection()==Direction.ouest) {
			setDirection(Direction.est);
		}if(getDirection()==Direction.est) {
			setDirection(Direction.ouest);
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
	
	public boolean possibleDavancer (ArrayList<Robot> listeRobot, CartesProgramme carte) {
		if(tab.chercherCase(getPositionProvisoire()).getTypeCase() == TypeCase.caseTrou) {
			setPositionProvisoire(dernierPosition);
			perdreUneVie();
			return false;
		}
		else if (tab.chercherCase(getPositionProvisoire()).isOccupe()) {
			Robot r2 = robotAPousser(getPositionProvisoire(), listeRobot);
			pousserAutreRobot(r2, carte, listeRobot);
			return true;
		}
		else if (tab.chercherCase(getPositionProvisoire()).getTypeCase() == TypeCase.caseMur) {
			CaseMur caseMur = (CaseMur)tab.chercherCase(getPositionProvisoire());
			if ( caseMur.getDirection() == directionOpposee() ) {
				return false; // y'a un mur
			}
		}
		else if (tab.chercherCase(getPositionProvisoire()).isDrapeau()) {
			
			if ( tab.chercherCase(getPositionProvisoire()).getPosition().getLigne() == Lignes.A ) {
				if ( tab.chercherCase(getPositionProvisoire()).getPosition().getColonne() == 0 ) {
					if ( (getDirection()==Direction.nord) && (getDirection()==Direction.est) ) {
						return true;
					}
				}
				else if ( tab.chercherCase(getPositionProvisoire()).getPosition().getColonne() == 11 ) {
					if ( (getDirection()==Direction.nord) && (getDirection()==Direction.ouest) ) {
						return true;
					}
				}
			}
			else if ( tab.chercherCase(getPositionProvisoire()).getPosition().getLigne() == Lignes.L ) {
				if ( tab.chercherCase(getPositionProvisoire()).getPosition().getColonne() == 0 ) {
					if ( (getDirection()==Direction.sud) && (getDirection()==Direction.est) ) {
						return true;
					}
				}
				else if ( tab.chercherCase(getPositionProvisoire()).getPosition().getColonne() == 11 ) {
					if ( (getDirection()==Direction.sud) && (getDirection()==Direction.ouest) ) {
						return true;
					}
				}
			}
			else
				return false;
		}
		
		return true;
	}
		
	public int iteAvancer (CartesProgramme carte) {
		if (carte.getAction()==ActionCarte.avancer1) {
			return 1;
		}
		else if (carte.getAction()==ActionCarte.avancer2) {
			return 2;
		}
		else if (carte.getAction()==ActionCarte.avancer2) {
			return 3;
		}
		return 0;
	}
		
	public void deplacer(ArrayList<Robot> listeRobot, CartesProgramme carte) {
		if (natureDeplacement(carte) == -1) {
			if(carte.getAction()==ActionCarte.tournerD) {
				tournerD();
				}
			else if(carte.getAction()==ActionCarte.tournerG) {
				tournerG();
				}
			else if(carte.getAction()==ActionCarte.demitour) {
				demiTour();
			}
		}
			
		else if(natureDeplacement(carte) == 1) {
			reculer();
			if (possibleDavancer(listeRobot, carte)) {
				position=positionProvisoire;
			}
		}
		else if (natureDeplacement(carte) == 0) {
			for (int i =0; i< iteAvancer(carte);i++) {
				avancer();
				if (possibleDavancer(listeRobot, carte)) {
					position=positionProvisoire;
				}
			}
		}
	}
	
	
}
