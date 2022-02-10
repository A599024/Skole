package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class testMain {
	
	public static void main(String[] args) {
		 
		MengdeADT<Hobby> meg = new KjedetMengde<>();
		meg.leggTil(new Hobby("Kode"));
		meg.leggTil(new Hobby("Musikk"));
		meg.leggTil(new Hobby("Spise mat"));
		meg.leggTil(new Hobby("Trene"));
		
		
		MengdeADT<Hobby> mordi = new KjedetMengde<>();
		mordi.leggTil(new Hobby("Kuk"));
		mordi.leggTil(new Hobby("Kode"));
		mordi.leggTil(new Hobby("Spise mat"));
		mordi.leggTil(new Hobby("Spise kuk"));
		
		
		MengdeADT<Hobby> LanaRhoades = new KjedetMengde<>();
		LanaRhoades.leggTil(new Hobby("Trene"));
		LanaRhoades.leggTil(new Hobby("Spise kuk"));
		LanaRhoades.leggTil(new Hobby("Spise mat"));
		LanaRhoades.leggTil(new Hobby("Musikk"));
		
		
		
		Medlem iceT = new Medlem("Ice T", meg);
		Medlem mutter = new Medlem("Mordi", mordi);
		Medlem lana = new Medlem("Lana Rhoades", LanaRhoades);
		
		
		iceT.visMedlem();
		lana.visMedlem();
		mutter.visMedlem();
		
		
		
	}
	

}
