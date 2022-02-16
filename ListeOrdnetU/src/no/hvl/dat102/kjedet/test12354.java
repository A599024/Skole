package no.hvl.dat102.kjedet;

public class test12354 {
	
	public static void main(String[] args) {
		
		KjedetOrdnetListe<Integer> liste = new KjedetOrdnetListe<>();
		
//		Integer e0 = 1;
//		Integer e1 = 2;
//		Integer e2 = 3;
//		Integer e3 = 4;
//		Integer e4 = 5;
//		Integer e5 = 6;
//		
//		liste.leggTil(e1);
//		liste.leggTil(e2);
//		liste.leggTil(e5);
//		liste.leggTil(e0);
//		liste.leggTil(e4);
//		liste.leggTil(e3);
		
		liste.visTab();
		
		Integer e3 = 6;
		Integer e2 = 3;
		Integer e4 = 7;
		Integer e5 = 9;
		Integer e6 = 8;

		liste.leggTil(e3);
		liste.leggTil(e2);
		
		liste.leggTil(e4);
		//liste.leggTil(e5);
		// liste.leggTil(e6);
		
		liste.visTab();
		

		
	}

}
