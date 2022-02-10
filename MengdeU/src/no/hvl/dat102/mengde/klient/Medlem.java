package no.hvl.dat102.mengde.klient;

import java.util.Iterator;

import no.hvl.dat102.mengde.adt.MengdeADT;

public class Medlem {
	
	private String navn;	// Unikt
	private MengdeADT<Hobby> hobbyer;
	
	public Medlem(String navn, MengdeADT<Hobby> hobbyer) {
		this.navn = navn;
		this.hobbyer = hobbyer;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public MengdeADT<Hobby> getHobbyer() {
		return hobbyer;
	}

	public void setHobbyer(MengdeADT<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}
	
	public void visMedlem() {
		String medlem = "Navn : " + navn + "\n";
		Iterator teller = hobbyer.iterator();
		
		while(teller.hasNext()) {
			Hobby element = (Hobby) teller.next();
			medlem += element.toString() + "\n";  
		}
		System.out.println(medlem);
	}
	
	/**
	 * sjekker om to passer sammen
	 * passer sammen om de har like mengder
	 */
	public boolean passerTil(Medlem medlem2) {
		// TODO
		return false;
	}

}
