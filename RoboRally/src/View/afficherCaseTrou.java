package View;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JButton;

import Model.Tableau.CaseTableau;
import Model.Tableau.CaseTrou;

public class afficherCaseTrou {
	private final CaseTrou caseAfficher;
	private static BufferedImage caseTrou;

	public afficherCaseTrou(CaseTrou a) {
		this.caseAfficher=a;
		InputStream stream=getClass().getResourceAsStream("CaseTrou.png");

		try {
			afficherCaseTrou.caseTrou=ImageIO.read(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public CaseTableau getCaseAfficher() {
		return caseAfficher;
	}

	public static BufferedImage getCaseTrou() {
		return caseTrou;
	}

	public static void setCaseTrou(BufferedImage caseTrou) {
		afficherCaseTrou.caseTrou = caseTrou;
	}}
