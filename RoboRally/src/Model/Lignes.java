package Model;

public enum Lignes {
	A,B,C,D,E,F,G,H,I,J,K,L;

	//Fonctions
	public static Lignes[] ListLignes() { //LIST AVEC TOUTES LES VALEURS DE LA ENUM
		return Lignes.values();
	}
	public Lignes previous() {
		if (this.equals(A)){
			return A;}
		else   
			return ListLignes()[(ordinal() - 1  + ListLignes().length) % ListLignes().length];
	}
	public Lignes next() {
		if (this.equals(L)){
			return L;}
		else
			return ListLignes()[(ordinal() + 1) % ListLignes().length];
	}
	public int getIntValue(){//Pour parcourir le tableau facilment
		for (int i=0;i<ListLignes().length;i++){
			if (this==ListLignes()[i])
				return i;}
			return -1;// on va gerer les exceptions plus tard
		}
	
	// ------------------- Test -------------------
	public static void main(String[] args) {
		System.out.println(A.next());
		System.out.println(A.previous());
	}}  


