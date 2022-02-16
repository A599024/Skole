package no.hvl.dat102.listeklient;

public class Person implements Comparable<Person> {

	private String fornavn;
	private String etternavn;
	private int foedselsaar;

	// Konstrukt�rer

	public Person() {
		this("", "", 0);

	}

	public Person(String fornavn, String etternavn, int foedselsaar) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.foedselsaar = foedselsaar;

	}

	public void setFoedselsaar(int foedselsaar) {
		this.foedselsaar = foedselsaar;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	int getFoedselsaar() {
		return foedselsaar;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public String toString() {
		return (foedselsaar + "\t" + etternavn + ", " + fornavn);
	}

	public int compareTo(Person p2) {
		int resultat = 0;
		if(this.getFoedselsaar() - p2.getFoedselsaar() < 0)
			resultat = -1;
		else if(this.getFoedselsaar() - p2.getFoedselsaar() > 0)
			resultat = 1;
		else
		{
			if(this.getEtternavn().compareTo(p2.getEtternavn()) < 0)
				resultat = -1;
			else if(this.getEtternavn().compareTo(p2.getEtternavn()) > 0)
				resultat = 1;
			else
			{
				if(this.getFornavn().compareTo(p2.getFornavn()) < 0)
					resultat = -1;
				else if(this.getFornavn().compareTo(p2.getFornavn()) > 0)
					resultat = 1;
				else
					resultat = 0;
			} // indre else
		} // ytre else
		return resultat; 
	}//

}// class