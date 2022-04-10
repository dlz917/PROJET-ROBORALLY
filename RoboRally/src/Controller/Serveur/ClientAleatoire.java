package Controller.Serveur;

import java.io.IOException;

import Model.Partie.Partie;

public class ClientAleatoire extends Client{
	
// ------------------- Constructeur -------------
	public ClientAleatoire(Partie p, int numJoueur) throws IOException {
		super(p, numJoueur);
	}
// ------------- Getters / Setters ----------------	
	
// ----------------- Fonctions ---------------------
	public void choixCartes() {
		this.getP().ajouterCartesAlea(getNumJoueur());
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
