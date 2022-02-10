package no.hvl.dat102;

/*
 * FERDIG
 */

public class Film {
	
	private int filmnr;
	private String produsent;
	private String tittel;
	private int år;
	private Sjanger sjanger;
	private String filmselvskap;
	
	
	public Film() {
		
	}
	
	public Film(int filmnr, String produsent, String tittel, int år, Sjanger sjanger, String filmselvskap) {
		this.filmnr = filmnr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.år = år;
		this.sjanger = sjanger;
		this.filmselvskap = filmselvskap;
	}

	public int getFilmnr() {
		return filmnr;
	}

	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}

	public String getProdusent() {
		return produsent;
	}

	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}
	
	public String getTittel() {
		return tittel;
	}
	
	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getÅr() {
		return år;
	}

	public void setÅr(int år) {
		this.år = år;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String getFilmselvskap() {
		return filmselvskap;
	}

	public void setFilmselvskap(String filmselvskap) {
		this.filmselvskap = filmselvskap;
	}
	
	public boolean equals(Film film) {
		return this.getFilmnr() == film.filmnr;
	}
	
	public int hashCode() {
		Integer temp = filmnr;
		return temp.hashCode();
	}

	@Override
	public String toString() {
		return "Film [filmnr=" + filmnr + ", produsent=" + produsent + ", år=" + år + ", sjanger=" + sjanger
				+ ", filmselvskap=" + filmselvskap + "]";
	}
	
	

}
