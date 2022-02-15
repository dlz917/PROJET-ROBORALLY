package tableau;
import tableau.Lignes;;
public abstract class CaseTableau {

	private final Lignes ligne=Lignes.A;
	private final int colonne=1;
	private boolean occupe=false;
	private boolean laser=false;
	private EtatCase etat;
}