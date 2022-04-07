package View;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class afficherLaserBeam {

	private static BufferedImage laser;

	public afficherLaserBeam() {
		InputStream stream=getClass().getResourceAsStream("LaserBeam.png");
		try {
			afficherLaserBeam.laser=ImageIO.read(stream);} 
		catch (IOException e) {
			e.printStackTrace();}}

	public static BufferedImage getLaser() {
		return laser;
	}

	public static void setLaser(BufferedImage laser) {
		afficherLaserBeam.laser = laser;
	}

	}
