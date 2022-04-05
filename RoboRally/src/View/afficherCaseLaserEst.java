package View;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class afficherCaseLaserEst {

	private static BufferedImage caseLaserEst;

	public afficherCaseLaserEst() {
		InputStream stream=getClass().getResourceAsStream("CaseLaserEst.png");
		try {
			afficherCaseLaserEst.caseLaserEst=ImageIO.read(stream);} 
		catch (IOException e) {
			e.printStackTrace();}}

	public static BufferedImage getCaseLaserEst() {
		return caseLaserEst;
	}

	public static void setCaseLaserEst(BufferedImage caseLaserEst) {
		afficherCaseLaserEst.caseLaserEst = caseLaserEst;
	}

}