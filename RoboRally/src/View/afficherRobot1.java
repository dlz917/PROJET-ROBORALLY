package View;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

import Model.Partie.Partie;
import Model.Robot.Direction;

public class afficherRobot1 {
	
	private static Partie p;
	private static BufferedImage imageActuel;
	private static BufferedImage imageEst;
	private static BufferedImage imageNord;
	private static BufferedImage imageSud;
	private static BufferedImage imageOuest;
	
	
	public afficherRobot1(Partie partie){
		afficherRobot1.p=partie;
		InputStream streamest=getClass().getResourceAsStream("robot1est.png");
		try {
			imageEst=ImageIO.read(streamest);} 
		catch (IOException e) {
			e.printStackTrace();}
		
		InputStream streamouest=getClass().getResourceAsStream("robot1ouest.png");
		try {
			imageOuest=ImageIO.read(streamouest);} 
		catch (IOException e) {
			e.printStackTrace();}
		
		InputStream streamnord=getClass().getResourceAsStream("robot1.png");
		try {
			imageNord=ImageIO.read(streamnord);} 
		catch (IOException e) {
			e.printStackTrace();}
		
		InputStream streamsud=getClass().getResourceAsStream("robot1sud.png");
		try {
			imageSud=ImageIO.read(streamsud);} 
		catch (IOException e) {
			e.printStackTrace();}
		setImageActuel(imageSud);}
	
	public void updateRobot1(int tour){
		
		if (p.getListeDirectionsParTour().get(0).get(tour)==Direction.sud){
			setImageActuel(imageSud );}
		else if(p.getListeDirectionsParTour().get(0).get(tour)==Direction.nord){
			setImageActuel(imageNord);}
		else if (p.getListeDirectionsParTour().get(0).get(tour)==Direction.est){
			setImageActuel(imageEst );}
		else {
			setImageActuel(imageOuest);}
					}

	public void setImageActuel(BufferedImage imageActuel) {
		afficherRobot1.imageActuel = imageActuel;
	}
	public BufferedImage getImageActuel() {
		return imageActuel;
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
