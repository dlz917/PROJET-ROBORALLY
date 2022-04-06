package View;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class afficherCoin4 {

	private static BufferedImage coin4;
	
	public afficherCoin4() {
		InputStream stream=getClass().getResourceAsStream("Coin4.png");
		try {
			afficherCoin4.coin4=ImageIO.read(stream);} 
		catch (IOException e) {
			e.printStackTrace();}}

	public static BufferedImage getCoin4() {
		return coin4;
	}

	public static void setCoin4(BufferedImage coin4) {
		afficherCoin4.coin4 = coin4;
	}

}
