package no.hvl.dat102.mengde.kjedet;

import no.hvl.dat102.mengde.tabell.TabellMengde;

public class KjedetMengde_tester {
	
	public static void main(String[] args) {
		
		KjedetMengde<Integer> tab = new KjedetMengde<Integer>();
		tab.leggTil(1);
		tab.leggTil(2);
		tab.leggTil(3);
		tab.leggTil(4);
		tab.leggTil(5);
		tab.leggTil(6);
		
		KjedetMengde<Integer> tab2 = new KjedetMengde<Integer>();
		tab2.leggTil(1);
		tab2.leggTil(2);
		tab2.leggTil(3);
		
//		KjedetMengde<Integer> union = (KjedetMengde<Integer>) tab.union(tab2);
//		System.out.println(union.antall());
//		
//		KjedetMengde<Integer> snitt = (KjedetMengde<Integer>) tab.snitt(tab2);
//		System.out.println(snitt.antall());
//		
//		
//		KjedetMengde<Integer> diff = (KjedetMengde<Integer>) tab.differens(tab2);
//		System.out.println(diff.antall());
//		System.out.println(diff.inneholder(1));
//		System.out.println(diff.inneholder(2));
//		System.out.println(diff.inneholder(3));
		
		System.out.println(tab.undermengde(tab2));
		System.out.println(tab2.undermengde(tab2));
		
	}
	
	
	

}
