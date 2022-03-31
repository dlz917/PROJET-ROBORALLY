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

import Controller.Serveur.Etat;
import Model.Partie;
import Model.Cartes.ActionCarte;
import Model.Cartes.CartesProgramme;

public class ClientProgram {
	private static final int port = 1234;
	private Socket socketEnd2 = null;
	private InputStream  input = null;
	private OutputStream output = null;
	private Partie p = null;
	private Etat etatClient = null;
	
	public ClientProgram() {
		try {
		socketEnd2 = new Socket("127.0.0.1", port);
		input = socketEnd2.getInputStream();
		output = socketEnd2.getOutputStream();
		}catch(Exception exp) {System.out.println(exp);}
	}	
	
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
			System.out.println(p);
			}catch(Exception exp) {System.out.println(exp);}
		}
	public void sendCartesChoisies() {
        try {
        	ArrayList<CartesProgramme> cartesDistribuees = new ArrayList<CartesProgramme>();
        	for (int i=0; i<9; i++) {
        		CartesProgramme ajout =new CartesProgramme(i+1,ActionCarte.avancer1);
        		cartesDistribuees.add(ajout);
            }
        	System.out.println(cartesDistribuees + "\nEntrer les vitesses des cartes choisies:");
    		Scanner inputReader = new Scanner(System.in);
    		int vitessesCartesChoisies[] = new int[5];
        	for (int i=0; i<5; i++) {
        		vitessesCartesChoisies[i] = (int) inputReader.nextInt();
        	}
        	// juste à envoyer liste des entiers sélectionnés !!
        	System.out.println("Vous avez choisis les vitesses suivantes: "+Arrays.toString(vitessesCartesChoisies));
        	ArrayList<CartesProgramme> cartesChoisies = new ArrayList<CartesProgramme>();
            for (int i = 0; i<vitessesCartesChoisies.length;i++) {
            	for (int j = 0; j<cartesDistribuees.size();j++) {
            		if (cartesDistribuees.get(j).getVitesse() == vitessesCartesChoisies[i]) {
            			cartesChoisies.add(cartesDistribuees.get(j));
            		}
            	}
            }
            System.out.println("ici1");
			ObjectOutputStream os = new ObjectOutputStream(output);
			System.out.println("ici2");
			os.writeObject(cartesChoisies);
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
		client.sendCartesChoisies();
		//p.reglesDuJeu
	}catch(Exception exp) {}
}

}
