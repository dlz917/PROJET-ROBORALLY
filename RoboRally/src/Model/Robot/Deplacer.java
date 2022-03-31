package Model.Robot;
/*interface??? */

import Model.Cartes.ActionCarte;
import Model.Cartes.CartesProgramme;
import Model.Tableau.Position;

public class Deplacer extends Position{
	/* laisser classe normal ou mettre en interface ??*/
	private CartesProgramme carte;
	
	public Deplacer(CartesProgramme carte) {
		super(colonne,ligne);
		setCarte(carte);
	}
	public CartesProgramme getCarte() {
		return carte;
	}

	public void setCarte(CartesProgramme carte) {
		this.carte = carte;
	}
	public void orientation() {
		
	}
		
	
	
	
	
	public void seDeplacer() {
		if(carte.getAction()==ActionCarte.avancer1) {
			ligne+1;
		}
			
		else if(carte.action==AnctionCrate.avancer2) 
		{
			 position=ligne +2;
		}else if(carte.action==AnctionCrate.avancer3) {
			position=ligne +3;
		}
		else if(carte.action==AnctionCrate.reculer1) {
			position=ligne-1;
		}else if(carte.action==AnctionCrate.tournerD) {
			/*position=colonne+1 ou direction.est*/}
		
		else if(carte.action==AnctionCrate.tournerG) {
			/* position= colonne+1 ou direction.ouest;
	
			 */}
		else if(carte.action==AnctionCrate.demitour) {
			/* position=ligne -1 et direction.sud;*/
		}
		
		
		 position;
		}

}
