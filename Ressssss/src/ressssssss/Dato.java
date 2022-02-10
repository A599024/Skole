package ressssssss;

public class Dato {
	
	private int dag, mnd, år;

	public Dato(int dag, int mnd, int år) {
		this.dag = dag;
		this.mnd = mnd;
		this.år = år;
	}
	
	public Dato(String strDato) {
		String[] tab = strDato.split("\\.");
		dag = Integer.parseInt(tab[0]);
		mnd = Integer.parseInt(tab[1]);
		år = Integer.parseInt(tab[2]);
	}
	
	public boolean lik(Dato d) {
		return (dag == d.dag && mnd == d.mnd && år == d.år);
	}
	
	public boolean før(Dato d) {
		String denne = toString();
		String annen = d.toString();
		if (denne.compareTo(annen) < 0)
			return true;
		else
			return false;
	}
	
	public boolean lovlig() {
		// Avgjør om både år, mnd og dag har lovlige verdier
	    boolean okÅr = (1700 <= år && år <= 2099);
	    // Sjekk gjerne hvorfor 1700 er nedre grense
	    boolean okMnd = (1 <= mnd && mnd <= 12);
	    boolean okDag = (1 <= dag && dag <= antallDager(år, mnd) );
	    return okÅr && okMnd && okDag;
	}

	@Override
	public String toString() {
		return dag + "." + mnd + "." + år;
	}
	
	private static int antallDager(int å, int m) {
		int d = 31;
		if(m == 4 || m == 6 || m == 9 || m == 11) {
			d = 30;
		}
		else if(m == 2) {
			d = 29;
		}
		
		if (skuddar(å))
			d = 29;
		else
			d = 28;
		return d;
	}
	
	private static boolean skuddar(int å) {
		return ( (å % 4 == 0 && å % 100 != 0) || (å % 400 == 0) );
	}
		

	public int getDag() {
		return dag;
	}

	public void setDag(int dag) {
		this.dag = dag;
	}

	public int getMnd() {
		return mnd;
	}

	public void setMnd(int mnd) {
		this.mnd = mnd;
	}

	public int getÅr() {
		return år;
	}

	public void setÅr(int år) {
		this.år = år;
	}
	
}
