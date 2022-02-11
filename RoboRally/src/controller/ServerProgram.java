package com.step1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class ServerProgram {
	private static final int port = 3333;
	private ServerSocket serverSocket = null;
	private Socket socketEnd1;
	private InputStream  input = null;
	private OutputStream output = null;
	
	public ServerProgram() {
		try {
			System.out.println("server started...");
		serverSocket = new ServerSocket (port);
		}catch(Exception exp) {}
	}
	
public void accepterConnexion() {
	try {
	System.out.println("attente de demande...");
	socketEnd1=serverSocket.accept();
	System.out.println("Connexion établie...");
	input = socketEnd1.getInputStream();
	output = socketEnd1.getOutputStream();
	}catch(Exception exp) {}
}

public void sendInfosJoueur() {
	try {
	int num = input.read();
	System.out.println("numéro robot : "+num);
	}catch(Exception exp) {}
}

public static void main(String[]args) {
	ServerProgram server = new ServerProgram();
	server.accepterConnexion();
	server.sendInfosJoueur();
}
}
