package Model.Tableau;

import java.io.Serializable;

import Model.Robot.Direction;

public final class Tableau1 implements Serializable{
	private static CaseTableau[][] tableau = new CaseTableau[12][12];
	
	
	// ------------------- Constructeur -------------------
	public Tableau1() { //ou private? (singleton)
		for (int c = 1; c <tableau.length+1; c++) {
			for (int l = 0; l <Lignes.ListLignes().length; l++) {
				CaseTableau caseT= new CaseTableau(new Position(c,Lignes.ListLignes()[l]));

				if(l==0){
					caseT=new CaseMur(new Position(c,Lignes.ListLignes()[l]),Direction.nord);}
				if(l==11){
					caseT=new CaseMur(new Position(c,Lignes.ListLignes()[l]),Direction.sud);}
				if(c==1){
					caseT=new CaseMur(new Position(c,Lignes.ListLignes()[l]),Direction.ouest);}
				if(c==12){
					caseT=new CaseMur(new Position(c,Lignes.ListLignes()[l]),Direction.est);}
				if(l==0&& c==1){
					caseT=new CaseTableau(new Position(c,Lignes.ListLignes()[l]),true);}
				if(l==11&& c==1){
					caseT=new CaseTableau(new Position(c,Lignes.ListLignes()[l]),true);}
				if(l==0&& c==12){
					caseT=new CaseTableau(new Position(c,Lignes.ListLignes()[l]),true);}
				if(l==11&& c==12){
					caseT=new CaseTableau(new Position(c,Lignes.ListLignes()[l]),true);}
				if(l==1 && c==6){
					caseT=new CaseTrou(new Position(c,Lignes.ListLignes()[l]));}
				if(l==1 && c==7){
					caseT=new CaseTrou(new Position(c,Lignes.ListLignes()[l]));}
				if(l==5 && c==2){
					caseT=new CaseTrou(new Position(c,Lignes.ListLignes()[l]));}
				if(l==6 && c==2){
					caseT=new CaseTrou(new Position(c,Lignes.ListLignes()[l]));}
				if(l==5 && c==11){
					caseT=new CaseTrou(new Position(c,Lignes.ListLignes()[l]));}
				if(l==6 && c==11){
					caseT=new CaseTrou(new Position(c,Lignes.ListLignes()[l]));}
				if(l==10 && c==6){
					caseT=new CaseTrou(new Position(c,Lignes.ListLignes()[l]));}
				if(l==10 && c==7){
					caseT=new CaseTrou(new Position(c,Lignes.ListLignes()[l]));}
				if((l>=2&&l<=9)&&(c==3)){
					caseT=new CaseRoulant(new Position(c,Lignes.ListLignes()[l]), Direction.nord);}
				if((l>=2&&l<=9)&&(c==10)){
					caseT=new CaseRoulant(new Position(c,Lignes.ListLignes()[l]), Direction.sud);}
				if((c>=3&&c<=10)&&(l==2)){
					caseT=new CaseRoulant(new Position(c,Lignes.ListLignes()[l]), Direction.est);}
				if((c>=3&&c<=10)&&(l==9)){
					caseT=new CaseRoulant(new Position(c,Lignes.ListLignes()[l]), Direction.ouest);}
				if(l==3&&c==4){
					caseT=new CaseLaser(new Position(c,Lignes.ListLignes()[l]), Direction.ouest);}
				if(l==3&&c==9){
					caseT=new CaseLaser(new Position(c,Lignes.ListLignes()[l]), Direction.nord);}
				if(l==8&&c==4){
					caseT=new CaseLaser(new Position(c,Lignes.ListLignes()[l]), Direction.sud);}
				if(l==8&&c==9){
					caseT=new CaseLaser(new Position(c,Lignes.ListLignes()[l]), Direction.est);}
				tableau[c-1][l]=caseT;}}}
				
	
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
		for (int j = 0; j < Tableau1.tableau.length; j++) {
			for (int i = 0; i <Tableau1.tableau.length; i++) {
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

