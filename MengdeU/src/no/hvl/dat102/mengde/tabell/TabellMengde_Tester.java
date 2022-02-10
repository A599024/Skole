package no.hvl.dat102.mengde.tabell;

import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class TabellMengde_Tester {

	public static void main(String[] args) {
		
		TabellMengde<Integer> tab = new TabellMengde<Integer>();
		tab.leggTil(1);
		tab.leggTil(2);
		tab.leggTil(3);
		tab.leggTil(4);
		tab.leggTil(5);
		tab.leggTil(6);
		
		TabellMengde<Integer> tab2 = new TabellMengde<Integer>();
		tab2.leggTil(5);
		tab2.leggTil(2);
		tab2.leggTil(6);
		
//		TabellMengde<Integer> union = (TabellMengde<Integer>) tab.union(tab2);
//		System.out.println(union.antall());
//		
//		TabellMengde<Integer> snitt = (TabellMengde<Integer>) tab.snitt(tab2);
//		System.out.println(snitt.antall());
//		
//		
//		TabellMengde<Integer> diff = (TabellMengde<Integer>) tab.differens(tab2);
//		System.out.println(diff.antall());
//		System.out.println(diff.inneholder(1));
//		System.out.println(diff.inneholder(2));
//		System.out.println(diff.inneholder(3));
			
		System.out.println(tab.undermengde(tab2));
		System.out.println(tab2.undermengde(tab));
		
		
		
	}
	
}
