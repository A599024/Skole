package no.hvl.dat102.mengde.klient;

import java.util.Iterator;

import no.hvl.dat102.mengde.adt.MengdeADT;

public class Medlem {
	
	private String navn;	// Unikt
	private MengdeADT<Hobby> hobbyer;
	private int statusIndex;
	
	public Medlem(String navn, MengdeADT<Hobby> hobbyer, int statusIndex) {
		this.navn = navn;
		this.hobbyer = hobbyer;
		this.statusIndex = statusIndex;
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
		Iterator teller = hobbyer.iterator();
		String medlem = "Navn : " + navn + "\n" + "<" + teller.next();
		
		while(teller.hasNext()) {
			Hobby element = (Hobby) teller.next();
			medlem += ", " + element.toString();  
		}
		medlem += ">" + "\n";
		System.out.println(medlem);
	}
	
	public String visHobby() {
		Iterator teller = hobbyer.iterator();
		String medlem = "<" + teller.next();
		
		while(teller.hasNext()) {
			Hobby element = (Hobby) teller.next();
			medlem += ", " + element.toString();  
		}
		medlem += ">";
		return medlem;
	}
	
	
	
	public int getStatusIndex() {
		return statusIndex;
	}

	public void setStatusIndex(int statusIndex) {
		this.statusIndex = statusIndex;
	}

	/**
	 * sjekker om to passer sammen
	 * passer sammen om de har like mengder
	 */
	public boolean passerTil(Medlem medlem2) {
		
		Iterator teller = medlem2.getHobbyer().iterator();
		boolean send = true;

		while (teller.hasNext()) {
			Hobby element = (Hobby) teller.next();
			if (!this.hobbyer.inneholder(element)) {
				send = false;
				break;
			}

		}
		return send;

	}

}
