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
			oos.writeObject(this.getP());
			oos.flush();
			//oos.close();
		}catch(Exception exp) {System.out.println(exp);}
	}
	
	public void sendNumJoueur() {
		try {
			this.setEtatClient(Etat.enAttente);
			oos.writeObject(getNumJoueur());
			oos.flush();
			//oos.close();
		}catch(Exception exp) {System.out.println(exp);}
	}
	
	public void receiveCartesChoisies() {
		try {
			ArrayList<Integer> vitessesCartes = new ArrayList<Integer>();
			vitessesCartes  = (ArrayList<Integer>)ois.readObject();
			//System.out.println(cartes.get(0));
			this.getP().ajouterCartes(vitessesCartes, this.getNumJoueur());
			this.setEtatClient(Etat.aJour);
			}catch(Exception exp) {System.out.println(exp);}
		}
	
	public void sendTimer() {
		try {
			this.setEtatClient(Etat.enAttente);
			Timer chrono = new Timer();
			chrono.schedule(new CustomTimer(),1000,1000);
			oos.writeObject(chrono);
			oos.flush();
			//oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void run () {
		try {
			sendTimer();
			receivePseudo();
			sendPartie();
			sendNumJoueur();
			
			while (!this.getP().isFinPartie()) {
				if ( this.getP().isFinPartie()) {
					setFinPartie(true);
					s.close();
				}
				else {
					sendTimer();
					sleep(60000); //- le temps d'envoi du timer
					receiveCartesChoisies();
					wait(); 
					sendPartie();
				}
			}
			
			}catch(Exception exp) {System.out.println(exp);}
	}
}

// statut du thread : runnable / blocked / waiting
