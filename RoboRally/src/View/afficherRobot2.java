package View;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Model.Robot.Direction;
import Model.Partie;

public class afficherRobot2 {
	
	private static Partie p;
	private static BufferedImage imageActuel;
	private static BufferedImage imageEst;
	private static BufferedImage imageNord;
	private static BufferedImage imageSud;
	private static BufferedImage imageOuest;
	
	
	public afficherRobot2(Partie partie){
		afficherRobot2.p=partie;
		InputStream streamest=getClass().getResourceAsStream("robot2est.png");
		try {
			imageEst=ImageIO.read(streamest);} 
		catch (IOException e) {
			e.printStackTrace();}
		
		InputStream streamouest=getClass().getResourceAsStream("robot2ouest.png");
		try {
			imageOuest=ImageIO.read(streamouest);} 
		catch (IOException e) {
			e.printStackTrace();}
		
		InputStream streamnord=getClass().getResourceAsStream("robot2.png");
		try {
			imageNord=ImageIO.read(streamnord);} 
		catch (IOException e) {
			e.printStackTrace();}
		
		InputStream streamsud=getClass().getResourceAsStream("robot2sud.png");
		try {
			imageSud=ImageIO.read(streamsud);} 
		catch (IOException e) {
			e.printStackTrace();}
			setImageActuel(imageSud);}
			
	public void updateRobot2(int tour){
		if (p.getListeDirectionsParTour().get(1).get(tour)==Direction.sud){
			setImageActuel(imageSud );}
		else if(p.getListeDirectionsParTour().get(1).get(tour)==Direction.nord){
			setImageActuel(imageNord);}
		else if (p.getListeDirectionsParTour().get(1).get(tour)==Direction.est){
			setImageActuel(imageEst );}
		else {
			setImageActuel(imageOuest);}
	}

	public BufferedImage getImageActuel() {
		return imageActuel;
	}
	public void setImageActuel(BufferedImage imageActuel) {
		afficherRobot2.imageActuel = imageActuel;
	}
	public static BufferedImage getImageEst() {
		return imageEst;
	}
	public static BufferedImage getImageNord() {
		return imageNord;
	}
	public static BufferedImage getImageSud() {
		return imageSud;
	}
	public static BufferedImage getImageOuest() {
		return imageOuest;
	}

}
