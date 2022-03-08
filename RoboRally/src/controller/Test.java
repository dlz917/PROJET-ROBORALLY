package Projet;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	public static void main (String[] args) {
		StockCartesPerso stock = new StockCartesPerso();
		System.out.println(stock);
		stock.stockCartesInitial();
		System.out.println(stock);
		//System.out.println(stock.StockCartesTriees());
		CartesProgrammePerso cartequeblo = new CartesProgrammePerso (6, ActionCartePerso.avancer1);
		stock.retraitCarteStock(cartequeblo);
		System.out.println(stock);
		stock.ajoutCarteStock(cartequeblo);
		System.out.println(stock);

		/*
		DistributionCartesPerso distribCartes = new DistributionCartesPerso();
		distribCartes.ListeCartes(5, stock.getStockCartes());
		System.out.println(distribCartes);
		distribCartes.TrierListe();
		System.out.println(distribCartes);
		*/
		
	}
}
