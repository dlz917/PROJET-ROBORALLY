package Model;

public final class Tableau1 {
	protected static CaseTableau[][] tableau = new CaseTableau[12][12];
	
	
	// ------------------- Constructeur -------------------
	public Tableau1() { //ou private? (singleton)
		for (int i = 1; i <tableau.length+1; i++) {
			for (int j = 0; j <Lignes.ListLignes().length; j++) {
				CaseTableau caseT= new CaseTableau(new Position(i,Lignes.ListLignes()[j]));

				if(j==0){
					caseT=new CaseMur(new Position(i,Lignes.ListLignes()[j]),Direction.nord);}
				if(j==11){
					caseT=new CaseMur(new Position(i,Lignes.ListLignes()[j]),Direction.sud);}
				if(i==1){
					caseT=new CaseMur(new Position(i,Lignes.ListLignes()[j]),Direction.ouest);}
				if(i==12){
					caseT=new CaseMur(new Position(i,Lignes.ListLignes()[j]),Direction.est);}
				if(j==0&& i==1){
					caseT=new CaseTableau(new Position(i,Lignes.ListLignes()[j]),true);}
				if(j==11&& i==1){
					caseT=new CaseTableau(new Position(i,Lignes.ListLignes()[j]),true);}
				if(j==0&& i==12){
					caseT=new CaseTableau(new Position(i,Lignes.ListLignes()[j]),true);}
				if(j==11&& i==12){
					caseT=new CaseTableau(new Position(i,Lignes.ListLignes()[j]),true);}
				if(j==1 && i==6){
					caseT=new CaseTrou(new Position(i,Lignes.ListLignes()[j]));}
				if(j==1 && i==7){
					caseT=new CaseTrou(new Position(i,Lignes.ListLignes()[j]));}
				if(j==5 && i==2){
					caseT=new CaseTrou(new Position(i,Lignes.ListLignes()[j]));}
				if(j==6 && i==2){
					caseT=new CaseTrou(new Position(i,Lignes.ListLignes()[j]));}
				if(j==5 && i==11){
					caseT=new CaseTrou(new Position(i,Lignes.ListLignes()[j]));}
				if(j==6 && i==11){
					caseT=new CaseTrou(new Position(i,Lignes.ListLignes()[j]));}
				if(j==10 && i==6){
					caseT=new CaseTrou(new Position(i,Lignes.ListLignes()[j]));}
				if(j==10 && i==7){
					caseT=new CaseTrou(new Position(i,Lignes.ListLignes()[j]));}
				if((j>=2&&j<=9)&&(i==3)){
					caseT=new CaseRoulant(new Position(i,Lignes.ListLignes()[j]), Direction.nord);}
				if((j>=2&&j<=9)&&(i==10)){
					caseT=new CaseRoulant(new Position(i,Lignes.ListLignes()[j]), Direction.sud);}
				if((i>=3&&i<=10)&&(j==2)){
					caseT=new CaseRoulant(new Position(i,Lignes.ListLignes()[j]), Direction.est);}
				if((i>=3&&i<=10)&&(j==9)){
					caseT=new CaseRoulant(new Position(i,Lignes.ListLignes()[j]), Direction.ouest);}
				if(j==3&&i==4){
					caseT=new CaseLaser(new Position(i,Lignes.ListLignes()[j]));}
				if(j==3&&i==9){
					caseT=new CaseLaser(new Position(i,Lignes.ListLignes()[j]));}
				if(j==8&&i==4){
					caseT=new CaseLaser(new Position(i,Lignes.ListLignes()[j]));}
				if(j==8&&i==9){
					caseT=new CaseLaser(new Position(i,Lignes.ListLignes()[j]));}
				tableau[i-1][j]=caseT;}}}
				
	
	// ------------------- Getters-------------------

	public static CaseTableau[][] getTableau() {
		return tableau;
	}
	// ------------------- Fonctions-------------------
	public CaseTableau chercherCase(Position p){
		return Tableau1.tableau[p.getColonne()-1][p.getLigne().getIntValue()];}


	public static CaseTableau caseAdjacente(CaseTableau caseTableau,Direction direction){//jsp si le mettre ici ou en case tableau...
		CaseTableau r=caseTableau;
		if (direction==Direction.nord){
			if (caseTableau.getPosition().getLigne()!=Lignes.L)
				r=Tableau1.tableau[caseTableau.getPosition().getColonne()-1][caseTableau.getPosition().getLigne().getIntValue()+1];}
		
		if (direction==Direction.sud){
			if (caseTableau.getPosition().getLigne()!=Lignes.A)
				r=Tableau1.tableau[caseTableau.getPosition().getColonne()-1][caseTableau.getPosition().getLigne().getIntValue()-1];}
		
		if (direction==Direction.est){	
			if (caseTableau.getPosition().getColonne()!=12)
				r=Tableau1.tableau[caseTableau.getPosition().getColonne()][caseTableau.getPosition().getLigne().getIntValue()];}
				
		if (direction==Direction.ouest){
			if (caseTableau.getPosition().getColonne()!=1)
				r=Tableau1.tableau[caseTableau.getPosition().getColonne()-2][caseTableau.getPosition().getLigne().getIntValue()];}
		
	return r;}
	
	// ------------------- Test -------------------
	public static void main(String[] args) {
		Tableau1 a=new Tableau1();
		
		for (int i = 0; i <Tableau1.tableau.length; i++) {
			for (int j = 0; j < Tableau1.tableau.length; j++) {
				System.out.println(Tableau1.tableau[i][j]);
			}
			//System.out.println(a.getTableau()[0][0]);
			//System.out.println(a.getTableau()[0][0].CaseAdjacente(Direction.nord));
			//System.out.println(a.getTableau()[1][1].CaseAdjacente(Direction.sud));
			//System.out.println(a.getTableau()[0][0].CaseAdjacente(Direction.est));
			//System.out.println(a.getTableau()[1][1].CaseAdjacente(Direction.ouest));
			//Position abd = (a.getTableau()[1][1].CaseAdjacente(Direction.sud).getPosition());
			//System.out.println(a.chercherCase(abd));
	}}}
