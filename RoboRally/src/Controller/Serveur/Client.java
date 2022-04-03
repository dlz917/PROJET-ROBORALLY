package controller.Serveur;

import java.io.IOException;

import Model.Partie;

public abstract class Client extends Thread {
    private Partie p;
    private boolean finPartie = false ;
    private int numJoueur;
    private Etat etatClient = Etat.enAttente;
	
 // ------------------- Constructeur -------------
 	public Client(Partie p, int numJoueur) throws IOException {
         this.p = p;
         this.numJoueur = numJoueur;
 	}
    
// ------------- Getters / Setters ----------------	
	public Partie getP() {
		return p;
	}
	
	public void setP(Partie p) {
		this.p = p;
	}
	
	public Etat getEtatClient() {
		return etatClient;
	}
	
	public void setEtatClient(Etat etatClient) {
		this.etatClient = etatClient;
	}

	public boolean isFinPartie() {
		return finPartie;
	}

	public void setFinPartie(boolean finPartie) {
		this.finPartie = finPartie;
	}

	public int getNumJoueur() {
		return numJoueur;
	}

	public void setNumJoueur(int numJoueur) {
		this.numJoueur = numJoueur;
	}
	
}
