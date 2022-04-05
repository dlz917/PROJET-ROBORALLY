package View;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class afficherCaseAvancerGauche {
	private static BufferedImage caseAvancerGauche;
	
	public afficherCaseAvancerGauche() {
		InputStream stream=getClass().getResourceAsStream("CaseAvancerGauche.png");
		try {
			afficherCaseAvancerGauche.caseAvancerGauche=ImageIO.read(stream);} 
		catch (IOException e) {
			e.printStackTrace();}}

	public static BufferedImage getCaseAvancerGauche() {
		return caseAvancerGauche;
	}

	public static void setCaseAvancerGauche(BufferedImage caseAvancerGauche) {
		afficherCaseAvancerGauche.caseAvancerGauche = caseAvancerGauche;
	}}

