package Oppgave4;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class RekursiveFormler {
	
	private static Set<Integer> mengde = new TreeSet<>();
	
	// Oppgave a
	static int sumTall(int n) {
		if(n == 1) {
			return 1;
		}
		return n + sumTall(n-1);
	}
	
	// Oppgave b
	static int finnListe(int n) {
		// mengde = new HashSet<>();
		
		// Basis
		if(n == 1) {
			mengde.add(5);
			return 5;
		}
		if(n == 0) {
			mengde.add(2);
			return 2;
		}
		// Rekursivt
		else {
			mengde.add(5*finnListe((n-1)) - 6*finnListe((n-2)) + 2);
			return 5*finnListe((n-1)) - 6*finnListe((n-2)) + 2;
		}
		
	}
	
	// Oppgave c
	static int fibTall(int n) {
		
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		else {
			return fibTall(n-1) + fibTall(n-2);
		}
	}
	
	// Oppgave d
	static int fibTallIkkeRekursivt(int n) {
		int[] fib = new int[n+1];
		fib[0] = 0;
		fib[1] = 1;
		
		for(int i = 2; i < fib.length; i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		return fib[n];
		
	}
	
	
	public static void main(String[] args) {
		
		// Sum tall 100
		System.out.println(sumTall(100));
		System.out.println();
		
		// Rekke
		finnListe(10);
		Object[] mg = mengde.toArray();
		for(int i = 0; i < 10; i++) {
			System.out.println(mg[i]);
		}
		System.out.println();
		
		// Fibonacci tall
		System.out.println(fibTall(11));
		System.out.println();
		
		// Fibonacci tall ikke Rekursivt
		System.out.println(fibTallIkkeRekursivt(11));
		System.out.println();
	}
}
