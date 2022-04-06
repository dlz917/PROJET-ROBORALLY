package View;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class afficherCoin2 {

	private static BufferedImage coin2;
	
	public afficherCoin2() {
		InputStream stream=getClass().getResourceAsStream("Coin2.png");
		try {
			afficherCoin2.coin2=ImageIO.read(stream);} 
		catch (IOException e) {
			e.printStackTrace();}}

	public static BufferedImage getCoin2() {
		return coin2;
	}

	public static void setCoin2(BufferedImage coin2) {
		afficherCoin2.coin2 = coin2;
	}

}
