package View;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class afficherCoin1 {

	private static BufferedImage coin1;
	
	public afficherCoin1() {
		InputStream stream=getClass().getResourceAsStream("Coin1.png");
		try {
			afficherCoin1.coin1=ImageIO.read(stream);} 
		catch (IOException e) {
			e.printStackTrace();}}

	public static BufferedImage getCoin1() {
		return coin1;
	}

	public static void setCoin1(BufferedImage coin1) {
		afficherCoin1.coin1 = coin1;
	}

}



