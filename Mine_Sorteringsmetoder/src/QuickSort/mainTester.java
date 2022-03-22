package QuickSort;

import SelectionSort.SelectionSort;

public class mainTester {
	
	private static Integer n = 100000;
	private static Integer[] tab = new Integer[n];
	
	
	public static void main(String[] args) {
		
		fyllTab(tab);
		long start = System.currentTimeMillis();
		SelectionSort.sortIterative(tab, n);
		long slutt = System.currentTimeMillis();
		// skrivUt(tab);
		System.out.println("TID: " + (slutt - start));
	
		
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
