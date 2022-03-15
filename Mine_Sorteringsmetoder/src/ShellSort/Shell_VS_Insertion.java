package ShellSort;

import ShellSort.*;

public class Shell_VS_Insertion {
	
	private static Integer n = 100000;
	private static Integer[] tab1 = new Integer[n];
	private static Integer[] tab2 = new Integer[n];
	
	public static void main(String[] args) {
		
		fyllTab(tab1);
		fyllTab(tab2);
		
		
		System.out.println("S H E L L	S O R T" + "\n");
		long start = System.currentTimeMillis();
		ShellSort.shellSort(tab1);
		long slutt = System.currentTimeMillis();
		long tid = Math.abs(start - slutt);
		System.out.println(" - Tid: " + tid + "\n" + "\n");
		
		
		System.out.println("I N S E R T I O N	S O R T" + "\n");
		long start2 = System.currentTimeMillis();
		InsertionSort.InsertionSort.sortIterative(tab2, n);
		long slutt2 = System.currentTimeMillis();
		long tid2 = Math.abs(start2 - slutt2);
		System.out.println(" - Tid: " + tid2);
	
	
		
	}
	
	public static void fyllTab(Integer[] tab) {
		for(int i = 0; i < n; i++) {
			int random = (int) (Math.random() * n);
			tab[i] = random;
		}
	}
	

}
