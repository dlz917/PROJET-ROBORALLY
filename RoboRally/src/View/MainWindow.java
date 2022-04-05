package View;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JList;
import Model.Robot.Direction;
import Model.Tableau.*;

public class MainWindow {
	private JFrame frame;
	/**
	 * Lancer l'appli
	 */
	public static void main(String[]args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					MainWindow window=new MainWindow();
					window.frame.setVisible(true);}
				catch(Exception e){
					e.printStackTrace();
				}
			}});}
		

		public MainWindow() {
			initialize();
		}

		private void initialize(){
			frame=new JFrame();
			frame.setBounds(100, 100, 950, 700);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			afficherCaseNormal AffichageNormal=new afficherCaseNormal(new CaseTableau(null));
			BufferedImage imageCaseNormal=afficherCaseNormal.getCaseNormal();
			ImageIcon imageIconCaseNormal = new ImageIcon(imageCaseNormal.getScaledInstance(75, 75, Image.SCALE_DEFAULT));
			
			afficherCaseMurNord AffichageMurNord=new afficherCaseMurNord(new CaseMur(null, Direction.nord));
			BufferedImage imageCaseMurNord=afficherCaseMurNord.getCaseMur();
			ImageIcon imageIconMurNord = new ImageIcon(imageCaseMurNord.getScaledInstance(75, 75, Image.SCALE_DEFAULT));
			
			
			afficherCaseMurEst AffichageMurEst=new afficherCaseMurEst(new CaseMur(null, Direction.est));
			BufferedImage imageCaseMurEst=afficherCaseMurEst.getCaseMur();
			ImageIcon imageIconMurEst = new ImageIcon(imageCaseMurEst.getScaledInstance(75, 75, Image.SCALE_DEFAULT));
			

			afficherCaseMurOuest AffichageMurOuest=new afficherCaseMurOuest(new CaseMur(null, Direction.ouest));
			BufferedImage imageCaseMurOuest=afficherCaseMurOuest.getCaseMur();
			ImageIcon imageIconMurOuest = new ImageIcon(imageCaseMurOuest.getScaledInstance(75, 75, Image.SCALE_DEFAULT));
					
			afficherCaseMurSud AffichageMurSud=new afficherCaseMurSud(new CaseMur(null, Direction.sud));
			BufferedImage imageCaseMurSud=afficherCaseMurSud.getCaseMur();
			ImageIcon imageIconMurSud = new ImageIcon(imageCaseMurSud.getScaledInstance(75, 75, Image.SCALE_DEFAULT));
			
			afficherCaseTrou AffichageTrou=new afficherCaseTrou (new CaseTrou(null));
			BufferedImage imageCaseTrou=afficherCaseTrou.getCaseTrou();
			ImageIcon imageIconCaseTrou = new ImageIcon(imageCaseTrou.getScaledInstance(75, 75, Image.SCALE_DEFAULT));
			
			afficherCaseAvancerDroite AffichageAvancerDroite=new afficherCaseAvancerDroite();
			BufferedImage imageCaseAvancerDroite=afficherCaseAvancerDroite.getCaseAvancerDroite();
			ImageIcon imageIconAvancerDroite = new ImageIcon(imageCaseAvancerDroite.getScaledInstance(75, 75, Image.SCALE_DEFAULT));
			
			afficherCaseAvancerBas AffichageAvancerBas=new afficherCaseAvancerBas();
			BufferedImage imageCaseAvancerBas=afficherCaseAvancerDroite.getCaseAvancerDroite();
			ImageIcon imageIconAvancerBas = new ImageIcon(imageCaseAvancerBas.getScaledInstance(75, 75, Image.SCALE_DEFAULT));
			
			afficherCaseAvancerHaut AffichageAvancerHaut=new afficherCaseAvancerHaut();
			BufferedImage imageCaseAvancerHaut=afficherCaseAvancerHaut.getCaseAvancerHaut();
			ImageIcon imageIconAvancerHaut= new ImageIcon(imageCaseAvancerHaut.getScaledInstance(75, 75, Image.SCALE_DEFAULT));
			
			afficherCaseAvancerGauche AffichageAvancerGauche=new afficherCaseAvancerGauche();
			BufferedImage imageCaseAvancerGauche=afficherCaseAvancerGauche.getCaseAvancerGauche();
			ImageIcon imageIconAvancerGauche = new ImageIcon(imageCaseAvancerGauche.getScaledInstance(75, 75, Image.SCALE_DEFAULT));
			
			
			JLabel a2 = new JLabel("A2");
			a2.setBounds(75, 0, 75, 75);
			frame.getContentPane().add(a2);
			a2.setIcon(imageIconMurNord);
			
			JLabel a3 = new JLabel("A3");
			a3.setBounds(150, 0, 75, 75);
			frame.getContentPane().add(a3);
			a3.setIcon(imageIconMurNord);
			
			JLabel a4 = new JLabel("A4");
			a4.setBounds(225, 0, 75, 75);
			frame.getContentPane().add(a4);
			a4.setIcon(imageIconMurNord);
			
			JLabel a5 = new JLabel("A5");
			a5.setBounds(300, 0, 75, 75);
			frame.getContentPane().add(a5);
			a5.setIcon(imageIconMurNord);
			
			JLabel a6 = new JLabel("A6");
			a6.setBounds(375, 0, 75, 75);
			frame.getContentPane().add(a6);
			a6.setIcon(imageIconMurNord);
			
			JLabel a7 = new JLabel("A7");
			a7.setBounds(450, 0, 75, 75);
			frame.getContentPane().add(a7);
			a7.setIcon(imageIconMurNord);
			
			JLabel a8 = new JLabel("A8");
			a8.setBounds(525, 0, 75, 75);
			frame.getContentPane().add(a8);
			a8.setIcon(imageIconMurNord);
			
			JLabel a9 = new JLabel("A9");
			a9.setBounds(600, 0, 75, 75);
			frame.getContentPane().add(a9);
			a9.setIcon(imageIconMurNord);
			
			JLabel a10 = new JLabel("CA10");
			a10.setBounds(675, 0, 75, 75);
			frame.getContentPane().add(a10);
			a10.setIcon(imageIconMurNord);
			
			JLabel a11 = new JLabel("A11");
			a11.setBounds(750, 0, 75, 75);
			frame.getContentPane().add(a11);
			a11.setIcon(imageIconMurNord);
			
			JLabel b1 = new JLabel("B1");
			b1.setBounds(0, 75, 75, 75);
			frame.getContentPane().add(b1);
			b1.setIcon(imageIconMurOuest);
			
			JLabel b2 = new JLabel("B2");
			b2.setBounds(75, 75, 75, 75);
			frame.getContentPane().add(b2);
			b2.setIcon(imageIconCaseNormal);
			
			JLabel b3 = new JLabel("B3");
			b3.setBounds(150, 75, 75, 75);
			frame.getContentPane().add(b3);
			b3.setIcon(imageIconCaseNormal);
			
			JLabel b4 = new JLabel("B4");
			b4.setBounds(225, 75, 75, 75);
			frame.getContentPane().add(b4);
			b4.setIcon(imageIconCaseNormal);
			
			JLabel b5 = new JLabel("B5");
			b5.setBounds(300, 75, 75, 75);
			frame.getContentPane().add(b5);
			b5.setIcon(imageIconCaseNormal);
			
			JLabel b6 = new JLabel("B6");
			b6.setBounds(375, 75, 75, 75);
			frame.getContentPane().add(b6);
			b6.setIcon(imageIconCaseTrou);
			
			JLabel b7 = new JLabel("B7");
			b7.setBounds(450, 75, 75, 75);
			frame.getContentPane().add(b7);
			b7.setIcon(imageIconCaseTrou);
			
			JLabel b8 = new JLabel("B8");
			b8.setBounds(525, 75, 75, 75);
			frame.getContentPane().add(b8);
			b8.setIcon(imageIconCaseNormal);
			
			JLabel b9 = new JLabel("B9");
			b9.setBounds(600, 75, 75, 75);
			frame.getContentPane().add(b9);
			b9.setIcon(imageIconCaseNormal);
			
			JLabel b10 = new JLabel("B10");
			b10.setBounds(675, 75, 75, 75);
			frame.getContentPane().add(b10);
			b10.setIcon(imageIconCaseNormal);
			
			JLabel b11 = new JLabel("B11");
			b11.setBounds(750, 75, 75, 75);
			frame.getContentPane().add(b11);
			b11.setIcon(imageIconCaseNormal);
		
			JLabel b12 = new JLabel("B12");
			b12.setBounds(825, 75, 75, 75);
			frame.getContentPane().add(b12);
			b12.setIcon(imageIconMurEst);
			
			JLabel c1 = new JLabel("C1");
			c1.setBounds(0, 150, 75, 75);
			frame.getContentPane().add(c1);
			c1.setIcon(imageIconMurOuest);
			
			JLabel c2 = new JLabel("C2");
			c2.setBounds(75, 150, 75, 75);
			frame.getContentPane().add(c2);
			c2.setIcon(imageIconCaseNormal);
			
			JLabel c3 = new JLabel("C3");
			c3.setBounds(150, 150, 75, 75);
			frame.getContentPane().add(c3);
			c3.setIcon(imageIconAvancerDroite);
			
			JLabel c4 = new JLabel("C4");
			c4.setBounds(225, 150, 75, 75);
			frame.getContentPane().add(c4);
			c4.setIcon(imageIconAvancerDroite);
			
			JLabel c5 = new JLabel("C5");
			c5.setBounds(300, 150, 75, 75);
			frame.getContentPane().add(c5);
			c5.setIcon(imageIconAvancerDroite);
			
			JLabel c6 = new JLabel("C6");
			c6.setBounds(375, 150, 75, 75);
			frame.getContentPane().add(c6);
			c6.setIcon(imageIconAvancerDroite);
			
			JLabel c7 = new JLabel("C7");
			c7.setBounds(450, 150, 75, 75);
			frame.getContentPane().add(c7);
			c7.setIcon(imageIconAvancerDroite);
			
			JLabel c8 = new JLabel("C8");
			c8.setBounds(525, 150, 75, 75);
			frame.getContentPane().add(c8);
			c8.setIcon(imageIconAvancerDroite);
			
			JLabel c9= new JLabel("C9");
			c9.setBounds(600, 150, 75, 75);
			frame.getContentPane().add(c9);
			c9.setIcon(imageIconAvancerDroite);
			
			JLabel c10 = new JLabel("C10");
			c10.setBounds(675, 150, 75, 75);
			frame.getContentPane().add(c10);
			c10.setIcon(imageIconAvancerDroite);
			
			JLabel c11 = new JLabel("C11");
			c11.setBounds(750, 150, 75, 75);
			frame.getContentPane().add(c11);
			c11.setIcon(imageIconCaseNormal);
			
			JLabel c12 = new JLabel("C12");
			c12.setBounds(825, 150, 75, 75);
			frame.getContentPane().add(c12);
			c12.setIcon(imageIconMurEst);
			
			JLabel d1 = new JLabel("D1");
			d1.setBounds(0, 225, 75, 75);
			frame.getContentPane().add(d1);
			d1.setIcon(imageIconMurOuest);
			
			JLabel d2 = new JLabel("D2");
			d2.setBounds(75, 225, 75, 75);
			frame.getContentPane().add(d2);
			d2.setIcon(imageIconCaseNormal);
			
			JLabel d3 = new JLabel("D3");
			d3.setBounds(150, 225, 75, 75);
			frame.getContentPane().add(d3);
			d3.setIcon(imageIconAvancerHaut);
			
			JLabel d4 = new JLabel("D4");
			d4.setBounds(225, 150, 75, 75);
			frame.getContentPane().add(d4);
			d4.setIcon(imageIconAvancerHaut);
			
			JLabel d5 = new JLabel("D5");
			d5.setBounds(300, 150, 75, 75);
			frame.getContentPane().add(d5);
			d5.setIcon(imageIconAvancerDroite);
			
			JLabel d6 = new JLabel("CaseC6");
			d6.setBounds(375, 150, 75, 75);
			frame.getContentPane().add(d6);
			d6.setIcon(imageIconAvancerDroite);
			
			JLabel d7 = new JLabel("CaseC7");
			d7.setBounds(450, 150, 75, 75);
			frame.getContentPane().add(d7);
			d7.setIcon(imageIconAvancerDroite);
			
			JLabel d8 = new JLabel("CaseC8");
			d8.setBounds(525, 150, 75, 75);
			frame.getContentPane().add(d8);
			d8.setIcon(imageIconAvancerDroite);
			
			JLabel d9= new JLabel("CaseC9");
			d9.setBounds(600, 150, 75, 75);
			frame.getContentPane().add(d9);
			d9.setIcon(imageIconAvancerDroite);
			
			JLabel d10 = new JLabel("CaseC10");
			d10.setBounds(675, 150, 75, 75);
			frame.getContentPane().add(d10);
			d10.setIcon(imageIconAvancerDroite);
			
			JLabel d11 = new JLabel("CaseC11");
			d11.setBounds(750, 150, 75, 75);
			frame.getContentPane().add(d11);
			d11.setIcon(imageIconCaseNormal);
			
			JLabel d12 = new JLabel("CaseC12");
			d12.setBounds(825, 150, 75, 75);
			frame.getContentPane().add(d12);
			d12.setIcon(imageIconMurEst);
			
}
}
