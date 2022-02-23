package Model;

public class Tableau {
	private static CaseTableau[][] tableau = new CaseTableau[12][12];
	private int c; 
	
	// ------------------- Constructeur -------------------
	public Tableau() { //ou private? (singleton)
		for (int i = 1; i <tableau.length+1; i++) {
			for (int j = 0; j <Lignes.ListLignes().length; j++) {
				CaseTableau caseT= new CaseTableau(new Position(i,Lignes.ListLignes()[j]));
				tableau[i-1][j]=caseT;}}}
				
	
	// ------------------- Getters-------------------

	public CaseTableau[][] getTableau() {
		return tableau;
	}
	// ------------------- Fonctions-------------------
	public CaseTableau chercherCase(Position p){
		return Tableau.tableau[p.getColonne()][p.getLigne().getIntValue()];}


	public CaseTableau CaseAdjacente(CaseTableau caseTableau,Direction direction){//jsp si le mettre ici ou en case tableau...
		CaseTableau r=caseTableau;
		if (direction==Direction.nord){
			if (caseTableau.getPosition().getLigne()!=Lignes.L)
				r=Tableau.tableau[caseTableau.getPosition().getColonne()][caseTableau.getPosition().getLigne().getIntValue()+1];}
		
		if (direction==Direction.sud){
			if (caseTableau.getPosition().getLigne()!=Lignes.A)
				r=Tableau.tableau[caseTableau.getPosition().getColonne()][caseTableau.getPosition().getLigne().getIntValue()-1];}
		
		if (direction==Direction.est){	
			if (caseTableau.getPosition().getColonne()!=12)
				r=Tableau.tableau[caseTableau.getPosition().getColonne()+1][caseTableau.getPosition().getLigne().getIntValue()];}
				
		if (direction==Direction.ouest){
			if (caseTableau.getPosition().getColonne()!=1)
				r=Tableau.tableau[caseTableau.getPosition().getColonne()-1][caseTableau.getPosition().getLigne().getIntValue()];}
		
	return r;
	}
	

	
	
	// ------------------- Test -------------------
	public static void main(String[] args) {
		Tableau a=new Tableau();
		System.out.println(Tableau.tableau[0][0]);
		
		for (int i = 0; i <Tableau.tableau.length; i++) {
			for (int j = 0; j < Tableau.tableau.length; j++) {
				System.out.println(Tableau.tableau[i][j]);
			}
	}}}

