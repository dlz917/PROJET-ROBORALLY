package Model;

public class Partie {
	/* tous névessaire ??? */
	private ActionCarte actionCarte;
	private CartesProgramme CartesProgrammes;
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
	private Tableau tab;
	private String pseudo;
	
	public Partie() {}
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
		setPseudo(pseudo);
	}


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
	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		if(pseudo!=null)
			this.pseudo = pseudo;
		else
			System.err.println("[setPseudo] error : "+ pseudo);
	}

}
