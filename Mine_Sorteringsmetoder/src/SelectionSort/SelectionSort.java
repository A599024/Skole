package SelectionSort;

public class SelectionSort {
	
	/*
	 * S E L E C T I O N	S O R T
	 * 
	 * Select the shortest item
	 * place the shortest item first and swap the other
	 * then you iterate forward and find the smallest book now
	 * repeat
	 * 
	 * 
	 * O - N O T A T I O N
	 * 
	 * 
	 */
	
	
	// Iterative selection sort
	public static <T extends Comparable<? super T>> void sortIterative(T[] a, int n) {
		// N-1 because the last element will be sorted
		for(int index = 0; index < n-1; index++) {
			int smallestIndex = getSmallestIndex(a, index, n-1);
			swap(a, index, smallestIndex);
		}
		
	}
	
	private static<T extends Comparable<? super T>> int getSmallestIndex(T[] a, int first, int last) {
		T min = a[first];
		int indexOfMin = first;
		
		for(int index = first + 1; index <= last; index++) {
			if(a[index].compareTo(min) < 0) {
				min = a[index];
				indexOfMin = index;
			}
		}
		return indexOfMin;
	}
	
	private static<T extends Comparable<? super T>> void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	
}
