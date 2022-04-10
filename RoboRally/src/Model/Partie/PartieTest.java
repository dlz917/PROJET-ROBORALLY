package Model.Partie;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Cartes.ActionCarte;
import Model.Cartes.CartesProgramme;
import Model.Cartes.DistributionCartes;
import View.MainWindow;

public class PartieTest {

	public ArrayList<Integer> saisieVitesses (DistributionCartes distribution, int nbrChoix){
		ArrayList<Integer> vitessesCartesChoisies = new ArrayList<Integer>();
		Scanner inputReader = new Scanner(System.in);
		int i =0;
		while (i<nbrChoix) {
        	System.out.println (">");
        	Integer choix;
			choix = (Integer) inputReader.nextInt();
			boolean ok=false;
			for (int j =0; j<distribution.getListeCartes().size();j++) {
				if (!(vitessesCartesChoisies.contains(choix)) && ( choix == distribution.getListeCartes().get(j).getVitesse() )) {
					vitessesCartesChoisies.add(choix);
					System.out.println("vitesse correcte");
					ok=true;
					i++;
				}
			}
			if (!ok){
				System.out.println("Vitesse incorrecte, saisissez une autre vitesse : ");
			}
		}
		return vitessesCartesChoisies;
	}
		
		public void choix (int i, Partie p) {
			System.out.println("--------------------------------\nAu tour de : "+ p.getListeRobot().get(i).getPseudo()+"\n");
			int nbrCartesDistrib = 9 - p.getListeRobot().get(i).getNbrPionDegat();
	    	p.getDistributionCarte().get(i).listeCartes(nbrCartesDistrib, p.getStockCartes().getStock(), i);
	    	p.getListeRobot().get(i).setCartesDistribuees(p.getDistributionCarte().get(i).getListeCartes());
	    	System.out.println(p.getDistributionCarte().get(i));
	    	if (p.getListeRobot().get(i).getNbrPionDegat()<5) {
	    		System.out.println("Vous avez "+p.getListeRobot().get(i).getNbrPionDegat()+" pions d�g�t : "+ nbrCartesDistrib+ " cartes vous sont distribu�es, vous pouvez choisir 5 cartes dans l'ordre d'ex�cution souhait�.\nEntrez les vitesses des cartes choisies:");
	        	ArrayList<Integer> vitessesChoisies = saisieVitesses(p.getDistributionCarte().get(i), 5);
	        	System.out.println("Vous avez choisi les vitesses suivantes: "+(vitessesChoisies)+"\n");
	        	p.ajouterCartes(vitessesChoisies, i);
	    	}
	    	else {
	    		System.out.println("Vous avez "+p.getListeRobot().get(i).getNbrPionDegat()+" pions d�g�t : vous avez seulement la possibilit� de choisir l'ordre d'�x�cution des "+ nbrCartesDistrib+" cartes distribu�es.\nEntrez les vitesses des cartes choisies:" );
	        	ArrayList<Integer> vitessesChoisies = saisieVitesses(p.getDistributionCarte().get(i), nbrCartesDistrib);
	        	System.out.println("  Vous avez choisi les vitesses suivantes: "+(vitessesChoisies)+"\n");
	        	
	        	
	        	p.ajouterCartes(vitessesChoisies, i);
	    	}
		}

	public static void main(String[] args) {
		Partie p = new Partie();
		PartieTest test = new PartieTest();
		//J0
		String pseudo1="a";
		p.ajouterJoueur(pseudo1, 0);
		
		// J1
		String pseudo2="b";
		p.ajouterJoueur(pseudo2, 1);
		
		// J2
		String pseudo3="c";
		p.ajouterJoueur(pseudo3, 2);
		// J3
		String pseudo4="d";
		p.ajouterJoueur(pseudo4, 3);
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					MainWindow window=new MainWindow(p);
					window.getFrame().setVisible(true);
					}
				catch(Exception e){
					e.printStackTrace();
					}
				}
			});

		//
		
		while (!p.isFinPartie()) {
			System.out.println("------------------------------ D�but d'une nouvelle manche : ------------------------------");
			for (int i =0; i<4;i++) {
				test.choix(i, p);
				//updateAll();
			}
			p.manche();
		}

	}}