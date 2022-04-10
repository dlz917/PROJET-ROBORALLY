package Controller.Client;

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
import Model.Cartes.ActionCarte;
import Model.Cartes.CartesProgramme;
import Model.Cartes.DistributionCartes;
import Model.Partie.Partie;
import Model.Robot.Robot;

public class ClientProgram extends Thread {
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
	private Scanner inputReader = new Scanner(System.in);

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
	
	public Scanner getInputReader() {
		return inputReader;
	}

	public void setInputReader(Scanner inputReader) {
		this.inputReader = inputReader;
	}
	/*-------------------------------------------FONCTION------------------------------------------*/
	public void sendPseudo(){
		try {
		this.setEtatClient(Etat.enAttente);
		System.out.println("Entrez votre pseudo:");
		String pseudo = getInputReader().next();
		setPseudo(pseudo);
		os.writeObject(pseudo);
		os.flush();
		} catch (IOException e) {
		e.printStackTrace();}
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
			this.setEtatClient(Etat.aJour);
			
			}catch(Exception exp) {System.out.println(exp);}
		}
	
	public void sendCartesChoisies() {
        try {
        	this.setEtatClient(Etat.enAttente);
        	
        	System.out.println("--------------------------------\nAu tour de : "+ getPseudo()+"\n");
			int nbrCartesDistrib = 9 - getP().getListeRobot().get(getNumJoueur()).getNbrPionDegat();
	    	System.out.println(getP().getDistributionCarte().get(getNumJoueur()));
	    	if (getP().getListeRobot().get(getNumJoueur()).getNbrPionDegat()<5) {
	    		System.out.println("Vous avez "+getP().getListeRobot().get(getNumJoueur()).getNbrPionDegat()+" pions dégât : "+ nbrCartesDistrib+ " cartes vous sont distribuées, vous pouvez choisir 5 cartes dans l'ordre d'exécution souhaité.\nEntrez les vitesses des cartes choisies:");
	        	ArrayList<Integer> vitessesChoisies = saisieVitesses(getP().getDistributionCarte().get(getNumJoueur()), 5);
	        	System.out.println("Vous avez choisi les vitesses suivantes: "+(vitessesChoisies)+"\n");
	        	os.writeObject(vitessesChoisies);
	    	}
	    	else {
	    		System.out.println("Vous avez "+getP().getListeRobot().get(getNumJoueur()).getNbrPionDegat()+" pions dégât : vous avez seulement la possibilité de choisir l'ordre d'éxécution des "+ nbrCartesDistrib+" cartes distribuées.\nEntrez les vitesses des cartes choisies:" );
	        	ArrayList<Integer> vitessesChoisies = saisieVitesses(getP().getDistributionCarte().get(getNumJoueur()), nbrCartesDistrib);
	        	System.out.println("  Vous avez choisi les vitesses suivantes: "+(vitessesChoisies)+"\n");
	        	os.writeObject(vitessesChoisies);
	    	}
        	ObjectOutputStream os = new ObjectOutputStream(output);
			os.flush();
			//inputReader.close();
			// A FERMER A LA DERNIERE FONCTION
        } catch(Exception exp) {
        	System.out.println(exp);
        }
	}
	
	public ArrayList<Integer> saisieVitesses (DistributionCartes distribution, int nbrChoix){
		ArrayList<Integer> vitessesCartesChoisies = new ArrayList<Integer>();
		int i =0;
		while (i<nbrChoix) {
        	System.out.println (">");
        	Integer choix;
			choix = (Integer) getInputReader().nextInt();
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
	
	public static void main (String[] args) {
		try {
			ClientProgram client = new ClientProgram();
			client.sendPseudo();
			// recevoir timer d'une minute
			client.receiveNumJoueur();
			client.receivePartie();
			client.setRobot(client.getP().getListeRobot().get(client.getNumJoueur()));
			
			while (!client.getP().isFinPartie()) {
				client.sendCartesChoisies();
				client.sleep(1200000); // temps de faire une manche
				// recevoir timer d'une minute
				client.receivePartie();
				System.out.println(client.getP().getListeRobot().get(client.getNumJoueur()).getPosition());
			}
			client.getInputReader().close();
			
		}catch(Exception exp) {}
	}}