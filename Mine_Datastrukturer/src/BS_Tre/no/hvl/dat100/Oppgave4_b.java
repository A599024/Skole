package BS_Tre.no.hvl.dat100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class Oppgave4_b {
	
	public static final int TRÆR = 100;
	public static final int NODER = 1023;
	
	public static void main(String[] args) {
		
		HashMap<String, BS_Tre> skogen = new HashMap<>();
		fyllSkog(skogen);
		
		// i
		System.out.println("Antall Noder: " + (TRÆR * NODER) + "." + "\n");
		
		// ii
		System.out.println("Minimale teoretiske høytden: log2n." + "\n");
		
		// iii
		System.out.println("Maksimale teoretiske høyden: (n-1)." + "\n");
		
		// iv
		System.out.println("Minste høyde ila kjøringen: " + minstHoyde(skogen) + "\n");
		
		// v
		System.out.println("Største høyde ila kjøringen: " + maksHoyde(skogen) + "\n");
		
		// vi
		System.out.println("Gjennomsnittshøyde av alle kjøringer: " + snittHoyde(skogen) + "\n");
		
		
	}
	
	
	private static Integer snittHoyde(HashMap<String, BS_Tre> skogen) {
		Integer sum = 0;
		for(int i = 0; i < TRÆR; i++) {
			sum += skogen.get("tre" + i).finnHoyde();
		}
		return (sum / TRÆR);
	}


	private static Integer maksHoyde(HashMap<String, BS_Tre> skogen) {
		List<Integer> tall = new ArrayList<>();
		for(int i = 0; i < TRÆR; i++) {
			tall.add(skogen.get("tre" + i).finnHoyde());
		}
		tall.sort(null);
		return tall.get(TRÆR - 1);
	}


	private static Integer minstHoyde(HashMap<String, BS_Tre> skogen) {
		List<Integer> tall = new ArrayList<>();
		for(int i = 0; i < TRÆR; i++) {
			tall.add(skogen.get("tre" + i).finnHoyde());
		}
		tall.sort(null);
		return tall.get(0);
	}


	public static void fyllSkog(HashMap<String, BS_Tre> skogen) {
		// Oppretter 100 trær til skogen
		for(int i = 0; i < TRÆR; i++) {
			skogen.put("tre" + i , new BS_Tre<>((int) (Math.random() * TRÆR)));
			// Legger til 1023 noder i hvert tre
			for(int j = 0; j < NODER; j++) {
				skogen.get("tre" + i).leggTil((int) (Math.random() * TRÆR));
			}
		}
	}

}
