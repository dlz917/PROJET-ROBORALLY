package View;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.JList;

import Model.CaseMur;
import Model.CaseTableau;
import Model.Direction;

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
			frame.setBounds(100, 100, 850, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel lblImagegoeshere = new JLabel("ImageGoesHere");
			lblImagegoeshere.setBounds(0, 0, 50, 50);
			frame.getContentPane().add(lblImagegoeshere);
		
			afficherCaseMurNord Affichagemur=new afficherCaseMurNord(new CaseMur(null, Direction.nord));
			BufferedImage imageCaseMur=afficherCaseMurNord.getCaseMur();
			lblImagegoeshere.setIcon(new ImageIcon(imageCaseMur));
			
		}
}
