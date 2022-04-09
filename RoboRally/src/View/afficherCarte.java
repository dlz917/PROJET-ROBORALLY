package View;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Controller.Serveur.Client;
import Model.Partie;
import Model.Robot.Robot;
import Model.Cartes.*;
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
	public afficherCarte(int j,Partie p,Client c) {
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
			if(p.getListeRobot().get(c.getNumJoueur()).getCartesDistribuees().get(j).getAction()==
					ActionCarte.avancer1){
				
			}
	}}


