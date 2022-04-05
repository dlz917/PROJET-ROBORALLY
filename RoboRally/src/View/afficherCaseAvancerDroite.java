package View;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class afficherCaseAvancerDroite {
	private static BufferedImage caseAvancerDroite;
	
	public afficherCaseAvancerDroite() {
		InputStream stream=getClass().getResourceAsStream("CaseAvancerDroite.png");
				try {
					afficherCaseAvancerDroite.caseAvancerDroite=ImageIO.read(stream);} 
				catch (IOException e) {
					e.printStackTrace();}}

	public static BufferedImage getCaseAvancerDroite() {
		return caseAvancerDroite;
	}

	public static void setCaseAvancerDroite(BufferedImage caseAvancerDroite) {
		afficherCaseAvancerDroite.caseAvancerDroite = caseAvancerDroite;
	}}
	


	