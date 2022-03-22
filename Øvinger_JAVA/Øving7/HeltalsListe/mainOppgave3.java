package HeltalsListe;

import java.util.Random;

public class mainOppgave3 {
	
	public static void main(String[] args) {
		int n = 16;
		
		HeltalsListe liste = new HeltalsListe();
		for(int i = 0; i < n; i++) {
			int random = (int) (Math.random() * n);
			liste.leggTilFoerste(random);
		}
		
		HeltalsListe listeSortert = new HeltalsListe();
		for(int i = n; i > 0; i--) {
			listeSortert.leggTilFoerste(i);
		}
		
		System.out.print("[ ");
		liste.skrivUt();
		System.out.println("]" + "\n");
		System.out.print("[ ");
		liste.sort();
		liste.skrivUt();
		System.out.println("]" + "\n");

		System.out.println("Sum: " + liste.sum());
		
		System.out.println("Maks: " + liste.maks());
		
		System.out.println("Er sortert: " + liste.erSortert());
		System.out.println("Er liste 2 sortert: " + listeSortert.erSortert());
		
		System.out.println("Antall: " + liste.antall());
		
		System.out.println("Baklengs: ");
		listeSortert.skrivBaklengs();

		
		
	}

}
