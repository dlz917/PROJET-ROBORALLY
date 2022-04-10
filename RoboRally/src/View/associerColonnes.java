package View;
import java.util.HashMap;


public class associerColonnes {
	private HashMap<Integer, Integer> assocColonnes;
	public associerColonnes() {
		assocColonnes = new HashMap<Integer,Integer>();
		assocColonnes.put(1,0);
		assocColonnes.put(2,75);
		assocColonnes.put(3,150);
		assocColonnes.put(4,225);
		assocColonnes.put(5,300);
		assocColonnes.put(6,375);
		assocColonnes.put(7,450);
		assocColonnes.put(8,525);
		assocColonnes.put(9,600);
		assocColonnes.put(10,675);
		assocColonnes.put(11,750);
		assocColonnes.put(12,825);
	}
	public HashMap<Integer, Integer> getAssocColonnes() {
		return assocColonnes;
	}
	public void setAssocColonnes(HashMap<Integer, Integer> assocColonnes) {
		this.assocColonnes = assocColonnes;
	}

}
