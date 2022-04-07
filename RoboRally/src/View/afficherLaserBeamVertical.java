package View;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
public class afficherLaserBeamVertical {

	private static BufferedImage laserVertical;

	public afficherLaserBeamVertical() {
		InputStream stream=getClass().getResourceAsStream("LaserBeamVertical.png");
		try {
			afficherLaserBeamVertical.laserVertical=ImageIO.read(stream);} 
		catch (IOException e) {
			e.printStackTrace();}}

	public static BufferedImage getLaserVertical() {
		return laserVertical;
	}

}
