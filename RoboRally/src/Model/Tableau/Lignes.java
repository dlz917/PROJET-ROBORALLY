package Model.Tableau;

/*-----------------------------------ENUM LIGNES--------------------
 * 
 * MÉTHODE DE L'ENUM:
 * 		- Lignes[] ListLignes() 
 * 			> retourne la liste Lignes contenat toute les valeurs de l'enum
 * 		- Lignes previous()
 * 			> retourne une ligne -1
 * 		- Lignes next()
 * 			> retourne une ligne +1
 * 		- getIntValue()
 * 			parcourir tableau plus facilement 
 */
public enum Lignes {
	A,B,C,D,E,F,G,H,I,J,K,L;

/*------------------------------FONCTION---------------------------*/
	public static Lignes[] ListLignes() { //LIST AVEC TOUTES LES VALEURS DE L' ENUM
		return Lignes.values();
	}
	public Lignes previous() {
		if (this==Lignes.A)
			return Lignes.A;
		else
			return ListLignes()[(ordinal() - 1  + ListLignes().length) % ListLignes().length];
	}
	public Lignes next() {
		if (this==Lignes.L)
			return Lignes.L;
		else
			return ListLignes()[(ordinal() + 1) % ListLignes().length];
	}
	public int getIntValue(){//Pour parcourir le tableau facilement
		for (int i=0;i<ListLignes().length;i++){
			if (this==ListLignes()[i])
				return i;}
			return -1;// on va gerer les exceptions plus tard
		}
	
	// ------------------- Test -------------------
	public static void main(String[] args) {
		System.out.println(A.next());
		System.out.println(A.previous());
		System.out.println(L.next());
	}}  


