package Controller.Client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Timer;

import Controller.Serveur.Etat;
import Model.Partie;
import Model.Cartes.ActionCarte;
import Model.Cartes.CartesProgramme;
import Model.Robot.Robot;

public class ClientProgram {
	/*----------------------------------ATTRIBUTS-----------------------------------*/
	private static final int port = 1234;
	private Socket socketEnd2 = null;
	private InputStream  input = null;
	private OutputStream output = null;
	private Partie p = null;
	private Etat etatClient = null;
	private int numJoueur = 0;
	private Robot robot =new Robot();
	private String pseudo;
	private ObjectInputStream oi;
	private ObjectOutputStream os;

	
	/*----------------------------------CONSTRUCTEURS-----------------------------------*/
	public ClientProgram() {
		try {
		socketEnd2 = new Socket("127.0.0.1", port);
		output = socketEnd2.getOutputStream();
		os = new ObjectOutputStream(output);
		input = socketEnd2.getInputStream();
		oi = new ObjectInputStream(input);
		}catch(Exception exp) {System.out.println(exp);}
	}
	
	
/*-------------------------------------------GETTERS/ SETTERS------------------------------------------*/
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
	public int getNumJoueur() {
		return numJoueur;
	}
	public void setNumJoueur(int numJoueur) {
		this.numJoueur = numJoueur;
	}
	public Robot getRobot() {
		return robot;
	}
	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	/*-------------------------------------------FONCTION------------------------------------------*/
	public void sendPseudo(){
		try {
		this.setEtatClient(Etat.enAttente);
		Scanner inputReader = new Scanner(System.in);
		System.out.println("Entrer votre pseudo:");
		String pseudo = inputReader.next();
		setPseudo(pseudo);
		os.writeObject(pseudo);
		os.flush();
		} catch (IOException e) {
		e.printStackTrace();
		}
		}
	
	public void receivePartie() {
		try {
			Partie p=(Partie)oi.readObject();
			setP(p);
			this.setEtatClient(Etat.aJour);
			}catch(Exception exp) {System.out.println(exp);}
		}
	
	public void receiveNumJoueur() {
		try {
			Integer numRecu =(Integer)oi.readObject();
			setNumJoueur(numRecu);
			setRobot(getP().getListeRobot().get(getNumJoueur()));
			this.setEtatClient(Etat.aJour);
			
			}catch(Exception exp) {System.out.println(exp);}
		}
	
	public void sendCartesChoisies() {
        try {
        	this.setEtatClient(Etat.enAttente);
        	int nbrCartesDistrib = 9 - getRobot().getNbrPionDegat();
        	getP().getDistributionCarte().get(numJoueur).listeCartes(nbrCartesDistrib, getP().getStockCartes().getStock(), getNumJoueur());
        	System.out.println(getP().getDistributionCarte().get(numJoueur));
        	
        	System.out.println ("\nEntrer les vitesses des cartes choisies:");
    		Scanner inputReader = new Scanner(System.in);
    		Integer vitessesCartesChoisies[] = new Integer[5];
        	for (int i=0; i<5; i++) {
        		vitessesCartesChoisies[i] = (Integer) inputReader.nextInt();
        	}
        	// juste � envoyer liste des entiers s�lectionn�s !!
        	System.out.println("Vous avez choisis les vitesses suivantes: "+Arrays.toString(vitessesCartesChoisies));
			ObjectOutputStream os = new ObjectOutputStream(output);
			os.writeObject(vitessesCartesChoisies);
			os.flush();
			//inputReader.close();
			// A FERMER A LA DERNIERE FONCTION
        } catch(Exception exp) {
        	System.out.println(exp);
        }
	}
	
	public void receiveTimer() {
		try {
			ObjectInputStream oi = new ObjectInputStream(input);
			Timer chrono = (Timer)oi.readObject();
			this.setEtatClient(Etat.aJour);
		} catch(Exception exp) {
        	System.out.println(exp);
		}
	}
	
public static void main (String[] args) {
	try {
		ClientProgram client = new ClientProgram();
		client.sendPseudo();
		client.receiveTimer();
		client.receivePartie();
		client.receiveNumJoueur();
		while (!client.getP().isFinPartie()) {
			client.sendCartesChoisies();
		client.receiveTimer();
		client.receivePartie();
		System.out.println("Coucou ICI");
		System.out.println(client.getP().getListePositionsParTour());
		System.out.println("Coucou ICI 2");
		}
		
	}catch(Exception exp) {}
}

}
