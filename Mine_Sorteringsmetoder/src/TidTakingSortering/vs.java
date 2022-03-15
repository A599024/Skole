package TidTakingSortering;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class vs {
	
	private static int n = 15000;
	private static Integer[] tab = new Integer[n];
	private static int[] tab2 = new int[n];

	
	public static void main(String[] args) {
		
		List<Long> tider = new ArrayList<>();
		
		// INSERTION
		fyllTab(tab);
		Long startInsert = System.currentTimeMillis();
		InsertionSort.InsertionSort.sortIterative(tab, n);
		Long sluttInsert = System.currentTimeMillis();
		Long tidInsert = Math.abs(startInsert - sluttInsert);
		tider.add(tidInsert);
		
		
		// MERGE
		fyllTab(tab);
		Long startMerge = System.currentTimeMillis();
		MergeSort.MergeSort.mergeSort(tab, n);
		Long sluttMerge = System.currentTimeMillis();
		Long tidMerge = Math.abs(startMerge - sluttMerge);
		tider.add(tidMerge);
		
		
		// QUICK
		fyllTab(tab);
		Long startQuick = System.currentTimeMillis();
		QuickSort.QuickSort.quickSort(tab, n);
		Long sluttQuick = System.currentTimeMillis();
		Long tidQuick = Math.abs(startQuick - sluttQuick);
		tider.add(tidQuick);
		
		
		// RADIX
		fyllTab(tab2);
		Long startRadix = System.currentTimeMillis();
		RadixSort.RadixSort.radixSort(tab2);
		Long sluttRadix = System.currentTimeMillis();
		Long tidRadix = Math.abs(startRadix - sluttRadix);
		tider.add(tidRadix);
		
		
		// SELECTION
		fyllTab(tab);
		Long startSelection = System.currentTimeMillis();
		SelectionSort.SelectionSort.sortIterative(tab, n);
		Long sluttSelection = System.currentTimeMillis();
		Long tidSelection = Math.abs(startSelection - sluttSelection);
		tider.add(tidSelection);
		
		
		// SHELL
		fyllTab(tab);
		Long startShell = System.currentTimeMillis();
		ShellSort.ShellSort.shellSort(tab);
		Long sluttShell = System.currentTimeMillis();
		Long tidShell = Math.abs(startShell - sluttShell);
		tider.add(tidShell);
		
		
		tider.sort(null);
		// PRINT
		for(int i = 0; i < tider.size(); i ++) {

			if(tider.get(i) == tidInsert)
				System.out.println("Insertion sort: " + tidInsert);
			else if(tider.get(i)  == tidMerge)
				System.out.println("Merge sort: " + tidMerge);
			
			else if(tider.get(i)  == tidQuick)
				System.out.println("Quick sort: " + tidQuick);
			
			else if(tider.get(i)  == tidRadix)
				System.out.println("Radix sort: " + tidRadix);
			
			else if(tider.get(i)  == tidSelection)
				System.out.println("Selection sort: " + tidSelection);
			
			else if(tider.get(i)  == tidShell)
				System.out.println("Shell sort: " + tidShell);
	
		}
	}

	
	public static void fyllTab(Integer[] tab) {
		for(int i = 0; i < n; i++) {
			int random = (int) (Math.random() * n);
			tab[i] = random;
		}
	}
	
	public static void fyllTab(int[] tab) {
		for(int i = 0; i < n; i++) {
			int random = (int) (Math.random() * n);
			tab[i] = random;
		}
	}
}
