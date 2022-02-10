package no.hvl.dat102.klient;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.klient.Tekstgrensesnitt;
import no.hvl.dat102.adt.FilmarkivADT;

public class Meny {
	
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;
	
	public Meny(FilmarkivADT filmarkiv) {
		tekstgr = new Tekstgrensesnitt();
		this.filmarkiv = filmarkiv;
	}
	
	public void start() {
		// legg inn en del filmer
		filmarkiv.leggTilFilm(new Film(1, "Faren din", "film1", 1999, Sjanger.ACTION, "Faren din inc"));
		filmarkiv.leggTilFilm(new Film(3, "Broren din", "film1", 2001, Sjanger.ACTION, "Boren din inc"));
		filmarkiv.leggTilFilm(new Film(2, "Moren din", "film1", 1998, Sjanger.ACTION, "Moren din inc"));
		filmarkiv.leggTilFilm(new Film(4, "Søstra din", "lakserull", 2005, Sjanger.HISTORY, "Søstra din inc"));
		filmarkiv.leggTilFilm(new Film(5, "Sven'o'laii", "film1", 1645, Sjanger.DRAMA, "Svennern inc"));
	
	}

}
