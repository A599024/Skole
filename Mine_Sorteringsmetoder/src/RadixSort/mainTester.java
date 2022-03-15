package RadixSort;

import RadixSort.*;

public class mainTester {
	
	private static int n = 20;
	private static int[] tab = new int[n];
	
	
	public static void main(String[] args) {
		
		fyllTab(tab);
		RadixSort.radixSort(tab);
		skrivUt(tab);
	
		
	}
	
	public static void fyllTab(int[] tab) {
		for(int i = 0; i < n; i++) {
			int random = (int) (Math.random() * 435);
			tab[i] = random;
		}
	}
	
	public static void skrivUt(int[] tab2) {
		for(int i = 0; i < tab.length;i++) {
			System.out.println(tab[i]);
		}
	}

}
