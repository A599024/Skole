package Oppgave1;

import java.util.Random;

public class Insertion {
	
	private static int n = 100000;
	private static Integer[] tab = new Integer[n];
	private static Integer[] tab2 = new Integer[n];
	private static Integer[] tab3 = new Integer[n];


	
	public static void main(String[] args) {
		
		fyllTab(tab);
		long start = System.currentTimeMillis();
		SorterTabell.sorteringVedInnsetting(tab, n);
		long slutt = System.currentTimeMillis();
		
		System.out.println(Math.abs(start-slutt));
		
		
		fyllTab(tab2);
		long start2 = System.currentTimeMillis();
		SorterTabell.sorteringVedInnsetting2(tab2, n);
		long slutt2 = System.currentTimeMillis();
		
		System.out.println(Math.abs(start2-slutt2));
		
		
		fyllTab(tab3);
		long start3 = System.currentTimeMillis();
		SorterTabell.sorteringVedInnsetting3(tab3, n);
		long slutt3 = System.currentTimeMillis();
		
		System.out.println(Math.abs(start3-slutt3));
		
		
		
		
		
		
	}
	
	public static void fyllTab(Integer[] tab) {
		for(int i = 0; i < n; i++) {
			int random = (int) (Math.random() * n);
			tab[i] = random;
		}
	}
	
	public static void skrivUt(Integer[] tab2) {
		for(int i = 0; i < tab.length;i++) {
			System.out.println(tab[i]);
		}
	}

}
