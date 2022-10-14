package testMorrrrro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class oppgaveE {
	
	public static void main(String[] args) {
		
		Set<Integer> hash = new HashSet<>();
		Integer[] tab = new Integer[100000];
		
		int tall = 376;
		for(int i = 0; i < 100000; i++) {
			hash.add(tall);
			tab[i] = tall;
			tall = (tall + 45713) % 1000000;
		}
		MergeSort.mergeSort(tab, tab.length-1);
		
		// søk etter 10 000 tilfeldige tall fra 0 - 999999
		// tell hvor mange ganger vi finner tallet vi leter etter
		List<Integer> søkeTall = new ArrayList<>();
		for(int i = 0; i < 10000; i++) {
			int num = (int) (Math.random() * 10000);
			søkeTall.add(num);
		}
		// HASH
		int antFunnetTallHash = 0;
		long startHash = System.currentTimeMillis();
		
		for(int i = 0; i < 10000; i++) {
			boolean finnes = hash.contains(søkeTall.get(i));
			if(finnes)
				antFunnetTallHash++;
		}
		
		long sluttHash = System.currentTimeMillis();
		long tidHash = sluttHash - startHash;
		
		
		
		// BINARY
		int antFunnetTallList = 0;
		long startList = System.currentTimeMillis();
		
		for(int i = 0; i < 10000; i++) {
			boolean finnes = BinarySearch.binarySearch(tab, søkeTall.get(i));
			if(finnes)
				antFunnetTallList++;
		}
		
		long sluttList = System.currentTimeMillis();
		long tidList = sluttList - startList;
		
		
		System.out.println("   HASHSET" + "\n" + "\t" + "- Antall søk funnet = " + antFunnetTallHash +
							"\n" + "\t" + "- Tid: " + tidHash + "\n");
		
		System.out.println("   LIST" + "\n" + "\t" + "- Antall søk funnet = " + antFunnetTallList +
				"\n" + "\t" + "- Tid: " + tidList + "\n");
		
		
		
		
		
		
	}

}
