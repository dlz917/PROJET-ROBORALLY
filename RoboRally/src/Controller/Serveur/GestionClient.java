package Controller.Serveur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Model.Partie.Partie;

public class GestionClient extends Client {
	private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Socket s;

	// ------------------- Constructeur -------------
	public GestionClient(Partie p, int numJoueur, Socket s, ObjectInputStream ois, ObjectOutputStream oos) throws IOException {
		super(p, numJoueur);
		this.s = s;
		this.ois = ois;
        this.oos = oos;
	}
// ------------- Getters / Setters ----------------
	public Socket getS() {
		return s;
	}
	
	public void setS(Socket s) {
		this.s=s;
	}
	
	// ----------------- Fonctions ---------------------
	public void receivePseudo() {
		try {
		String pseudo  = (String)ois.readObject();
		System.out.println(pseudo);
		getP().ajouterJoueur(pseudo,getNumJoueur());
		this.setEtatClient(Etat.aJour);
		}catch(Exception exp) {System.out.println(exp);}
	}
	
	public void sendPartie() {
		try {
			this.setEtatClient(Etat.enAttente);
			int nbrCartesDistrib = 9 - getP().getListeRobot().get(getNumJoueur()).getNbrPionDegat();
			getP().getDistributionCarte().get(getNumJoueur()).listeCartes(nbrCartesDistrib, getP().getStockCartes().getStock(), getNumJoueur());
			getP().getListeRobot().get(getNumJoueur()).setCartesDistribuees(getP().getDistributionCarte().get(getNumJoueur()).getListeCartes());
			oos.writeObject(getP());
			oos.flush();
		}catch(Exception exp) {System.out.println(exp);}
	}
	
	public void sendNumJoueur() {
		try {
			this.setEtatClient(Etat.enAttente);
			oos.writeObject(getNumJoueur());
			oos.flush();
		}catch(Exception exp) {System.out.println(exp);}
	}
	
	public void receiveCartesChoisies() { 
		try {
			ArrayList<Integer> vitessesCartes = new ArrayList<Integer>();
			vitessesCartes  = (ArrayList<Integer>)ois.readObject();
			System.out.println(vitessesCartes);
			getP().ajouterCartes(vitessesCartes, getNumJoueur());
			setEtatClient(Etat.aJour);
			}catch(Exception exp) {System.out.println(exp);}
		}
	
	
	public void run () {
		try {
			//envoyer timer d'une minute
			receivePseudo();
			sleep(30000);
			sendNumJoueur();
			sendPartie();
			
			while (!this.getP().isFinPartie()) {
				//envoyer timer d'une minute
				sleep(60000); 
				receiveCartesChoisies();
				//wait(); 
				sleep(100000);
				sendPartie();
				}
			setFinPartie(true);
			oos.close();
			s.close();			
			}catch(Exception exp) {System.out.println(exp);}
	}}