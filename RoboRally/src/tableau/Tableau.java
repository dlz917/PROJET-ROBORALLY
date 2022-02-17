package tableau;

import tableau.cases.CaseTableau;

public class Tableau {
	private CaseTableau[][] tableau = new CaseTableau[12][12]; 
	
	// ------------------- Constructeur -------------------
	public Tableau() {{
		Lignes ListLignes[] = Lignes.values();
		for (int i = 0; i <tableau.length; ++i) {
			int colonne=0;
			for (int j = 0; j < ListLignes.length; j++) {
				CaseTableau caseT= new CaseTableau(new Position(i,ListLignes[j]));
				tableau[i][colonne]=caseT;
				colonne++;}}}}
	
	// ------------------- Test -------------------
	public static void main(String[] args) {
		Tableau a=new Tableau();
		System.out.println(a.tableau[0][0]);
		
		for (int i = 0; i <a.tableau.length; i++) {
			for (int j = 0; j < a.tableau.length-1; j++) {
				System.out.println(a.tableau[i][j]);
			}
	}}
}