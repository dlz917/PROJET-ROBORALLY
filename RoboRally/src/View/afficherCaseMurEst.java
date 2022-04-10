package View;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import Model.Robot.Direction;
import Model.Tableau.CaseMur;
import Model.Tableau.CaseTableau;

public class afficherCaseMurEst {
	private CaseTableau caseAfficher;
	private static BufferedImage caseMur;

	public afficherCaseMurEst(CaseMur a) {
		try {
			this.caseAfficher=a;
			if (a.getDirection().equals(Direction.est)){
				InputStream stream=getClass().getResourceAsStream("CaseMurEst.png");
				try {
					afficherCaseMurEst.caseMur=ImageIO.read(stream);} 
				catch (IOException e) {
					e.printStackTrace();}}
		} catch (Exception e) {
			this.caseAfficher=a;
			e.printStackTrace();
		}
		
	}
	public CaseTableau getCaseAfficher() {
		return caseAfficher;
	}

	public static BufferedImage getCaseMur() {
		return caseMur;
	}

	public static void setCaseMurEst(BufferedImage caseMur) {
		afficherCaseMurEst.caseMur = caseMur;
	}

}
