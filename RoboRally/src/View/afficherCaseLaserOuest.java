package View;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class afficherCaseLaserOuest {

	private static BufferedImage caseLaserOuest;

	public afficherCaseLaserOuest() {
		InputStream stream=getClass().getResourceAsStream("CaseLaserOest.png");
		try {
			afficherCaseLaserOuest.caseLaserOuest=ImageIO.read(stream);} 
		catch (IOException e) {
			e.printStackTrace();}}

	public static BufferedImage getCaseLaserOuest() {
		return caseLaserOuest;
	}

	public static void setCaseLaserOuest(BufferedImage caseLaserOuest) {
		afficherCaseLaserOuest.caseLaserOuest = caseLaserOuest;
	}

}