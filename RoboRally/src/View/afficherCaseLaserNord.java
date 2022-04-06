package View;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class afficherCaseLaserNord {

	private static BufferedImage caseLaserNord;

	public afficherCaseLaserNord() {
		InputStream stream=getClass().getResourceAsStream("CaseLaserNord.png");
		try {
			afficherCaseLaserNord.caseLaserNord=ImageIO.read(stream);} 
		catch (IOException e) {
			e.printStackTrace();}}

	public static BufferedImage getCaseLaserNord() {
		return caseLaserNord;
	}

	public static void setCaseLaserNord(BufferedImage caseLaserNord) {
		afficherCaseLaserNord.caseLaserNord = caseLaserNord;
	}}


