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

/*-----------------------------------------------CLASS ROBOT-----------------------------------------------
 * 
 * LES ATTRIBUTS DE LA CLASS:
 * 
 * 		- Position position
 * 		- int numeroRobot
 * 		- int nombreDeVie
 * 		-  EtatRobot etat
 * 		- int nbrPionDegat
 * 		-  Direction direction
 * 		- Position dernierPosition
 * 		- int nbrDeDrapeau 
 * 		-  Position positionProvisoire
 * 		- ArrayList<CartesProgramme> ListeCarteChoisi
 * 		-  String pseudo
 * 		- ArrayList<CartesProgramme> cartesDistribuees
 * 		- Tableau1 tab
 * 
 *  LES MÉTHODES DE LA CLASS:
 *  
 *  	- toString() 
 *  		> affiche les informations du robot : son numéro, sa position, ses nombres de vie
 *  			son état, nombre de pion dégat , nombre de drapeau atteint et sa direction
 *  
 *  	- perdreUneVie() 
 *  		>  -1 au nombre de vie et si nombre de vie <0 l'état du robot devient mort
 *  				et retourne le nombre de vie
 *  
 *  	- degat()
 *  		> +1 au nombre de pion dégat et appel fonction perdreUneVie()
 *  
 *  	- toucherAvecLaser(Robot robotQuiTouche, Robot robot)
 *  		> appel fonction degat()
 *  
 *  	- verifDrapeau()
 *  		> recherche case avec drapeaux  dans le tableau et compare la position du robot avec la position des drapeaux
 *  
 *  	- caseRoulant()
 *  		>recherche case avec tapis roulant et compare avec position du robot 
 *  
 *  	- lasers(ArrayList<Robot> listeRobots)
 *  		>lance laser du robot dans sa direction 
 *  
 *  	- robotTouche(Position pos, ArrayList<Robot> listeRobots) 
 *  		>Cherche dns list robot robot sur la même direction du laser du robot
 *  
 *  	- natureDeplacement(CartesProgramme carte)
 *  		> definit l'action carte programme et renvoie 0 pour avancer , 1 pour reculer et -1 pour les actions tourner
 *  
 *  	- pousserAutreRobot(Robot robot, CartesProgramme carte, ArrayList<Robot> listeRobot) 
 *  		> fonction qui pousse robot adverse  pour laisser place au robot
 *  		> appel fonction possible d'avancer
 *  		> et pousse robot adverse  selon direction du robot
 *  
 *  	- avancer()
 *  		> renvoie dans position provisoire la position que le robot prend si il avance
 *  
 *  	- reculer()
 *  		> renvoie dans position provisoire la position que le robot prend si il recule
 *  
 *  	-tournerD()
 *  		> donne la nouvelle direction du robot en tournant vers la droite
 *  
 *  	-tournerG()
 *  		> donne la nouvelle direction du robot en tournant vers la gauche
 *  
 *  	- demiTour()
 *  		>donne la nouvelle direction du robot après demi-tour
 *  
 *  	- robotAPousser(Position pos, ArrayList<Robot> listeRobots) 
 *  		>cherche robot adverse présent sur la position provisoire
 *  		> retourne le robot adverse
 *  
 *  	- directionOpposee ()
 *  		> retourne les directions opposées
 *  
 *  	- possibleDavancer (ArrayList<Robot> listeRobot, CartesProgramme carte)
 *  		> verifier si obstacle sur position provisoire et cherche quel obstacle
 *  		> retourne false ou true
 *  
 *  	- iteAvancer (CartesProgramme carte)
 *  		> cherche quelle carte avancer
 *  		> si avancer1 retourne 1, si avancer2 retourne 2 et si avancer3 retourne 3 sinon 0
 *  
 *  	-deplacer(ArrayList<Robot> listeRobot, CartesProgramme carte)
 *  		> prend la carte action et change position ou direction selon carte et si possibilité
 *  	
 *  	-laserTableau()
 *      	> retourner robot tocuher par un laser du tableau 
 *  	

 */

public class Robot implements Serializable{
/*-------------------------------------ATTRIBUTS-----------------------------------------*/
	private Position position;
	private int numeroRobot;
	private int nombreDeVie = 3;
	private EtatRobot etat = EtatRobot.vivant;
	private int nbrPionDegat=0;
	private Direction direction=null;
	private Position dernierPosition = new Position();
	private int nbrDeDrapeau =0;
	private Position positionProvisoire;
	private ArrayList<CartesProgramme> ListeCarteChoisi=new ArrayList<CartesProgramme>();
	private String pseudo;
	private ArrayList<CartesProgramme> cartesDistribuees = new ArrayList();
	private Tableau1 tab ;
	
/*----------------------------------CONSTRUCTEURS-----------------------------------*/
	public Robot() {
	}
	public Robot(Position position, String pseudo, Tableau1 tab, int numRobot, Direction direction){
		this.position = position;
		this.positionProvisoire = position;
		getDernierPosition().setColonne(position.getColonne());
		getDernierPosition().setLigne(position.getLigne());
		this.pseudo=pseudo;
		this.tab = tab;
		this.numeroRobot=numRobot;
		this.direction=direction;
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

	public Position getDernierPosition() {
		return dernierPosition;
	}

	public void setDernierPosition(Position dernierPosition) {
		if (dernierPosition!=null)
			this.dernierPosition = dernierPosition;/*drapeau ou point de dÃ©part*/
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
				",\nNombre de pion degat : "+getNbrPionDegat()+",\nNombre de drapeau : "+ getNbrDeDrapeau()+"\nDirection : "+ getDirection()+"\n");
	}
	
	// fonctions degat du robot
	public int perdreUneVie() {
		setNombreDeVie(getNombreDeVie()-1);
		setNbrPionDegat(0);
		if (getNombreDeVie()<=0) {
			setEtat(EtatRobot.mort);
		}
		return nombreDeVie;
	}
	
	public void degat() {
		setNbrPionDegat(getNbrPionDegat()+1);
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
				fin = robotTouche(pos, listeRobots);
				i++;
			}
		}
		else if ( getDirection() == Direction.ouest ) {
			boolean fin = false;
			int i = getPosition().getColonne();
			while (!fin && i>=0) {
				Position pos = new Position(i, getPosition().getLigne());
				fin = robotTouche(pos, listeRobots);
				i--;
			}
		}
		else if ( getDirection() == Direction.sud ) {
			boolean fin = false;
			Lignes l = getPosition().getLigne();
			while (!fin && l.equals(Lignes.A) ){
				Position pos = new Position(getPosition().getColonne(),l);
				fin = robotTouche(pos, listeRobots);
				l.previous();
			}
		}
		else if ( getDirection() == Direction.nord ) {
			boolean fin = false;
			Lignes l = getPosition().getLigne();
			while (!fin && l.equals(Lignes.L) ){
				Position pos = new Position(getPosition().getColonne(),l);
				fin = robotTouche(pos, listeRobots);
				l.next();
			}
		}
	}
	
	public boolean robotTouche(Position pos, ArrayList<Robot> listeRobots) {
		for (int i =0; i < listeRobots.size();i++) {
			if ( (i!= getNumeroRobot()) && (listeRobots.get(i).position.equals(pos) )) {
				 listeRobots.get(i).degat();
				 return true;
			}
		}
		return false;
	}
	
	
	// fonctions pour avancer
	
	public int natureDeplacement(CartesProgramme carte) {
		// action avancer = 0 ; action reculer = 1 ; action tourner = -1
		if ( (carte.getAction() == ActionCarte.avancer1) | (carte.getAction() == ActionCarte.avancer2) | (carte.getAction() == ActionCarte.avancer3) ) {
			return 0;
		}
		else if (carte.getAction() == ActionCarte.reculer1) {
			return 1;
		}
		else
			return -1;
	}
	
	
	public void avancer() {
		if(getDirection()==Direction.nord) {
			getPositionProvisoire().setLigne(getPosition().getLigne().next());
		}
		else if(getDirection()==Direction.sud) {
			getPositionProvisoire().setLigne(getPosition().getLigne().previous());
		}
		else if(getDirection()==Direction.ouest) {
			getPositionProvisoire().setColonne(getPosition().getColonne()-1);
		}
		else if(getDirection()==Direction.est) {
			getPositionProvisoire().setColonne(getPosition().getColonne()+1);
		}
	}
	public void reculer() {
		if(getDirection()==Direction.nord) {
			getPositionProvisoire().setLigne(getPosition().getLigne().previous());
		}
		else if(getDirection()==Direction.sud) {
			getPositionProvisoire().setLigne(getPosition().getLigne().next());
		}
		else if(getDirection()==Direction.ouest) {
			getPositionProvisoire().setColonne(getPosition().getColonne()+1);
		}
		else if(getDirection()==Direction.est) {
			getPositionProvisoire().setColonne(getPosition().getColonne()-1);
		}
	}
	public void tournerD() {
		if(getDirection()==Direction.nord) {
			setDirection(Direction.est);
		}
		else if(getDirection()==Direction.sud) {
			setDirection(Direction.ouest);
		}
		else if(getDirection()==Direction.ouest) {
			setDirection(Direction.nord);
		}
		else if(getDirection()==Direction.est) {
			setDirection(Direction.sud);
		}
	}
	
	public void tournerG() {
		if(getDirection()==Direction.nord) {
			setDirection(Direction.ouest);
		}
		else if(getDirection()==Direction.sud) {
			setDirection(Direction.est);
		}
		else if(getDirection()==Direction.ouest) {
			setDirection(Direction.sud);
		}
		else if(getDirection()==Direction.est) {
			setDirection(Direction.nord);
		}
	}
		
	public void demiTour() {
		if(getDirection()==Direction.nord) {
			setDirection(Direction.sud);
		}
		else if(getDirection()==Direction.sud) {
			setDirection(Direction.nord);
		}
		else if(getDirection()==Direction.ouest) {
			setDirection(Direction.est);
		}
		else if(getDirection()==Direction.est) {
			setDirection(Direction.ouest);
		}
	}
	
	
	public  void robotAPousser(Position pos, CartesProgramme carte, ArrayList<Robot> listeRobots) {
		for (int i =0; i < listeRobots.size();i++) {
			if ( (i!= getNumeroRobot()) && (listeRobots.get(i).position.equals(pos) )) {
				 listeRobots.get(i);
				 pousserAutreRobot(listeRobots.get(i), carte, listeRobots);
			}
		}
	}
	
	public void pousserAutreRobot(Robot robot, CartesProgramme carte, ArrayList<Robot> listeRobot) {
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
	
	public boolean possibleDavancer (ArrayList<Robot> listeRobot, CartesProgramme carte){
		if (tab.chercherCase(getPosition()).getTypeCase() == TypeCase.caseMur) {
			System.out.println("mur");
			CaseMur caseMur = (CaseMur)tab.chercherCase(getPosition());
			if ( caseMur.getDirection() == directionOpposee() ) {
				System.out.println("direction");
				return false; // y'a un mur
			}
		}
		else if(tab.chercherCase(getPositionProvisoire()).getTypeCase() == TypeCase.caseTrou) {
			getPosition().setColonne(getDernierPosition().getColonne());
			getPosition().setLigne(getDernierPosition().getLigne());
			perdreUneVie();
			return false;
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
		robotAPousser(getPositionProvisoire(), carte, listeRobot);
		return true;
	}
		
	public int iteAvancer (CartesProgramme carte) {
		if (carte.getAction()==ActionCarte.avancer1) {
			return 1;
		}
		else if (carte.getAction()==ActionCarte.avancer2) {
			return 2;
		}
		else if (carte.getAction()==ActionCarte.avancer3) {
			return 3;
		}
		return 0;
	}
	

	public Direction directionOpposee () {
		if ( getDirection() == Direction.sud ) {
			return Direction.nord;
			}
		else if ( getDirection() == Direction.nord ) {
			return Direction.sud;
			}
		else if ( getDirection() == Direction.est ) {
			return Direction.ouest;
			}
		else if ( getDirection() == Direction.ouest ) {
			return Direction.est;
			}
		return getDirection();
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
				getPositionProvisoire().setColonne(getPosition().getColonne());
				getPositionProvisoire().setLigne(getPosition().getLigne());
			}
		}
		else if (natureDeplacement(carte) == 0) {
			for (int i =0; i< iteAvancer(carte);i++) {
				avancer();
				if (possibleDavancer(listeRobot, carte)) {
					getPositionProvisoire().setColonne(getPosition().getColonne());
					getPositionProvisoire().setLigne(getPosition().getLigne());
				}
			}
		}
	}
	public void laserTableau(Position position,ArrayList<Robot> listeRobots) {
		boolean fin = false;
		int i = position.getColonne();
		while (!fin && i<=11) {
			Position pos = new Position(i, position.getLigne());
			fin = robotTouche(pos, listeRobots);
			i++;
		}
	
}}
