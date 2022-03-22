package InsertionSort;

public class InsertionSort {

	/*
	 * I N S E R T I O N	S O R T
	 * 
	 * First we start with the second element
	 * then compare it to the one before(first element)
	 * if its smaller swap, if larger move to right
	 * then we compare the third element to the one before
	 * its smaller, we swap
	 * then we compare it to the first, is it smaller we swap,
	 * else we start witht the fourth element
	 * repeat
	 * 
	 * 
	 * O - N O T A T I O N
	 * 
	 * We shift n-1 times to the left
	 * we compare 1 + 2 + 3 + 4 + ... + (n-1) times = n(n(n-1)/2 = O(n^2)
	 * we swap 1 + 2 + 3 + 4 + ... + (n-1) times = n(n(n-1)/2 = O(n^2)
	 * O(n^2)
	 * 
	 * Smart to use on linked list
	 * we dont hav to shift to right
	 * designed for linked lists
	 * 
	 */
	
	// Sets last to last - 1 if user puts in length as 2.param
	public static <T extends Comparable<? super T>> void sortIterative(T[] a, int n) {
		sortIterative(a, 0, n-1);
	}
	
	// Iterative method
	public static <T extends Comparable<? super T>> void sortIterative(T[] a, int start, int slutt) {
		
		for (int i = start + 1; i <= slutt; i++) {
			T temp = a[i];
			int j = i - 1;
			boolean ferdig = false;
			while (!ferdig && j >= 0) {
				if (temp.compareTo(a[j]) < 0) {
					a[j + 1] = a[j];
					j--;
				} else {
					ferdig = true;
				}
			}
			a[j + 1] = temp;
		}
	}
	
	
	// Sets last to last - 1 if user puts in length as 2.param
	public static <T extends Comparable<? super T>> void sortRecursive(T[] a, int n) {
		sortIterative(a, 0, n-1);
	}
	
	// Recursive method
	public static <T extends Comparable<? super T>> void sortRecursive(T[] a, int first, int last) {
		if(first < last) {
			sortRecursive(a, first, last-1);
			insertInOrder(a[last], a, first, last-1);
		}
	}
	
	public static <T extends Comparable<? super T>> void insertInOrder(T anEntry, T[] a, int first, int last) {
		if(anEntry.compareTo(a[last]) >= 0) {
			a[last + 1] = anEntry;
		}
		else if(first < last) {
			a[last+1] = a[last];
			insertInOrder(anEntry, a, first, last-1);
		}
	}
	
	public static <T extends Comparable<? super T>> void sort2xInsertion(T[] a, int n) {
		
		for (int i = 0 + 2; i <= a.length; i++) {
			T temp = a[i];
			int j = i - 2;
			boolean ferdig = false;
			while (!ferdig && j >= 0) {
				if (temp.compareTo(a[j]) < 0) {
					a[j + 1] = a[j];
					j--;
				} else {
					ferdig = true;
				}
			}
			a[j + 1] = temp;
		}
	}
	
}
