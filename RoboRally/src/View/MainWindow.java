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
			ImageIcon imageIconAvancerBas = new ImageIcon(imageCaseAvancerDroite.getScaledInstance(75, 75, Image.SCALE_DEFAULT));
			
			afficherCaseAvancerDroite AffichageAvancerDroite=new afficherCaseAvancerDroite();
			BufferedImage imageCaseAvancerDroite=afficherCaseAvancerDroite.getCaseAvancerDroite();
			ImageIcon imageIconAvancerDroite = new ImageIcon(imageCaseAvancerDroite.getScaledInstance(75, 75, Image.SCALE_DEFAULT));
			
			afficherCaseAvancerDroite AffichageAvancerDroite=new afficherCaseAvancerDroite();
			BufferedImage imageCaseAvancerDroite=afficherCaseAvancerDroite.getCaseAvancerDroite();
			ImageIcon imageIconAvancerDroite = new ImageIcon(imageCaseAvancerDroite.getScaledInstance(75, 75, Image.SCALE_DEFAULT));
			
			
			JLabel a2 = new JLabel("CaseA2");
			a2.setBounds(75, 0, 75, 75);
			frame.getContentPane().add(a2);
			a2.setIcon(imageIconMurNord);
			
			JLabel a3 = new JLabel("CaseA3");
			a3.setBounds(150, 0, 75, 75);
			frame.getContentPane().add(a3);
			a3.setIcon(imageIconMurNord);
			
			JLabel a4 = new JLabel("CaseA4");
			a4.setBounds(225, 0, 75, 75);
			frame.getContentPane().add(a4);
			a4.setIcon(imageIconMurNord);
			
			JLabel a5 = new JLabel("CaseA5");
			a5.setBounds(300, 0, 75, 75);
			frame.getContentPane().add(a5);
			a5.setIcon(imageIconMurNord);
			
			JLabel a6 = new JLabel("CaseA6");
			a6.setBounds(375, 0, 75, 75);
			frame.getContentPane().add(a6);
			a6.setIcon(imageIconMurNord);
			
			JLabel a7 = new JLabel("CaseA7");
			a7.setBounds(450, 0, 75, 75);
			frame.getContentPane().add(a7);
			a7.setIcon(imageIconMurNord);
			
			JLabel a8 = new JLabel("CaseA8");
			a8.setBounds(525, 0, 75, 75);
			frame.getContentPane().add(a8);
			a8.setIcon(imageIconMurNord);
			
			JLabel a9 = new JLabel("CaseA9");
			a9.setBounds(600, 0, 75, 75);
			frame.getContentPane().add(a9);
			a9.setIcon(imageIconMurNord);
			
			JLabel a10 = new JLabel("CaseA10");
			a10.setBounds(675, 0, 75, 75);
			frame.getContentPane().add(a10);
			a10.setIcon(imageIconMurNord);
			
			JLabel a11 = new JLabel("CaseA11");
			a11.setBounds(750, 0, 75, 75);
			frame.getContentPane().add(a11);
			a11.setIcon(imageIconMurNord);
			
			JLabel b1 = new JLabel("CaseB1");
			b1.setBounds(0, 75, 75, 75);
			frame.getContentPane().add(b1);
			b1.setIcon(imageIconMurOuest);
			
			JLabel b2 = new JLabel("CaseB2");
			b2.setBounds(75, 75, 75, 75);
			frame.getContentPane().add(b2);
			b2.setIcon(imageIconCaseNormal);
			
			JLabel b3 = new JLabel("CaseB3");
			b3.setBounds(150, 75, 75, 75);
			frame.getContentPane().add(b3);
			b3.setIcon(imageIconCaseNormal);
			
			JLabel b4 = new JLabel("CaseB4");
			b4.setBounds(225, 75, 75, 75);
			frame.getContentPane().add(b4);
			b4.setIcon(imageIconCaseNormal);
			
			JLabel b5 = new JLabel("CaseB5");
			b5.setBounds(300, 75, 75, 75);
			frame.getContentPane().add(b5);
			b5.setIcon(imageIconCaseNormal);
			
			JLabel b6 = new JLabel("CaseB6");
			b6.setBounds(375, 75, 75, 75);
			frame.getContentPane().add(b6);
			b6.setIcon(imageIconCaseTrou);
			
			JLabel b7 = new JLabel("CaseB7");
			b7.setBounds(450, 75, 75, 75);
			frame.getContentPane().add(b7);
			b7.setIcon(imageIconCaseTrou);
			
			JLabel b8 = new JLabel("CaseB8");
			b8.setBounds(525, 75, 75, 75);
			frame.getContentPane().add(b8);
			b8.setIcon(imageIconCaseNormal);
			
			JLabel b9 = new JLabel("CaseB9");
			b9.setBounds(600, 75, 75, 75);
			frame.getContentPane().add(b9);
			b9.setIcon(imageIconCaseNormal);
			
			JLabel b10 = new JLabel("CaseB10");
			b10.setBounds(675, 75, 75, 75);
			frame.getContentPane().add(b10);
			b10.setIcon(imageIconCaseNormal);
			
			JLabel b11 = new JLabel("CaseB11");
			b11.setBounds(750, 75, 75, 75);
			frame.getContentPane().add(b11);
			b11.setIcon(imageIconCaseNormal);
		
			JLabel b12 = new JLabel("CaseB12");
			b12.setBounds(825, 75, 75, 75);
			frame.getContentPane().add(b12);
			b12.setIcon(imageIconMurEst);
			
			JLabel c1 = new JLabel("CaseB1");
			c1.setBounds(0, 75, 75, 75);
			frame.getContentPane().add(c1);
			c1.setIcon(imageIconMurOuest);
			
			JLabel c2 = new JLabel("CaseB2");
			c2.setBounds(75, 75, 75, 75);
			frame.getContentPane().add(c2);
			c2.setIcon(imageIconCaseNormal);
			
			JLabel c3 = new JLabel("CaseB3");
			c3.setBounds(150, 75, 75, 75);
			frame.getContentPane().add(c3);
			c3.setIcon(imageIconCaseNormal);
			
			JLabel b4 = new JLabel("CaseB4");
			b4.setBounds(225, 75, 75, 75);
			frame.getContentPane().add(b4);
			b4.setIcon(imageIconCaseNormal);
			
			JLabel b5 = new JLabel("CaseB5");
			b5.setBounds(300, 75, 75, 75);
			frame.getContentPane().add(b5);
			b5.setIcon(imageIconCaseNormal);
			
			JLabel b6 = new JLabel("CaseB6");
			b6.setBounds(375, 75, 75, 75);
			frame.getContentPane().add(b6);
			b6.setIcon(imageIconCaseTrou);
			
			JLabel b7 = new JLabel("CaseB7");
			b7.setBounds(450, 75, 75, 75);
			frame.getContentPane().add(b7);
			b7.setIcon(imageIconCaseTrou);
			
			JLabel b8 = new JLabel("CaseB8");
			b8.setBounds(525, 75, 75, 75);
			frame.getContentPane().add(b8);
			b8.setIcon(imageIconCaseNormal);
			
			JLabel b9 = new JLabel("CaseB9");
			b9.setBounds(600, 75, 75, 75);
			frame.getContentPane().add(b9);
			b9.setIcon(imageIconCaseNormal);
			
			JLabel c10 = new JLabel("CaseB10");
			c10.setBounds(675, 7150, 75, 75);
			frame.getContentPane().add(b10);
			b10.setIcon(imageIconCaseNormal);
			
			JLabel c11 = new JLabel("CaseB11");
			c11.setBounds(750, 150, 75, 75);
			frame.getContentPane().add(c11);
			c11.setIcon(imageIconCaseNormal);
			
			JLabel c12 = new JLabel("CaseB12");
			c12.setBounds(825, 150, 75, 75);
			frame.getContentPane().add(c12);
			c12.setIcon(imageIconMurEst);
			
			
}
}
