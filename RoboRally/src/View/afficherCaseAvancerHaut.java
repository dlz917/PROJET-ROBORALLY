package View;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class afficherCaseAvancerHaut {

	private static BufferedImage caseAvancerHaut;

	public afficherCaseAvancerHaut() {
		InputStream stream=getClass().getResourceAsStream("CaseAvancerHaut.png");
		try {
			afficherCaseAvancerHaut.caseAvancerHaut=ImageIO.read(stream);} 
		catch (IOException e) {
			e.printStackTrace();}}

	public static BufferedImage getCaseAvancerHaut() {
		return caseAvancerHaut;
	}

	public static void setCaseAvancerBas(BufferedImage caseAvancerHaut) {
		afficherCaseAvancerHaut.caseAvancerHaut = caseAvancerHaut;
	}}

