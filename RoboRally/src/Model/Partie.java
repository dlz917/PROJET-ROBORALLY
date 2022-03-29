package Model;


import java.util.ArrayList;

public class Partie {
/*-------------------------------------ATRIBUTS-----------------------------------------*/
	/* tous besoin ??? */
	
	private ActionCarte actionCarte;
	private CartesProgramme cartesProgrammes;
	private CaseLaser caseLaser;
	private CaseMur caseMur;
	private CaseRoulant caseRoulant;
	private CaseTableau caseTableau;
	private Direction direction;
	private DistributionCartes distributionCarte;
	private Etat etat;
	private Lignes ligne;
	private Position position;
	private Robot robot;
	private StockCartes stockCartes;
	private Tableau1 tab;
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
	
	public Partie(ActionCarte actionCarte, CartesProgramme cartesProgrammes, CaseLaser caseLaser, CaseMur caseMur,
			CaseRoulant caseRoulant, CaseTableau caseTableau, Direction direction, DistributionCartes distributionCarte,
			Etat etat, Lignes ligne, Position position, Robot robot, StockCartes stockCartes, Tableau tab,String pseudo) {
		setActionCarte(actionCarte);
		setCartesProgrammes(cartesProgrammes);
		setCaseLaser(caseLaser);
		setCaseMur(caseMur);
		setCaseRoulant(caseRoulant);
		setCaseTableau(caseTableau);
		setDirection(direction);
		setDistributionCarte(distributionCarte);
		setEtat(etat);
		setLigne(ligne);
		setPosition(position);
		setRobot(robot);
		setStockCartes(stockCartes);
		setTab(tab);
	
	}
	
	
/*-------------------------------------------GETTERS/ SETTERS------------------------------------------*/

	public ActionCarte getActionCarte() {
		return actionCarte;
	}

	public void setActionCarte(ActionCarte actionCarte) {
		if(actionCarte!=null)/*mettre liste des action?*/
			this.actionCarte = actionCarte;
		else
			System.err.println("[setActionCarte] error : "+actionCarte);
	}
	public CartesProgramme getCartesProgrammes() {
		return CartesProgrammes;
	}

	public void setCartesProgrammes(CartesProgramme cartesProgrammes) {
		if(cartesProgrammes!=null)
			CartesProgrammes = cartesProgrammes;
		else
			System.err.println("[setCartesProgrammes] error : "+ cartesProgrammes);
	}

	public CaseLaser getCaseLaser() {
		return caseLaser;
	}

	public void setCaseLaser(CaseLaser caseLaser) {
		if(caseLaser!=null)
			this.caseLaser = caseLaser;
		else
			System.err.println("[setCaseLaser] error : "+ caseLaser);
	}

	public CaseMur getCaseMur() {
		return caseMur;
	}

	public void setCaseMur(CaseMur caseMur) {
		if(caseMur!=null)
			this.caseMur = caseMur;
		else
			System.err.println("[setCaseMur] error : "+ caseMur);
	}

	public CaseRoulant getCaseRoulant() {
		return caseRoulant;
	}

	public void setCaseRoulant(CaseRoulant caseRoulant) {
		if(caseRoulant!=null)
			this.caseRoulant = caseRoulant;
		else
			System.err.println("[setCaseRoulant] error : "+ caseRoulant);
	}

	public CaseTableau getCaseTableau() {
		return caseTableau;
	}

	public void setCaseTableau(CaseTableau caseTableau) {
		if(caseTableau !=null)
			this.caseTableau = caseTableau;
		else
			System.err.println("[setCaseTableau] error : "+ caseTableau);
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		if(direction !=null)
			this.direction = direction;
		else 
			System.err.println("[setDirection] error : "+direction);
	}

	public DistributionCartes getDistributionCarte() {
		return distributionCarte;
	}

	public void setDistributionCarte(DistributionCartes distributionCarte) {
		if(distributionCarte !=null)
			this.distributionCarte = distributionCarte;
		else
			System.err.println("[setDistributionCarte] error : "+ distributionCarte);
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		if(etat != null)/* liste énumération ? */
			this.etat = etat;
		else
			System.err.println("[setEtat] error: "+ etat);
		}

	public Lignes getLigne() {
		return ligne;
	}

	public void setLigne(Lignes ligne) {
		if(ligne!=null)
			this.ligne = ligne;
		else
			System.err.println("[setLigne] error :"+ ligne);
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		if(position!=null)
			this.position = position;
		else
			System.err.println("[setPosition] error :"+ position);
	}

	public Robot getRobot() {
		return robot;
	}

	public void setRobot(Robot robot) {
		if(robot!=null)
			this.robot = robot;
		else
			System.err.println("[setRobot] error :"+robot);
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

	public Tableau getTab() {
		return tab;
	}

	public void setTab(Tableau tab) {
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
	// faire setter listeposinitiales
		
/*-------------------------------------------FONCTION------------------------------------------*/
		
	public String Pseudo(String pseudo) {
		
		return pseudo;
	}
	
	public void ajouterJoueur(String pseudo, int numJoueur) {
		getListeRobot().add(new Robot (getListePosInitiales().get(numJoueur), pseudo));
	}
	
	public String reglesDuJeu() {
		return "  ";
	}
	
	public String presentation(String pseudo) {
		return "Bonjour "+pseudo+" votre robot est le suivant :"+robot+\n
				 "les régles du jeux sont "+\n
				 "-             "+\n
				 "-              "+\n;
	}
	public void ajouterCartes(CartesProgramme carteProgrammes) {
		ListeCarteProg.add(carteProgrammes);
		
		
	}
	
	

}
