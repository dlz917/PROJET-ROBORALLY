

package View;

import java.util.HashMap;

import Model.Tableau.Lignes;

public class associerLigne {
private HashMap<Lignes, Integer> assocLignes;

	public associerLigne() {
		 assocLignes = new HashMap<Lignes,Integer>();
		 assocLignes.put(Lignes.A,0);
		 assocLignes.put(Lignes.B,75);
		 assocLignes.put(Lignes.C,150);
		 assocLignes.put(Lignes.D,225);
		 assocLignes.put(Lignes.E,300);
		 assocLignes.put(Lignes.F,375);
		 assocLignes.put(Lignes.G,450);
		 assocLignes.put(Lignes.H,525);
		 assocLignes.put(Lignes.I,600);
		 assocLignes.put(Lignes.J,675);
		 assocLignes.put(Lignes.K,750);
		 assocLignes.put(Lignes.K,825);
	}

	public HashMap<Lignes, Integer> getAssocLignes() {
		return assocLignes;
	}

	public void setAssocLignes(HashMap<Lignes,Integer> assocLignes) {
		this.assocLignes = assocLignes;
	}

}
