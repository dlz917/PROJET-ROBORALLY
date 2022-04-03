package Model;


import java.util.ArrayList;
import java.util.Collections;

import Model.Cartes.CartesProgramme;
import Model.Cartes.DistributionCartes;
import Model.Cartes.StockCartes;
import Model.Robot.Robot;
import Model.Tableau.Lignes;
import Model.Tableau.Position;
import Model.Tableau.Tableau1;

public class Partie {
/*-------------------------------------ATRIBUTS-----------------------------------------*/
	
	private static final ArrayList<Robot> Collection = null;
	private DistributionCartes distributionCarte = new DistributionCartes();
	private StockCartes stockCartes = new StockCartes();
	private Tableau1 tab = new Tableau1();
	private ArrayList<Robot> listeRobot=new ArrayList<Robot>();/* la meilleure liste */
	private ArrayList<Position> listePosInitiales = new ArrayList<Position> ();
	private boolean finPartie=false;
	private ArrayList<ArrayList<Position>>listePositionsParTour=new ArrayList<ArrayList<Position>>();
	

/*----------------------------------CONSTRUCTEURS-----------------------------------*/
	
	public Partie() {
		Position pos1 = new Position(5,Lignes.F);
		listePosInitiales.add(pos1);
		Position pos2 = new Position(6,Lignes.G);
		listePosInitiales.add(pos2);
		Position pos3 = new Position(6,Lignes.F);
		listePosInitiales.add(pos3);
		Position pos4 = new Position(5,Lignes.G);
		listePosInitiales.add(pos4);
	}
	
	
	
/*-------------------------------------------GETTERS/ SETTERS------------------------------------------*/
	public DistributionCartes getDistributionCarte() {
		return distributionCarte;
	}

	public void setDistributionCarte(DistributionCartes distributionCarte) {
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
		
/*-------------------------------------------FONCTION------------------------------------------*/
		
	public String Pseudo(String pseudo) {
		
		return pseudo;
	}
	
	public void ajouterJoueur(String pseudo, int numJoueur) {
		getListeRobot().add(new Robot (getListePosInitiales().get(numJoueur), pseudo, getTab()));
	}
	
	public String reglesDuJeu() {
		return "règles du jeu";
	} 
	/*public String presentation(String pseudo) {
		return "Bonjour "+pseudo+" votre robot est le suivant :"+robot+\n
				 "les régles du jeux sont "+\n
				 "-             "+\n
				 "-              "+\n;
	}*/
	
	public void ajouterCartes(ArrayList<Integer> vitessesCartes, int numJoueur) {
		ArrayList<CartesProgramme> choixCartes = new ArrayList<CartesProgramme> ();
		for (int j = 0 ; j<vitessesCartes.size() ; j++ ) {; 
			for (int i = 0; i<getListeRobot().get(numJoueur).getCartesDistribuees().size() ; i++){
				if ( vitessesCartes.get(j) == getListeRobot().get(numJoueur).getCartesDistribuees().get(i).getVitesse() ) {
					choixCartes.add(getListeRobot().get(numJoueur).getCartesDistribuees().get(i));
					getListeRobot().get(numJoueur).getCartesDistribuees().get(i).setRobotAttribue(numJoueur);
				}
			}
		}
		getListeRobot().get(numJoueur).setListeCarteChoisi(choixCartes);
	}
	public void manche() {
		setListePositionsParTour(new ArrayList<ArrayList<Position>>());
		for (int j =0;j<5;j++){
			getListePositionsParTour().add(tour(j));
		}
	}
	
	public ArrayList<Position> tour (int i){
		ArrayList<CartesProgramme> cartesTour = new ArrayList<CartesProgramme>();
		for (int j=0 ;j<getListeRobot().size();j++){
			cartesTour.add(getListeRobot().get(j).getListeCarteChoisi().get(i));
		}
		Collections.sort(cartesTour);
		for (int u=0; u<cartesTour.size();u++){
			getListeRobot().get(cartesTour.get(u).getRobotAttribue()).deplacer(cartesTour.get(u));
		}
		System.out.println("Tour "+i+" de la manche effectué");
		ArrayList<Position> listePositions = new ArrayList<Position> ();
		for (int v=0; v<getListeRobot().size(); v++){
			listePositions.add(getListeRobot().get(v).getPosition());
		}
		return listePositions;
		
	}
	
	public void ajouterCartesAlea(){
	}
	

	
	

}
