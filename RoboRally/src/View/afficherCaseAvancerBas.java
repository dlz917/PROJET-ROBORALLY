package View;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Model.Tableau.Position;

public class afficherCaseAvancerBas {
	private static BufferedImage caseAvancerBas;
	
	public afficherCaseAvancerBas() {
		InputStream stream=getClass().getResourceAsStream("CaseAvancerBas.png");
				try {
					afficherCaseAvancerBas.caseAvancerBas=ImageIO.read(stream);} 
				catch (IOException e) {
					e.printStackTrace();}}

	public static BufferedImage getCaseAvancerBas() {
		return caseAvancerBas;
	}

	public static void setCaseAvancerBas(BufferedImage caseAvancerBas) {
		afficherCaseAvancerBas.caseAvancerBas = caseAvancerBas;
	}}
	


	