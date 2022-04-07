package View;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class afficherCoin3 {

	private static BufferedImage coin3;
	
	public afficherCoin3() {
		InputStream stream=getClass().getResourceAsStream("Coin3.png");
		try {
			afficherCoin3.coin3=ImageIO.read(stream);} 
		catch (IOException e) {
			e.printStackTrace();}}

	public static BufferedImage getCoin3() {
		return coin3;
	}

	public static void setCoin3(BufferedImage coin3) {
		afficherCoin3.coin3 = coin3;
	}

}
