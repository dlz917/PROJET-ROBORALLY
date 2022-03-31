package View;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JButton;

import Model.CaseTableau;

public class afficherCaseNormal {
	private final CaseTableau caseAfficher;
	private static BufferedImage caseNormal;

	public afficherCaseNormal(CaseTableau a) {
		this.caseAfficher=a;
		InputStream stream=getClass().getResourceAsStream("CaseTableauBase.png");

		try {
			afficherCaseNormal.caseNormal=ImageIO.read(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public CaseTableau getCaseAfficher() {
		return caseAfficher;
	}

	public static BufferedImage getCaseNormal() {
		return caseNormal;
	}

	public static void setCaseNormal(BufferedImage caseNormal) {
		afficherCaseNormal.caseNormal = caseNormal;
	}

}
