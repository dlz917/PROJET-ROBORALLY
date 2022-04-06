package View;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class afficherCaseLaserSud {
	private static BufferedImage caseLaserSud;
	
	public afficherCaseLaserSud() {
		InputStream stream=getClass().getResourceAsStream("CaseLaserSud.png");
		try {
			afficherCaseLaserSud.caseLaserSud=ImageIO.read(stream);} 
		catch (IOException e) {
			e.printStackTrace();}}

	public static BufferedImage getCaseLaserSud() {
		return caseLaserSud;
	}

	public static void setCaseLaserSud(BufferedImage caseLaserSud) {
		afficherCaseLaserSud.caseLaserSud = caseLaserSud;
	}

	
}

