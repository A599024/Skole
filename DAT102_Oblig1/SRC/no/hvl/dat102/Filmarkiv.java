package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;
import no.hvl.dat102.Sjanger;

/*
 * FERDIG
 */

public class Filmarkiv implements FilmarkivADT {
	
	private Film[] filmarkiv;
	private int antall;
	private static final int STDK = 40;
	

	public Filmarkiv() {
		this(STDK);
	}
	
	public Filmarkiv(int n) {
		filmarkiv = new Film[n];
		antall = 0;
	}
	
	public void visFilm(int nr) {
		
		for(int i = 0; ( i < filmarkiv.length && filmarkiv[i] != null); i++) {
			if(filmarkiv[i].getFilmnr() == nr) {
				System.out.println("Film spilles:" + "\n" + filmarkiv[i].toString());
				return;
			} // end if
			
		} // end for
		System.out.println("Film nummer finnes ikke i arkivet!");
	}
	
	public void leggTilFilm(Film nyFilm) {
		if(antall == filmarkiv.length)
			utvidTabell();
		
		filmarkiv[antall] = nyFilm;
		antall++;
	}
	
	public boolean slettFilm(int filmnr) {
		for(int i = 0; i < antall; i++) {
			if(filmarkiv[i].getFilmnr() == filmnr) {
				
				antall--;
				filmarkiv[i] = filmarkiv[antall];
				filmarkiv[antall] = null;
				return true;
			
			} // end if
			
		} // end for
		return false;
	}

	public Film[] soekTittel(String delstreng) {
		int lengde = 0;
		for(int i = 0; i < antall; i++) {
			if(filmarkiv[i].getTittel().contains(delstreng)) {
				lengde++;
			} // end if
		} // end for
		
		Film[] filmer = new Film[lengde];
		int p = 0;
		for(int i = 0; i < antall; i++) {
			if(filmarkiv[i].getTittel().contains(delstreng)) {
				filmer[p] = filmarkiv[i];
				p++;
			} // end if
		} // end for
		return filmer;
	}
	
	public int antall(Sjanger sjanger) {
		int sjangere = 0;
		
		for(int i = 0; i < antall; i++) {
			if(filmarkiv[i].getSjanger().equals(sjanger)) {
				sjangere++;
			}
		}
		return sjangere;
	}
	
	public int antall() {
		return antall;
	}
	
	public void utvidTabell() {
		Film[] nyTab = new Film[antall * 2];
		
		for(int i = 0; i < antall && filmarkiv[i] != null; i++) {
			nyTab[i] = filmarkiv[i];
		}
		filmarkiv = nyTab;
	}
	
	@SuppressWarnings("unused")
	private Film[] trimTab(Film[] tab, int n) {
		Film[] nyTab = new Film[n];
		int i = 0;
		while(i < 2) {
			nyTab[i] = tab[i];
			i++;
		}
		return nyTab;
	}
	
	public Film[] soekProdusent(String delstreng) {
		int lengde = 0;
		for(int i = 0; i < antall; i++) {
			if(filmarkiv[i].getProdusent().contains(delstreng)) {
				lengde++;
			} // end if
		} // end for
		
		Film[] filmer = new Film[lengde];
		int p = 0;
		for(int i = 0; i < antall; i++) {
			if(filmarkiv[i].getTittel().contains(delstreng)) {
				filmer[p] = filmarkiv[i];
				p++;
			} // end if
		} // end for
		return filmer;
	}
	
	

}
