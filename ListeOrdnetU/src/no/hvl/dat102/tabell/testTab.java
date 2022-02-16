package no.hvl.dat102.tabell;

public class testTab {
	
	public static void main(String[] args) {
		
		TabellOrdnetListe<Integer> liste = new TabellOrdnetListe<>();
		liste.leggTil(1);
		liste.leggTil(2);
		liste.leggTil(3);
		liste.leggTil(4);
		liste.leggTil(5);
		liste.leggTil(6);
		
		liste.visTab();
		System.out.println();
		liste.fjern(3);
		liste.visTab();
		
		
		
		
		
	}

}
