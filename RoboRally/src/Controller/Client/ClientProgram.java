package controller.Client;

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

import controller.Serveur.Etat;
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
	private int numJoueur;
	private Robot robot =new Robot();

	
	
	/*----------------------------------CONSTRUCTEURS-----------------------------------*/
	public ClientProgram() {
		try {
		socketEnd2 = new Socket("127.0.0.1", port);
		input = socketEnd2.getInputStream();
		output = socketEnd2.getOutputStream();
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

/*-------------------------------------------FONCTION------------------------------------------*/
	public void sendPseudo(){
		try {
		ObjectOutputStream os = new ObjectOutputStream(output);
		Scanner inputReader = new Scanner(System.in);
		System.out.println("Entrer votre pseudo:");
		String pseudo = inputReader.next();
		os.writeObject(pseudo);
		os.flush();
		} catch (IOException e) {
		e.printStackTrace();
		}
		}
	
	public void receivePartie() {
		try {
			ObjectInputStream oi = new ObjectInputStream(input);
			Partie p=(Partie)oi.readObject();
			setP(p);
			}catch(Exception exp) {System.out.println(exp);}
		}
	
	public void receiveNumJoueur() {
		try {
			ObjectInputStream oi = new ObjectInputStream(input);
			int numJoueur =(int)oi.readObject();
			setNumJoueur(numJoueur);
			setRobot(getP().getListeRobot().get(numJoueur));
			
			}catch(Exception exp) {System.out.println(exp);}
		}
	
	public void sendCartesChoisies() {
        try {
        	int nbrCartesDistrib = 9 - getRobot().getNbrPionDegat();
        	getP().getDistributionCarte().get(numJoueur).listeCartes(nbrCartesDistrib, getP().getStockCartes().getStock());
        	
        	System.out.println(getP().getDistributionCarte().get(numJoueur));
        	
        	System.out.println ("\nEntrer les vitesses des cartes choisies:");
    		Scanner inputReader = new Scanner(System.in);
    		int vitessesCartesChoisies[] = new int[5];
        	for (int i=0; i<5; i++) {
        		vitessesCartesChoisies[i] = (int) inputReader.nextInt();
        	}
        	// juste � envoyer liste des entiers s�lectionn�s !!
        	System.out.println("Vous avez choisis les vitesses suivantes: "+Arrays.toString(vitessesCartesChoisies));
            System.out.println("ici1");
			ObjectOutputStream os = new ObjectOutputStream(output);
			System.out.println("ici2");
			os.writeObject(vitessesCartesChoisies);
			System.out.println("ici3");
			os.flush();
			System.out.println("ici4");
			//inputReader.close();
			// A FERMER A LA DERNIERE FONCTION
        } catch(Exception exp) {
        	System.out.println(exp);
        }
	}
	
public static void main (String[] args) {
	try {
		
		ClientProgram client = new ClientProgram();
		client.sendPseudo();
		client.receivePartie();
		client.receiveNumJoueur();
		client.sendCartesChoisies();
		//p.reglesDuJeu
	}catch(Exception exp) {}
}

}
