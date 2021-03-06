package Model.Partie;
/* ---------------------------------------CLASS PARTIE :-----------------------------------------------
 * LES ATTRIBUTS DE LA CLASS PARTIE :
 * 
 *		- ArrayList<Robot> Collection 
 *		- ArrayList<DistributionCartes> distributionCarte 
 * 		- StockCartes stockCartes 
 *  	- Tableau1 tab 
 *   	- ArrayList<Robot> listeRobot
 *   	- ArrayList<Position> listePosInitiales
 *   	- ArrayList<Direction> listeDirInitiales;
 *      - boolean finPartie=false;
 *      - ArrayList<ArrayList<Position>>listePositionsParTour
 *      
 *  LES MÉTHODES DE LA CLASS :
 *  
 *      - pseudo(String pseudo) :
 *          > retourne pseudo du joueur 
 *          
 *      - ajouterJoueur(String pseudo, int numJoueur)
 *         	>ajoute dans la liste robot le pseudo et le numero joueur associé 
 *            directement à un robot (avec sa position et sa direction initiale)
 *            
 *      - reglesDuJeu():
 *          > retourne régle du jeux 
 *          
 *      - ajouterCartes(ArrayList<Integer> vitessesCartes, int numJoueur) :
 *          > remplit la liste choix Carte avec les carte choisi par les joueurs
 *          
 *      - manche()
 *          > fonction qui fait le deroulement d'une manche en appelant la fonction tour 5 fois
 *            puis les conséquance d'une fin de manche avec les fonctions :
 *               - caseRoulant
 *               - verifDrapeau , si drapeau = 3 fin partie 
 *             et enregistre les positions final des robots
 *             
 *      - tour (int i)
 *        	 > fonction pour chaque tour , elle fait deplacer joueur en fonction de l'odre
 *           et enregistre leur nouvelle position dans listePosition qui est retourner. 
 *           
 *      - ajouterCartesAlea()
 *  
 *  	- ajouterAuStock()
 *  		>ajoute au stock les cartes sortie du stock 
 *      
 *      
 
 *  
 *  
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import Model.Cartes.CartesProgramme;
import Model.Cartes.DistributionCartes;
import Model.Cartes.StockCartes;
import Model.Robot.Direction;
import Model.Robot.Robot;
import Model.Tableau.CaseLaser;
import Model.Tableau.Lignes;
import Model.Tableau.Position;
import Model.Tableau.Tableau1;
import Model.Tableau.TypeCase;

public class Partie implements Serializable{
/*-------------------------------------ATTRIBUTS-----------------------------------------*/
	
	private static final ArrayList<Robot> Collection = null;
	private ArrayList<DistributionCartes> distributionCarte = new ArrayList<DistributionCartes>();
	private StockCartes stockCartes = new StockCartes();
	private Tableau1 tab = new Tableau1();
	private ArrayList<Robot> listeRobot=new ArrayList<Robot>();/* la meilleure liste */
	private ArrayList<Position> listePosInitiales = new ArrayList<Position> ();
	private ArrayList<Direction> listeDirInitiales = new ArrayList<Direction> ();
	private boolean finPartie=false;
	private ArrayList<ArrayList<Position>>listePositionsParTour=new ArrayList<ArrayList<Position>>();
	private ArrayList<ArrayList<Direction>> listeDirectionsParTour = new ArrayList<ArrayList<Direction>>();
	

/*----------------------------------CONSTRUCTEURS-----------------------------------*/
	
	public Partie() {
		Position pos1 = new Position(6,Lignes.F);
		listePosInitiales.add(pos1);
		listeDirInitiales.add(Direction.sud);
		Position pos2 = new Position(7,Lignes.G);
		listePosInitiales.add(pos2);
		listeDirInitiales.add(Direction.nord);
		Position pos3 = new Position(7,Lignes.F);
		listePosInitiales.add(pos3);
		listeDirInitiales.add(Direction.est);
		Position pos4 = new Position(6,Lignes.G);
		listePosInitiales.add(pos4);
		listeDirInitiales.add(Direction.ouest);
		stockCartes.remplirStock();
		for (int i = 0; i<4;i++) {
			getDistributionCarte().add(new DistributionCartes());
		}
	}
	
	
	
/*-------------------------------------------GETTERS/ SETTERS------------------------------------------*/
	public ArrayList<DistributionCartes> getDistributionCarte() {
		return distributionCarte;
	}

	public void setDistributionCarte(ArrayList<DistributionCartes> distributionCarte) {
		if(distributionCarte !=null)
			this.distributionCarte = distributionCarte;
		else
			System.err.println("[setDistributionCarte] error : "+ distributionCarte);
	}
	public StockCartes getStockCartes() {
		return stockCartes;
	}

	public void setStockCartes(StockCartes stockCartes) {
		if(stockCartes!=null)
			this.stockCartes = stockCartes;
		else
			System.err.println("[setStockCartes] error :"+ stockCartes);
	}

	public Tableau1 getTab() {
		return tab;
	}

	public void setTab(Tableau1 tab) {
		if(tab !=null)
			this.tab = tab;
		else
			System.err.println("[setTab] error :"+tab);
	}
	public ArrayList<Robot> getListeRobot() {
		return listeRobot;
	}
	public void setListeRobot(ArrayList<Robot> listeRobot) {
		this.listeRobot = listeRobot;
	}
	public boolean isFinPartie() {
		return finPartie;
	}
	public void setFinPartie(boolean finPartie) {
		this.finPartie = finPartie;
	}
	
	public ArrayList<Position> getListePosInitiales() {
		return listePosInitiales;
	}
	public void setListePosInitiales(ArrayList<Position>listePosInitiales) {
		this.listePosInitiales=listePosInitiales;
	}
	public ArrayList<ArrayList<Position>> getListePositionsParTour() {
		return listePositionsParTour;
	}
	public void setListePositionsParTour(ArrayList<ArrayList<Position>> listePositionsParTour) {
		this.listePositionsParTour = listePositionsParTour;
	}
	public ArrayList<Direction> getListeDirInitiales() {
		return listeDirInitiales;
	}
	public void setListeDirInitiales(ArrayList<Direction> listeDirInitiales) {
		this.listeDirInitiales = listeDirInitiales;
	}
	public ArrayList<ArrayList<Direction>> getListeDirectionsParTour() {
		return listeDirectionsParTour;
	}

	public void setListeDirectionsParTour(ArrayList<ArrayList<Direction>> listeDirectionsParTour) {
		this.listeDirectionsParTour = listeDirectionsParTour;
	}
		
/*-------------------------------------------FONCTION------------------------------------------*/
		
	public String Pseudo(String pseudo) {
		
		return pseudo;
	}
	
	public void ajouterJoueur(String pseudo, int numJoueur) {
		getListeRobot().add(new Robot (getListePosInitiales().get(numJoueur), pseudo, getTab(),numJoueur,getListeDirInitiales().get(numJoueur)));
	}
	
	public String reglesDuJeu() {
		return "r?gles du jeu";
	} 
	/*public String presentation(String pseudo) {
		return "Bonjour "+pseudo+" votre robot est le suivant :"+robot+\n
				 "les régles du jeux sont "+\n
				 "-             "+\n
				 "-              "+\n;
	}*/
	
	public void ajouterCartes(ArrayList<Integer> vitessesCartes, int numJoueur) {
		ArrayList<CartesProgramme> choixCartes = new ArrayList<CartesProgramme> ();
		for (int j = 0 ; j<vitessesCartes.size() ; j++ ) {
			for (int i = 0; i<getListeRobot().get(numJoueur).getCartesDistribuees().size() ; i++){
				if ( vitessesCartes.get(j) == getListeRobot().get(numJoueur).getCartesDistribuees().get(i).getVitesse() ) {
					choixCartes.add(getListeRobot().get(numJoueur).getCartesDistribuees().get(i));
				}
			}
		}
		getListeRobot().get(numJoueur).setListeCarteChoisi(choixCartes);
	}
	
	public void ajouterCartesAlea(int numJoueur){
		int nbrCartesDistrib = 9 - getListeRobot().get(numJoueur).getNbrPionDegat();
		getDistributionCarte().get(numJoueur).listeCartes(nbrCartesDistrib, getStockCartes().getStock(), numJoueur);
		getListeRobot().get(numJoueur).setCartesDistribuees(getDistributionCarte().get(numJoueur).getListeCartes());
		ArrayList<CartesProgramme> vitessesCartes = new ArrayList<CartesProgramme> ();
		for (int i = 0; i<5; i++) {
    		vitessesCartes.add(getListeRobot().get(numJoueur).getCartesDistribuees().get(i));
    	}
	}
	
	public void manche() {
		setListePositionsParTour(new ArrayList<ArrayList<Position>>());
		setListeDirectionsParTour(new ArrayList<ArrayList<Direction>>());
		for (int j =0;j<5;j++){
			getListePositionsParTour().add(tour(j));
		}
		for (int i =0; i<getListeRobot().size();i++) {
			getListeRobot().get(i).caseRoulant();
		}
		for (int i =0; i<getListeRobot().size();i++) {
			getListeRobot().get(i).lasers(getListeRobot());
		}
		Position laser1=new Position(4,Lignes.C);
		getListeRobot().get(0).laserTableau(laser1, listeRobot);
		Position laser2=new Position(9,Lignes.C);
		getListeRobot().get(0).laserTableau(laser2, listeRobot);
		Position laser3=new Position(4,Lignes.H);
		getListeRobot().get(0).laserTableau(laser3, listeRobot);
		Position laser4=new Position(9,Lignes.C);
		getListeRobot().get(0).laserTableau(laser4, listeRobot);
		
		for (int i =0; i<getListeRobot().size();i++) {
			getListeRobot().get(i).verifDrapeau();
		}
		for (int i =0; i<getListeRobot().size();i++) {
			if (getListeRobot().get(i).getNbrDeDrapeau()==3) {
				System.out.println("------------------------------"+ getListeRobot().get(i).getPseudo()+"a gagn?, fin du jeu------------------------------");
				setFinPartie(true);
			}
		}
		ajouterAuStock();
		System.out.println("------------------------------ Fin de la manche, position finale des robots : ------------------------------");
		for (int i =0; i<getListeRobot().size();i++) {
			System.out.println(getListeRobot().get(i));
			getListeRobot().get(i).getCartesDistribuees().clear();
		}
		for (int i =0; i<getListeRobot().size();i++) {
			if (getListeRobot().get(i).getNbrPionDegat()<5) {
				getListeRobot().get(i).getListeCarteChoisi().clear();
	    	}
	    	else {
	    		for (int j=getListeRobot().get(i).getNbrPionDegat(); j>0; j--) {
	    			getListeRobot().get(i).getListeCarteChoisi().remove(j-1);
	    		}
	    	}
		}
	}
	
	public ArrayList<Position> tour (int i){
		ArrayList<CartesProgramme> cartesTour = new ArrayList<CartesProgramme>();
		for (int j=0 ;j<getListeRobot().size();j++){
			cartesTour.add(getListeRobot().get(j).getListeCarteChoisi().get(i));
		}
		Collections.sort(cartesTour);
		Collections.reverse(cartesTour);
		System.out.println("------------------------------Tour "+(i+1)+" de la manche ------------------------------");
		for (int u=0; u<cartesTour.size();u++){
			getListeRobot().get(cartesTour.get(u).getRobotAttribue()).deplacer(getListeRobot(),cartesTour.get(u));
			System.out.println(cartesTour.get(u));
		}
		ArrayList<Position> listePositions = new ArrayList<Position> ();
		for (int v=0; v<getListeRobot().size(); v++){
			listePositions.add(getListeRobot().get(v).getPosition());
			System.out.println(getListeRobot().get(v));
		}
		ArrayList<Direction> listeDirections = new ArrayList<Direction> ();
		for (int w=0; w<getListeRobot().size(); w++){
			listeDirections.add(getListeRobot().get(w).getDirection());
		}
		getListeDirectionsParTour().add(listeDirections);
		return listePositions;
		
	}
	
	
	public void ajouterAuStock() {
		for (int i = 0; i<getListeRobot().size();i++) {
			getStockCartes().ajoutCarteStock(getListeRobot().get(i).getCartesDistribuees());
		}
	}}