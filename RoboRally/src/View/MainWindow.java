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

	public JFrame getFrame() {
		return frame;
	}


		public MainWindow() {
			initialize();
		}

		private void initialize(){
			frame=new JFrame();
			frame.setBounds(100, 100, 950, 950);
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
			BufferedImage imageCaseAvancerBas=afficherCaseAvancerBas.getCaseAvancerBas();
			ImageIcon imageIconAvancerBas = new ImageIcon(imageCaseAvancerBas.getScaledInstance(75, 75, Image.SCALE_DEFAULT));
			
			afficherCaseAvancerHaut AffichageAvancerHaut=new afficherCaseAvancerHaut();
			BufferedImage imageCaseAvancerHaut=afficherCaseAvancerHaut.getCaseAvancerHaut();
			ImageIcon imageIconAvancerHaut= new ImageIcon(imageCaseAvancerHaut.getScaledInstance(75, 75, Image.SCALE_DEFAULT));
			
			afficherCaseAvancerGauche AffichageAvancerGauche=new afficherCaseAvancerGauche();
			BufferedImage imageCaseAvancerGauche=afficherCaseAvancerGauche.getCaseAvancerGauche();
			ImageIcon imageIconAvancerGauche = new ImageIcon(imageCaseAvancerGauche.getScaledInstance(75, 75, Image.SCALE_DEFAULT));
			
			afficherCaseLaserNord AffichageLaserNord=new afficherCaseLaserNord();
			BufferedImage imageCaseLaserNord=afficherCaseLaserNord.getCaseLaserNord();
			ImageIcon imageIconLaserNord = new ImageIcon(imageCaseLaserNord.getScaledInstance(75, 75, Image.SCALE_DEFAULT));
			
			afficherCaseLaserSud AffichageLaserSud=new afficherCaseLaserSud();
			BufferedImage imageCaseLaserSud=afficherCaseLaserSud.getCaseLaserSud();
			ImageIcon imageIconLaserSud = new ImageIcon(imageCaseLaserSud.getScaledInstance(75, 75, Image.SCALE_DEFAULT));
			
			afficherCaseLaserOuest AffichageLaserOuest=new afficherCaseLaserOuest();
			BufferedImage imageCaseLaserOuest=afficherCaseLaserOuest.getCaseLaserOuest();
			ImageIcon imageIconLaserOuest = new ImageIcon(imageCaseLaserOuest.getScaledInstance(75, 75, Image.SCALE_DEFAULT));

			afficherCaseLaserEst AffichageLaserEst=new afficherCaseLaserEst();
			BufferedImage imageCaseLaserEst=afficherCaseLaserEst.getCaseLaserEst();
			ImageIcon imageIconLaserEst = new ImageIcon(imageCaseLaserEst.getScaledInstance(75, 75, Image.SCALE_DEFAULT));
			
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
			d4.setBounds(225, 225, 75, 75);
			frame.getContentPane().add(d4);
			d4.setIcon(imageIconLaserOuest);
			
			JLabel d5 = new JLabel("D5");
			d5.setBounds(300, 225, 75, 75);
			frame.getContentPane().add(d5);
			d5.setIcon(imageIconCaseNormal);
			
			JLabel d6 = new JLabel("D6");
			d6.setBounds(375, 225, 75, 75);
			frame.getContentPane().add(d6);
			d6.setIcon(imageIconCaseNormal);
			
			JLabel d7 = new JLabel("D7");
			d7.setBounds(450, 225, 75, 75);
			frame.getContentPane().add(d7);
			d7.setIcon(imageIconCaseNormal);
			
			JLabel d8 = new JLabel("D8");
			d8.setBounds(525, 225, 75, 75);
			frame.getContentPane().add(d8);
			d8.setIcon(imageIconCaseNormal);
			
			JLabel d9= new JLabel("D9");
			d9.setBounds(600, 225, 75, 75);
			frame.getContentPane().add(d9);
			d9.setIcon(imageIconLaserNord);
			
			JLabel d10 = new JLabel("D10");
			d10.setBounds(675, 225, 75, 75);
			frame.getContentPane().add(d10);
			d10.setIcon(imageIconAvancerBas);
			
			JLabel d11 = new JLabel("D11");
			d11.setBounds(750, 225, 75, 75);
			frame.getContentPane().add(d11);
			d11.setIcon(imageIconCaseNormal);
			
			JLabel d12 = new JLabel("D12");
			d12.setBounds(825, 225, 75, 75);
			frame.getContentPane().add(d12);
			d12.setIcon(imageIconMurEst);
			
			JLabel e1 = new JLabel("E1");
			e1.setBounds(0, 300, 75, 75);
			frame.getContentPane().add(e1);
			e1.setIcon(imageIconMurOuest);
			
			JLabel e2 = new JLabel("E2");
			e2.setBounds(75, 300, 75, 75);
			frame.getContentPane().add(e2);
			e2.setIcon(imageIconCaseNormal);
			
			JLabel e3 = new JLabel("E3");
			e3.setBounds(150, 300, 75, 75);
			frame.getContentPane().add(e3);
			e3.setIcon(imageIconAvancerHaut);
			
			JLabel e4 = new JLabel("E4");
			e4.setBounds(225, 300, 75, 75);
			frame.getContentPane().add(e4);
			e4.setIcon(imageIconCaseNormal);
			
			JLabel e5 = new JLabel("E5");
			e5.setBounds(300, 300, 75, 75);
			frame.getContentPane().add(e5);
			e5.setIcon(imageIconCaseNormal);
			
			JLabel e6 = new JLabel("E6");
			e6.setBounds(375, 300, 75, 75);
			frame.getContentPane().add(e6);
			e6.setIcon(imageIconCaseNormal);
			
			JLabel e7 = new JLabel("E7");
			e7.setBounds(450, 300, 75, 75);
			frame.getContentPane().add(e7);
			e7.setIcon(imageIconCaseNormal);
			
			JLabel e8 = new JLabel("E8");
			e8.setBounds(525, 300, 75, 75);
			frame.getContentPane().add(e8);
			e8.setIcon(imageIconCaseNormal);
			
			JLabel e9= new JLabel("E9");
			e9.setBounds(600, 300, 75, 75);
			frame.getContentPane().add(e9);
			e9.setIcon(imageIconCaseNormal);
			
			JLabel e10 = new JLabel("E10");
			e10.setBounds(675, 300, 75, 75);
			frame.getContentPane().add(e10);
			e10.setIcon(imageIconAvancerBas);
			
			JLabel e11 = new JLabel("E11");
			e11.setBounds(750, 300, 75, 75);
			frame.getContentPane().add(e11);
			e11.setIcon(imageIconCaseNormal);
			
			JLabel e12 = new JLabel("E12");
			e12.setBounds(825, 300, 75, 75);
			frame.getContentPane().add(e12);
			e12.setIcon(imageIconMurEst);
			
			JLabel f1 = new JLabel("F1");
			f1.setBounds(0, 375, 75, 75);
			frame.getContentPane().add(f1);
			f1.setIcon(imageIconMurOuest);
			
			JLabel f2 = new JLabel("F2");
			f2.setBounds(75, 375, 75, 75);
			frame.getContentPane().add(f2);
			f2.setIcon(imageIconCaseTrou);
			
			JLabel f3 = new JLabel("F3");
			f3.setBounds(150, 375, 75, 75);
			frame.getContentPane().add(f3);
			f3.setIcon(imageIconAvancerHaut);
			
			JLabel f4 = new JLabel("F4");
			f4.setBounds(225, 375, 75, 75);
			frame.getContentPane().add(f4);
			f4.setIcon(imageIconCaseNormal);
			
			JLabel f5 = new JLabel("F5");
			f5.setBounds(300, 375, 75, 75);
			frame.getContentPane().add(f5);
			f5.setIcon(imageIconCaseNormal);
			
			JLabel f6 = new JLabel("F6");
			f6.setBounds(375, 375, 75, 75);
			frame.getContentPane().add(f6);
			f6.setIcon(imageIconCaseNormal);
			
			JLabel f7 = new JLabel("F7");
			f7.setBounds(450, 375, 75, 75);
			frame.getContentPane().add(f7);
			f7.setIcon(imageIconCaseNormal);
			
			JLabel f8 = new JLabel("F8");
			f8.setBounds(525, 375, 75, 75);
			frame.getContentPane().add(f8);
			f8.setIcon(imageIconCaseNormal);
			
			JLabel f9= new JLabel("F9");
			f9.setBounds(600, 375, 75, 75);
			frame.getContentPane().add(f9);
			f9.setIcon(imageIconCaseNormal);
			
			JLabel f10 = new JLabel("F10");
			f10.setBounds(675, 375, 75, 75);
			frame.getContentPane().add(f10);
			f10.setIcon(imageIconAvancerBas);
			
			JLabel f11 = new JLabel("F11");
			f11.setBounds(750, 375, 75, 75);
			frame.getContentPane().add(f11);
			f11.setIcon(imageIconCaseTrou);
			
			JLabel f12 = new JLabel("F12");
			f12.setBounds(825, 375, 75, 75);
			frame.getContentPane().add(f12);
			f12.setIcon(imageIconMurEst);
			
			JLabel g1 = new JLabel("G1");
			g1.setBounds(0, 450, 75, 75);
			frame.getContentPane().add(g1);
			g1.setIcon(imageIconMurOuest);
			
			JLabel g2 = new JLabel("G2");
			g2.setBounds(75, 450, 75, 75);
			frame.getContentPane().add(g2);
			g2.setIcon(imageIconCaseTrou);
			
			JLabel g3 = new JLabel("G3");
			g3.setBounds(150, 450, 75, 75);
			frame.getContentPane().add(g3);
			g3.setIcon(imageIconAvancerHaut);
			
			JLabel g4 = new JLabel("G4");
			g4.setBounds(225, 450, 75, 75);
			frame.getContentPane().add(g4);
			g4.setIcon(imageIconCaseNormal);
			
			JLabel g5 = new JLabel("G5");
			g5.setBounds(300, 450, 75, 75);
			frame.getContentPane().add(g5);
			g5.setIcon(imageIconCaseNormal);
			
			JLabel g6 = new JLabel("G6");
			g6.setBounds(375, 450, 75, 75);
			frame.getContentPane().add(g6);
			g6.setIcon(imageIconCaseNormal);
			
			JLabel g7 = new JLabel("G7");
			g7.setBounds(450, 450, 75, 75);
			frame.getContentPane().add(g7);
			g7.setIcon(imageIconCaseNormal);
			
			JLabel g8 = new JLabel("G8");
			g8.setBounds(525, 450, 75, 75);
			frame.getContentPane().add(g8);
			g8.setIcon(imageIconCaseNormal);
			
			JLabel g9= new JLabel("G9");
			g9.setBounds(600, 450, 75, 75);
			frame.getContentPane().add(g9);
			g9.setIcon(imageIconCaseNormal);
			
			JLabel g10 = new JLabel("F10");
			g10.setBounds(675, 450, 75, 75);
			frame.getContentPane().add(g10);
			g10.setIcon(imageIconAvancerBas);
			
			JLabel g11 = new JLabel("F11");
			g11.setBounds(750, 450, 75, 75);
			frame.getContentPane().add(g11);
			g11.setIcon(imageIconCaseTrou);
			
			JLabel g12 = new JLabel("F12");
			g12.setBounds(825, 450, 75, 75);
			frame.getContentPane().add(g12);
			g12.setIcon(imageIconMurEst);
			
			JLabel h1 = new JLabel("H1");
			h1.setBounds(0, 525, 75, 75);
			frame.getContentPane().add(h1);
			h1.setIcon(imageIconMurOuest);
			
			JLabel h2 = new JLabel("H2");
			h2.setBounds(75, 525, 75, 75);
			frame.getContentPane().add(h2);
			h2.setIcon(imageIconCaseNormal);
			
			JLabel h3 = new JLabel("H3");
			h3.setBounds(150, 525, 75, 75);
			frame.getContentPane().add(h3);
			h3.setIcon(imageIconAvancerHaut);
			
			JLabel h4 = new JLabel("H4");
			h4.setBounds(225, 525, 75, 75);
			frame.getContentPane().add(h4);
			h4.setIcon(imageIconCaseNormal);
			
			JLabel h5 = new JLabel("H5");
			h5.setBounds(300, 525, 75, 75);
			frame.getContentPane().add(h5);
			h5.setIcon(imageIconCaseNormal);
			
			JLabel h6 = new JLabel("H6");
			h6.setBounds(375, 525, 75, 75);
			frame.getContentPane().add(h6);
			h6.setIcon(imageIconCaseNormal);
			
			JLabel h7 = new JLabel("H7");
			h7.setBounds(450, 525, 75, 75);
			frame.getContentPane().add(h7);
			h7.setIcon(imageIconCaseNormal);
			
			JLabel h8 = new JLabel("H8");
			h8.setBounds(525, 525, 75, 75);
			frame.getContentPane().add(h8);
			h8.setIcon(imageIconCaseNormal);
			
			JLabel h9= new JLabel("H9");
			h9.setBounds(600, 525, 75, 75);
			frame.getContentPane().add(h9);
			h9.setIcon(imageIconCaseNormal);
			
			JLabel h10 = new JLabel("H10");
			h10.setBounds(675, 525, 75, 75);
			frame.getContentPane().add(h10);
			h10.setIcon(imageIconAvancerBas);
			
			JLabel h11 = new JLabel("H11");
			h11.setBounds(750, 525, 75, 75);
			frame.getContentPane().add(h11);
			h11.setIcon(imageIconCaseNormal);
			
			JLabel h12 = new JLabel("H12");
			h12.setBounds(825, 525, 75, 75);
			frame.getContentPane().add(h12);
			h12.setIcon(imageIconMurEst);
			
			JLabel i1 = new JLabel("I1");
			i1.setBounds(0, 600, 75, 75);
			frame.getContentPane().add(i1);
			i1.setIcon(imageIconMurOuest);
			
			JLabel i2 = new JLabel("I2");
			i2.setBounds(75, 600, 75, 75);
			frame.getContentPane().add(i2);
			i2.setIcon(imageIconCaseNormal);
			
			JLabel i3 = new JLabel("I3");
			i3.setBounds(150, 600, 75, 75);
			frame.getContentPane().add(i3);
			i3.setIcon(imageIconAvancerHaut);
			
			JLabel i4 = new JLabel("I4");
			i4.setBounds(225, 600, 75, 75);
			frame.getContentPane().add(i4);
			i4.setIcon(imageIconLaserSud);
			
			JLabel i5 = new JLabel("I5");
			i5.setBounds(300, 600, 75, 75);
			frame.getContentPane().add(i5);
			i5.setIcon(imageIconCaseNormal);
			
			JLabel i6 = new JLabel("I6");
			i6.setBounds(375, 600, 75, 75);
			frame.getContentPane().add(i6);
			i6.setIcon(imageIconCaseNormal);
			
			JLabel i7 = new JLabel("I7");
			i7.setBounds(450, 600, 75, 75);
			frame.getContentPane().add(i7);
			i7.setIcon(imageIconCaseNormal);
			
			JLabel i8 = new JLabel("I8");
			i8.setBounds(525, 600, 75, 75);
			frame.getContentPane().add(i8);
			i8.setIcon(imageIconCaseNormal);
			
			JLabel i9= new JLabel("I9");
			i9.setBounds(600, 600, 75, 75);
			frame.getContentPane().add(i9);
			i9.setIcon(imageIconLaserEst);
			
			JLabel i10 = new JLabel("I10");
			i10.setBounds(675, 600, 75, 75);
			frame.getContentPane().add(i10);
			i10.setIcon(imageIconAvancerBas);
			
			JLabel i11 = new JLabel("I11");
			i11.setBounds(750, 600, 75, 75);
			frame.getContentPane().add(i11);
			i11.setIcon(imageIconCaseNormal);
			
			JLabel i12 = new JLabel("I12");
			i12.setBounds(825, 600, 75, 75);
			frame.getContentPane().add(i12);
			i12.setIcon(imageIconMurEst);
			
			JLabel j1 = new JLabel("J1");
			j1.setBounds(0, 675, 75, 75);
			frame.getContentPane().add(j1);
			j1.setIcon(imageIconMurOuest);
			
			JLabel j2 = new JLabel("C2");
			j2.setBounds(75, 675, 75, 75);
			frame.getContentPane().add(j2);
			j2.setIcon(imageIconCaseNormal);
			
			JLabel j3 = new JLabel("C3");
			j3.setBounds(150, 675, 75, 75);
			frame.getContentPane().add(j3);
			j3.setIcon(imageIconAvancerGauche);
			
			JLabel j4 = new JLabel("J4");
			j4.setBounds(225, 675, 75, 75);
			frame.getContentPane().add(j4);
			j4.setIcon(imageIconAvancerGauche);
			
			JLabel j5 = new JLabel("J5");
			j5.setBounds(300, 675, 75, 75);
			frame.getContentPane().add(j5);
			j5.setIcon(imageIconAvancerGauche);
			
			JLabel j6 = new JLabel("J6");
			j6.setBounds(375, 675, 75, 75);
			frame.getContentPane().add(j6);
			j6.setIcon(imageIconAvancerGauche);
			
			JLabel j7 = new JLabel("J7");
			j7.setBounds(450, 675, 75, 75);
			frame.getContentPane().add(j7);
			j7.setIcon(imageIconAvancerGauche);
			
			JLabel j8 = new JLabel("J8");
			j8.setBounds(525, 675, 75, 75);
			frame.getContentPane().add(j8);
			j8.setIcon(imageIconAvancerGauche);
			
			JLabel j9= new JLabel("J9");
			j9.setBounds(600, 675, 75, 75);
			frame.getContentPane().add(j9);
			j9.setIcon(imageIconAvancerGauche);
			
			JLabel j10 = new JLabel("C10");
			j10.setBounds(675, 675, 75, 75);
			frame.getContentPane().add(j10);
			j10.setIcon(imageIconAvancerGauche);
			
			JLabel j11 = new JLabel("C11");
			j11.setBounds(750, 675, 75, 75);
			frame.getContentPane().add(j11);
			j11.setIcon(imageIconCaseNormal);
			
			JLabel j12 = new JLabel("C12");
			j12.setBounds(825, 675, 75, 75);
			frame.getContentPane().add(j12);
			j12.setIcon(imageIconMurEst);
			
			JLabel k1 = new JLabel("K1");
			k1.setBounds(0, 750, 75, 75);
			frame.getContentPane().add(k1);
			k1.setIcon(imageIconMurOuest);
			
			JLabel k2 = new JLabel("K2");
			k2.setBounds(75, 750, 75, 75);
			frame.getContentPane().add(k2);
			k2.setIcon(imageIconCaseNormal);
			
			JLabel k3 = new JLabel("K3");
			k3.setBounds(150, 750, 75, 75);
			frame.getContentPane().add(k3);
			k3.setIcon(imageIconCaseNormal);
			
			JLabel k4 = new JLabel("K4");
			k4.setBounds(225, 750, 75, 75);
			frame.getContentPane().add(k4);
			k4.setIcon(imageIconCaseNormal);
			
			JLabel k5 = new JLabel("K5");
			k5.setBounds(300, 750, 75, 75);
			frame.getContentPane().add(k5);
			k5.setIcon(imageIconCaseNormal);
			
			JLabel k6 = new JLabel("K6");
			k6.setBounds(375, 750, 75, 75);
			frame.getContentPane().add(k6);
			k6.setIcon(imageIconCaseTrou);
			
			JLabel k7 = new JLabel("K7");
			k7.setBounds(450, 750, 75, 75);
			frame.getContentPane().add(k7);
			k7.setIcon(imageIconCaseTrou);
			
			JLabel k8 = new JLabel("K8");
			k8.setBounds(525, 750, 75, 75);
			frame.getContentPane().add(k8);
			k8.setIcon(imageIconCaseNormal);
			
			JLabel k9 = new JLabel("K9");
			k9.setBounds(600, 750, 75, 75);
			frame.getContentPane().add(k9);
			k9.setIcon(imageIconCaseNormal);
			
			JLabel k10 = new JLabel("K10");
			k10.setBounds(675, 750, 75, 75);
			frame.getContentPane().add(k10);
			k10.setIcon(imageIconCaseNormal);
			
			JLabel k11 = new JLabel("K11");
			k11.setBounds(750, 750, 75, 75);
			frame.getContentPane().add(k11);
			k11.setIcon(imageIconCaseNormal);
		
			JLabel k12 = new JLabel("K12");
			k12.setBounds(825, 750, 75, 75);
			frame.getContentPane().add(k12);
			k12.setIcon(imageIconMurEst);
			

			JLabel l2= new JLabel("L2");
			l2.setBounds(75, 825, 75, 75);
			frame.getContentPane().add(l2);
			l2.setIcon(imageIconMurSud);
			
			JLabel l3 = new JLabel("L3");
			l3.setBounds(150, 825, 75, 75);
			frame.getContentPane().add(l3);
			l3.setIcon(imageIconMurSud);
			
			JLabel l4 = new JLabel("L4");
			l4.setBounds(225, 825, 75, 75);
			frame.getContentPane().add(l4);
			l4.setIcon(imageIconMurSud);
			
			JLabel l5 = new JLabel("L5");
			l5.setBounds(300, 825, 75, 75);
			frame.getContentPane().add(l5);
			l5.setIcon(imageIconMurSud);
			
			JLabel l6 = new JLabel("L6");
			l6.setBounds(375, 825, 75, 75);
			frame.getContentPane().add(l6);
			l6.setIcon(imageIconMurSud);
			
			JLabel l7 = new JLabel("L7");
			l7.setBounds(450, 825, 75, 75);
			frame.getContentPane().add(l7);
			l7.setIcon(imageIconMurSud);
			
			JLabel l8 = new JLabel("L8");
			l8.setBounds(525, 825, 75, 75);
			frame.getContentPane().add(l8);
			l8.setIcon(imageIconMurSud);
			
			JLabel l9 = new JLabel("L9");
			l9.setBounds(600, 825, 75, 75);
			frame.getContentPane().add(l9);
			l9.setIcon(imageIconMurSud);
			
			JLabel l10 = new JLabel("L10");
			l10.setBounds(675, 825, 75, 75);
			frame.getContentPane().add(l10);
			l10.setIcon(imageIconMurSud);
			
			JLabel l11 = new JLabel("L11");
			l11.setBounds(750, 825, 75, 75);
			frame.getContentPane().add(l11);
			l11.setIcon(imageIconMurSud);
		}}
			



