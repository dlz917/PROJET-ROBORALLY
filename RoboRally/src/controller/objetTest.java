import java.util.ArrayList;
import java.io.Serializable;

public class objetTest implements Serializable {


	public static final long serialVersionUID = 1L;
	public String nom = null;
	public int num = 0;
	public ArrayList<String> enfants = new ArrayList<String>();

	// ------------------- Constructeur -------------------
	
	public objetTest(String nom, int num, ArrayList<String> enfants) {
		try {
		this.nom= nom;
		this.num = num;
		this.enfants = enfants;
	}catch(Exception exp){}
	}
		
	public objetTest() {
	}
		
	// ------------------- Getters / Setters -------------------
	public String getNom() {
		return nom;
	}
	
	
	public void setNom(String nom) {
		try {
		this.nom = nom;
	}catch(Exception exp){}
}
	
	
	public int getNum() {
		return num;
}
	
	
	public void setNum(int num) {
		this.num = num;
}
	
	
	public ArrayList<String> getEnfants() {
		return enfants;
}
	
	
	public void setEnfants(ArrayList<String> enfants) {
		try {
		this.enfants = enfants;
	}catch(Exception exp){}
}
	
	
	public String toString() {
		return getNom()+" : "+getNum();
	}	


}
