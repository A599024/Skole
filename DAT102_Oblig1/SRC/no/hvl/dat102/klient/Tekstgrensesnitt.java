package no.hvl.dat102.klient;

import javax.swing.JOptionPane;
import java.lang.Integer;
import no.hvl.dat102.adt.FilmarkivADT;
import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;

public class Tekstgrensesnitt {

	// lese opplysningene om en FILM fra tastatur
	public Film lesFilm() {
		
		String filmInfo = JOptionPane.showInputDialog("Oppgi film i form" + "\n" + "(filmnr;produsent;tittel;år;sjanger;filmselskap)");
		String[] filmer = filmInfo.split(";");
		
		Sjanger sjanger = null;
		switch(filmer[4]) {
		case "action": sjanger = Sjanger.ACTION; break;
		case "drama": sjanger = Sjanger.DRAMA; break;
		case "history": sjanger = Sjanger.HISTORY; break;
		case "scifi": sjanger = Sjanger.SCIFI; break;
		}
		
		return new Film(Integer.parseInt(filmer[0]), filmer[1], filmer[2], Integer.parseInt(filmer[3]), sjanger, filmer[5]);
		
	}
	
	// vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visFilm(Film film) { 
		film.toString();
	}
	
	// Skrive ut alle Filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {
		Film[] utFilm = filma.soekTittel(delstreng);
		for(int i = 0; i < utFilm.length && utFilm[i] != null; i++) {
			System.out.println(utFilm[i].toString());
		}
	}
	
	// Skriver ut alle Filmer av en produsent / en gruppe
	public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {
		Film[] filmer = filma.soekProdusent(delstreng);
		for(int i = 0; i < filmer.length && filmer[i] != null; i++) {
			System.out.println(filmer[i].toString());
		}
	}
	
	// Skrive ut en enkel statistikk som inneholder antall Filmer totalt
	// og hvor mange det er i hver sjanger
	public void skrivUtStatistikk(FilmarkivADT filma) {
		int antall = filma.antall();
		int action = filma.antall(Sjanger.ACTION);
		int drama = filma.antall(Sjanger.DRAMA);
		int history = filma.antall(Sjanger.HISTORY);
		int scifi = filma.antall(Sjanger.SCIFI);
		
		System.out.println("Antall filmer: " + antall + "\n" + 
							"Antall action: " + action + "\n" +
							"Antall drama: " + drama + "\n" + 
							"Antall history: " + history + "\n" +
							"Antall scifi: " + scifi + "\n" );
	}
	
	
	// ... Ev. andre metoder


}
