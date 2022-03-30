package Model;


import java.util.ArrayList;

public class Partie {
/*-------------------------------------ATRIBUTS-----------------------------------------*/
	
	private DistributionCartes distributionCarte = new DistributionCartes();
	private StockCartes stockCartes = new StockCartes();
	private Tableau1 tab = new Tableau1();
	private ArrayList<Robot> listeRobot=new ArrayList<Robot>();/* la meilleure liste */
	private ArrayList<Position> listePosInitiales = new ArrayList<Position> ();
	private boolean finPartie=false;
	

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
		
/*-------------------------------------------FONCTION------------------------------------------*/
		
	public String Pseudo(String pseudo) {
		
		return pseudo;
	}
	
	public void ajouterJoueur(String pseudo, int numJoueur) {
		getListeRobot().add(new Robot (getListePosInitiales().get(numJoueur), pseudo, getTab()));
	}
	
	public String reglesDuJeu() {
		return " ";
	} 
		
	

	
	/*public String presentation(String pseudo) {
		return "Bonjour "+pseudo+" votre robot est le suivant :"+robot+\n
				 "les régles du jeux sont "+\n
				 "-             "+\n
				 "-              "+\n;
	}*/
	
	public void ajouterCartes([]int vitessesCartes, int numJoueur) {
		ArrayList<CartesProgramme> choixCartes = new ArrayList<CartesProgramme> ();
		for (int j = 0 ; j<vitessesCartes.length ; j++ ) {; 
			for (int i = 0; i<getListeRobot().get(numJoueur).getCartesDistribuees().size() ; i++){
				if ( vitessesCartes[j] == getListeRobot().get(numJoueur).getCartesDistribuees().get(i) ) {
					choixCartes.add(getListeRobot().get(numJoueur).getCartesDistribuees().get(i));
				}
			}
		}
		getListeRobot().get(numJoueur).setListeCarteChoisi(choixCartes);
	}

	
	

}
