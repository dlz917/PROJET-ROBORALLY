package View;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Controller.Serveur.Client;
import Model.Robot.Direction;
import Model.Robot.Robot;
import Model.Cartes.*;
import Model.Partie.Partie;
public class afficherCarte {
	private static BufferedImage carte1avant;
	private static BufferedImage carte2avant;
	private static BufferedImage carte3avant;
	private static BufferedImage derriere;
	private static BufferedImage tournerdroite;
	private static BufferedImage tournergauche;
	private static BufferedImage demitour;
	private BufferedImage imageactuel;
	private static Partie p;
	private Client client;
	;
	public afficherCarte(Partie p,Client c) {
		afficherCarte.p=p;
		client=c;
			InputStream stream1av=getClass().getResourceAsStream("1avant.png");
			try {
				carte1avant=ImageIO.read(stream1av);} 
			catch (IOException e) {
				e.printStackTrace();}
			
			InputStream stream2av=getClass().getResourceAsStream("2avant.png");
			try {
				carte2avant=ImageIO.read(stream2av);} 
			catch (IOException e) {
				e.printStackTrace();}
			
			InputStream stream3av=getClass().getResourceAsStream("3avant.png");
			try {
				carte3avant=ImageIO.read(stream3av);} 
			catch (IOException e) {
				e.printStackTrace();}
			
			InputStream streamderriere=getClass().getResourceAsStream("derriere.png");
			try {
				derriere=ImageIO.read(streamderriere);} 
			catch (IOException e) {
				e.printStackTrace();}

			InputStream streamdroite=getClass().getResourceAsStream("tournerdroite.png");
			try {
				tournerdroite=ImageIO.read(streamdroite);} 
			catch (IOException e) {
				e.printStackTrace();}

			InputStream streamgauche=getClass().getResourceAsStream("tournergauche.png");
			try {
				tournergauche=ImageIO.read(streamgauche);} 
			catch (IOException e) {
				e.printStackTrace();}
			
			if(p.getListeRobot().get(c.getNumJoueur()).getCartesDistribuees().get(0).getAction()==
					ActionCarte.avancer1){
				setImageactuel(carte1avant);}
			else if(p.getListeRobot().get(c.getNumJoueur()).getCartesDistribuees().get(0).getAction()==
					ActionCarte.avancer2){
				setImageactuel(carte2avant);}
			else if(p.getListeRobot().get(c.getNumJoueur()).getCartesDistribuees().get(0).getAction()==
					ActionCarte.avancer3){
				setImageactuel(carte3avant);}
			else if(p.getListeRobot().get(c.getNumJoueur()).getCartesDistribuees().get(0).getAction()==
					ActionCarte.reculer1){
				setImageactuel(derriere);}
			else if(p.getListeRobot().get(c.getNumJoueur()).getCartesDistribuees().get(0).getAction()==
					ActionCarte.tournerD){
				setImageactuel(tournerdroite);}
			else if(p.getListeRobot().get(c.getNumJoueur()).getCartesDistribuees().get(0).getAction()==
					ActionCarte.tournerG){
				setImageactuel(tournergauche);}
			else{
				setImageactuel(demitour);}}


		public void updateImageCarte(int carte){
			if(p.getListeRobot().get(client.getNumJoueur()).getCartesDistribuees().get(carte).getAction()==
					ActionCarte.avancer1){
				setImageactuel(carte1avant);}
			else if(p.getListeRobot().get(client.getNumJoueur()).getCartesDistribuees().get(carte).getAction()==
					ActionCarte.avancer2){
				setImageactuel(carte2avant);}
			else if(p.getListeRobot().get(client.getNumJoueur()).getCartesDistribuees().get(carte).getAction()==
					ActionCarte.avancer3){
				setImageactuel(carte3avant);}
			else if(p.getListeRobot().get(client.getNumJoueur()).getCartesDistribuees().get(carte).getAction()==
					ActionCarte.reculer1){
				setImageactuel(derriere);}
			else if(p.getListeRobot().get(client.getNumJoueur()).getCartesDistribuees().get(carte).getAction()==
					ActionCarte.tournerD){
				setImageactuel(tournerdroite);}
			else if(p.getListeRobot().get(client.getNumJoueur()).getCartesDistribuees().get(carte).getAction()==
					ActionCarte.tournerG){
				setImageactuel(tournergauche);}
			else{
				setImageactuel(demitour);}}

	public static BufferedImage getCarte1avant() {
		return carte1avant;
	}
	public static BufferedImage getCarte2avant() {
		return carte2avant;
	}
	public static BufferedImage getCarte3avant() {
		return carte3avant;
	}
	public static BufferedImage getDerriere() {
		return derriere;
	}
	public static BufferedImage getTournerdroite() {
		return tournerdroite;
	}
	public static BufferedImage getTournergauche() {
		return tournergauche;
	}
	public static BufferedImage getDemitour() {
		return demitour;
	}
	public BufferedImage getImageactuel() {
		return imageactuel;
	}
	public static Partie getP() {
		return p;
	}
	public Client getClient() {
		return client;
	}
	public static void setCarte1avant(BufferedImage carte1avant) {
		afficherCarte.carte1avant = carte1avant;
	}
	public static void setCarte2avant(BufferedImage carte2avant) {
		afficherCarte.carte2avant = carte2avant;
	}
	public static void setCarte3avant(BufferedImage carte3avant) {
		afficherCarte.carte3avant = carte3avant;
	}
	public static void setDerriere(BufferedImage derriere) {
		afficherCarte.derriere = derriere;
	}
	public static void setTournerdroite(BufferedImage tournerdroite) {
		afficherCarte.tournerdroite = tournerdroite;
	}
	public static void setTournergauche(BufferedImage tournergauche) {
		afficherCarte.tournergauche = tournergauche;
	}
	public static void setDemitour(BufferedImage demitour) {
		afficherCarte.demitour = demitour;
	}
	public void setImageactuel(BufferedImage imageactuel) {
		this.imageactuel = imageactuel;
	}
	public static void setP(Partie p) {
		afficherCarte.p = p;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	}


