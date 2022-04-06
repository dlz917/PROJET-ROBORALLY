package Model;

import java.util.ArrayList;

import Model.Cartes.ActionCarte;
import Model.Cartes.CartesProgramme;

public class PartieTest {

	public static void main(String[] args) {
		
		Partie p=new Partie();
		
		//J0
		String pseudo1="kass";
		p.ajouterJoueur(pseudo1, 0);
		
		ArrayList<CartesProgramme> carteDistrib1= new ArrayList<CartesProgramme>();
		CartesProgramme carte11 = new CartesProgramme(86, ActionCarte.avancer1);
		carteDistrib1.add(carte11);
		CartesProgramme carte12 = new CartesProgramme(77, ActionCarte.tournerD);
		carteDistrib1.add(carte12);
		CartesProgramme carte13 = new CartesProgramme(69, ActionCarte.avancer3);
		carteDistrib1.add(carte13);
		CartesProgramme carte14 = new CartesProgramme(50, ActionCarte.reculer1);
		carteDistrib1.add(carte14);
		CartesProgramme carte15 = new CartesProgramme(30, ActionCarte.demitour);
		carteDistrib1.add(carte15);
		CartesProgramme carte16 = new CartesProgramme(22, ActionCarte.tournerD);
		carteDistrib1.add(carte16);
		CartesProgramme carte17 = new CartesProgramme(3, ActionCarte.tournerG);
		carteDistrib1.add(carte17);
		CartesProgramme carte18 = new CartesProgramme(24, ActionCarte.avancer3);
		carteDistrib1.add(carte18);
		CartesProgramme carte19 = new CartesProgramme(64, ActionCarte.avancer2);
		carteDistrib1.add(carte19);
		p.getListeRobot().get(0).setCartesDistribuees(carteDistrib1);
		
		ArrayList<Integer> carte1= new ArrayList<Integer>();
		carte1.add(22);
		carte1.add(77);
		carte1.add(69);
		carte1.add(50);
		carte1.add(30);
		p.ajouterCartes(carte1, 0);
		
		// J1
		String pseudo2="lea";
		p.ajouterJoueur(pseudo2, 1);
		
		ArrayList<CartesProgramme> carteDistrib2= new ArrayList<CartesProgramme>();
		CartesProgramme carte21 = new CartesProgramme(79, ActionCarte.avancer2);
		carteDistrib2.add(carte21);
		CartesProgramme carte22 = new CartesProgramme(65, ActionCarte.reculer1);
		carteDistrib2.add(carte22);
		CartesProgramme carte23 = new CartesProgramme(61, ActionCarte.avancer1);
		carteDistrib2.add(carte23);
		CartesProgramme carte24 = new CartesProgramme(52, ActionCarte.tournerD);
		carteDistrib2.add(carte24);
		CartesProgramme carte25 = new CartesProgramme(46, ActionCarte.avancer1);
		carteDistrib2.add(carte25);
		CartesProgramme carte26 = new CartesProgramme(41, ActionCarte.avancer1);
		carteDistrib2.add(carte26);
		CartesProgramme carte27 = new CartesProgramme(38, ActionCarte.tournerG);
		carteDistrib2.add(carte27);
		CartesProgramme carte28 = new CartesProgramme(90, ActionCarte.demitour);
		carteDistrib2.add(carte28);
		CartesProgramme carte29 = new CartesProgramme(75, ActionCarte.demitour);
		carteDistrib2.add(carte29);
		p.getListeRobot().get(1).setCartesDistribuees(carteDistrib2);
		
		ArrayList<Integer> carte2= new ArrayList<Integer>();
		carte2.add(79);
		carte2.add(65);
		carte2.add(38);
		carte2.add(75);
		carte2.add(90);
		p.ajouterCartes(carte2, 1);
		
		// J2
		String pseudo3="joan";
		p.ajouterJoueur(pseudo3, 2);
		
		ArrayList<CartesProgramme> carteDistrib3= new ArrayList<CartesProgramme>();
		CartesProgramme carte31 = new CartesProgramme(1, ActionCarte.avancer1);
		carteDistrib3.add(carte31);
		CartesProgramme carte32 = new CartesProgramme(51, ActionCarte.avancer1);
		carteDistrib3.add(carte32);
		CartesProgramme carte33 = new CartesProgramme(29, ActionCarte.avancer2);
		carteDistrib3.add(carte33);
		CartesProgramme carte34 = new CartesProgramme(44, ActionCarte.avancer2);
		carteDistrib3.add(carte34);
		CartesProgramme carte35 = new CartesProgramme(9, ActionCarte.avancer3);
		carteDistrib3.add(carte35);
		CartesProgramme carte36 = new CartesProgramme(80, ActionCarte.reculer1);
		carteDistrib3.add(carte36);
		CartesProgramme carte37 = new CartesProgramme(67, ActionCarte.tournerD);
		carteDistrib3.add(carte37);
		CartesProgramme carte38 = new CartesProgramme(32, ActionCarte.tournerD);
		carteDistrib3.add(carte38);
		CartesProgramme carte39 = new CartesProgramme(88, ActionCarte.tournerG);
		carteDistrib3.add(carte39);
		p.getListeRobot().get(2).setCartesDistribuees(carteDistrib3);
		
		ArrayList<Integer> carte3= new ArrayList<Integer>();
		carte3.add(67);
		carte3.add(51);
		carte3.add(9);
		carte3.add(80);
		carte3.add(32);
		p.ajouterCartes(carte3, 2);
		
		
		// J3
		String pseudo4="anna";
		p.ajouterJoueur(pseudo4, 3);
		
		ArrayList<CartesProgramme> carteDistrib4= new ArrayList<CartesProgramme>();
		CartesProgramme carte41 = new CartesProgramme(6, ActionCarte.avancer1);
		carteDistrib4.add(carte41);
		CartesProgramme carte42 = new CartesProgramme(81, ActionCarte.avancer1);
		carteDistrib4.add(carte42);
		CartesProgramme carte43 = new CartesProgramme(4, ActionCarte.avancer2);
		carteDistrib4.add(carte43);
		CartesProgramme carte44 = new CartesProgramme(62, ActionCarte.tournerD);
		carteDistrib4.add(carte44);
		CartesProgramme carte45 = new CartesProgramme(37, ActionCarte.tournerD);
		carteDistrib4.add(carte45);
		CartesProgramme carte46 = new CartesProgramme(88, ActionCarte.tournerG);
		carteDistrib4.add(carte46);
		CartesProgramme carte47 = new CartesProgramme(13, ActionCarte.tournerG);
		carteDistrib4.add(carte47);
		CartesProgramme carte48 = new CartesProgramme(45, ActionCarte.demitour);
		carteDistrib4.add(carte48);
		CartesProgramme carte49 = new CartesProgramme(23, ActionCarte.tournerG);
		carteDistrib4.add(carte49);
		p.getListeRobot().get(3).setCartesDistribuees(carteDistrib4);
		
		ArrayList<Integer> carte4= new ArrayList<Integer>();
		carte4.add(88);
		carte4.add(81);
		carte4.add(23);
		carte4.add(45);
		carte4.add(6);
		p.ajouterCartes(carte4, 3);
		
		p.manche();

	}

}
