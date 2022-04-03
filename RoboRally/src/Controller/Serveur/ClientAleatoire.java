package controller.Serveur;

import java.io.IOException;

import Model.Partie;

public class ClientAleatoire extends Client{
	
// ------------------- Constructeur -------------
	public ClientAleatoire(Partie p, int numJoueur) throws IOException {
		super(p, numJoueur);
	}
// ------------- Getters / Setters ----------------	
	
// ----------------- Fonctions ---------------------
	public void choixCartes() {
		this.getP().ajouterCartesAlea();
		this.setEtatClient(Etat.aJour);;
	}
	
	public void run() {
		try {
			while (!isFinPartie()) {
				if ( this.getP().isFinPartie()  ) { // getP() synchronized ??
					setFinPartie(true);
				}
				else {
					choixCartes();
					wait();// attendre que SS fasse tour
				}
			}
			
			}catch(Exception exp) {System.out.println(exp);}
	}

}
