package QuickSort;

public class QuickSort {
	
	/*
	 * Q U I C K	S O R T
	 * 
	 * We start by setting a pivot
	 * we use a partition method to get right side with higher
	 * elements than the pivot and left side with lower elements
	 * then when i and j cross we swap pivot with j
	 * 
	 * the quick sort recursive method will call for partition
	 * to split the array up in two, then it will split the two sides
	 * again and again until sorted and then set them all together
	 * 
	 * 
	 * O - N O T A T I O N
	 * 
	 * BEST CASE (partition middle)
	 * Uses partition to go trough the list, O(n) operations
	 * How many times do we split the array (hight of the tree?
	 * n/2/2/2 times -> n/2^k -> n*log2n
	 * O(n*logn)
	 * 
	 * WORST CASE (sorted array)
	 * It wil split the array from index 1 trough last
	 * then 1 trough last
	 * then 2 trough last
	 * and do n , n-1, n-2, n-3 ... n(n+1)/2 operations
	 * So o-notation will be O(n^2);
	 * 
	 * FIX WORST CASE
	 * 1. Select middle element as pivot
	 * 2. select random leement as pivot
	 */
	
	public static final int MIN_SIZE = 5;
	
	public static <T extends Comparable<? super T>> void quickSort(T[] a, int n) {
		quickSort(a, 0, n - 1);
		
	}

	
	// Sorts the array entries from a[first] to a[last] recursively
	public static <T extends Comparable<? super T>> void quickSort(T[] a, int first, int last) {
		if(last - first + 1 >= MIN_SIZE)
		{
			int pivotIndex = partition(a, first, last);
			quickSort(a, first, pivotIndex - 1);
			quickSort(a, pivotIndex + 1, last);
		}
		else
		{
			InsertionSort.InsertionSort.sortIterative(a, first, last);
		}
	}
	
	public static <T extends Comparable<? super T>> int partition(T[] a, int first, int last) {
		int mid = (first + last) / 2;
		sortFirstMidLast(a, first, mid, last);
		
		// Moves pivot next to last place
		swap(a, mid, last - 1);
		int pivotIndex = last - 1;
		T pivotValue = a[pivotIndex];
		
		int fromLeft = first + 1;
		int fromRight = last - 2;
		
		boolean done = false;
		while(!done)
		{
			while(a[fromLeft].compareTo(a[pivotIndex]) < 0)
			{
				fromLeft++;
			}
			
			while(a[fromRight].compareTo(a[pivotIndex]) > 0)
			{
				fromRight--;
			}
			
			if(fromLeft < fromRight)
			{
				swap(a, fromLeft, fromRight);
				fromLeft++;
				fromRight--;
			}
			else
				done = true;
		}
		// Place pivotValue between the subarrays Smaller and Larger
		swap(a, pivotIndex, fromLeft);
		pivotIndex = fromLeft;
		
		return pivotIndex;
	}
	
	public static <T extends Comparable<? super T>> void sortFirstMidLast(T[] a, int first, int mid, int last) {
		order(a, first, mid); // Make a[first] <= a[mid]
		order(a, mid, last); // Make a[mid] <= a[last]
		order(a, first, mid); // Make a[first] <= a[mid]
	}
	
	private static void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static <T extends Comparable<? super T>> void order(T[] a, int i, int j) {
		if (a[i].compareTo(a[j]) > 0)
			swap(a, i, j);
	}

}
