package Controller.Serveur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import Model.Etat;
import Model.Partie;

public class SocketServer extends Thread{
	private ArrayList<Client> li = new ArrayList<Client>();
	private static Partie p = new Partie();
	private Etat etatServer = null;
	private static final int port = 1234;
	private ServerSocket serverSocket = null;

// ------------------- Constructeur -------------
	public SocketServer() {
		try {
			System.out.println("server started...");
		serverSocket = new ServerSocket (port);
		}catch(Exception exp) {}
	}
	
// ------------- Getters / Setters ----------------
	public ArrayList<Client> getLi() {
		return li;
	}

	public void setLi(ArrayList<Client> li) {
		this.li = li;
	}

	public Etat getEtatServer() {
		return etatServer;
	}

	public void setEtatServer(Etat etatServer) {
		this.etatServer = etatServer;
	}

	public static Partie getP() {
		return p;
	}

	public static void setP(Partie p) {
		SocketServer.p = p;
	}
	

// ----------------- Fonctions ---------------------
	public void verifConnexion() throws IOException {
		for (int i =0; i<getLi().size();i++) {
			if ( getLi().get(i).getEtatClient() == Etat.enAttente) {
				ClientAleatoire client = new ClientAleatoire(getP(),i);
				getLi().set(i, client);
			}
		}
		// + deconnecter le joueur ?? (si il a juste pas répondu)
	}


	public static void main(String[]args) {
		try {
		//InetAddress adresse = InetAddress.getLocalHost();
		//System.out.println(adresse.getHostAddress());
			
		
		SocketServer socketServer = new SocketServer();
		
// ----------- Connexions des clients, attribution des sockets ------------
		while(socketServer.getLi().size() < 4) {
			Socket s=null;
			try {
				s = socketServer.serverSocket.accept();
				System.out.println("Nouveau client connecté : " +(socketServer.getLi().size()+1));
				ObjectInputStream ois =new ObjectInputStream(s.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				
				GestionClient t = new GestionClient(p,socketServer.getLi().size(), s, ois, oos);
				socketServer.getLi().add(t);
	           
			}catch(Exception e) {
				e.printStackTrace();}
		}
		
// ----------- Lancement des threads des clients ------------
		for (int i =0; i<socketServer.getLi().size();i++) {
			socketServer.getLi().get(i).start(); // on lance les threads des clients
		}
		
// ----------- Joueur a une minute pour envoyer son pseudo, sinon il devient un client aléatoire ------------
		sleep(60000);
		socketServer.verifConnexion();

// ----------- Tant que la partie n'est pas finie ------------
		boolean fin =false;
		while (!fin) {
			
		// ----------- Joueur a une minute pour faire son choix de cartes à jouer sinon il devient un client aléatoire ------------
			sleep(60000);
			socketServer.verifConnexion();
			System.out.println("tous les choix sont faits");
			
		// ----------- Lancement d'un tour (les threads des client sont endormis) ------------
			getP().tour();
			
		// ----------- Réveil des threads client ------------
			for (int i =0; i<socketServer.getLi().size(); i++) {
				socketServer.getLi().get(i).notify(); // vrmt pas sure de moi
				
		// ----------- Verification que la partie est pas finie, si elle l'est on déconnecte le serveur ------------
				if ( socketServer.getLi().get(i).isFinPartie() );{
					socketServer.serverSocket.close();
					fin=true;
				}
			}
		}
		
		}catch(Exception exp) {System.out.println(exp);}
	}
	
}
