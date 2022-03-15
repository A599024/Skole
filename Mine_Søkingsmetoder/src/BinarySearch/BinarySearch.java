package BinarySearch;

public class BinarySearch {
	
	public static <T extends Comparable<? super T>> boolean binarySearch(T[] a, T element) {
		return binarySearch(a, 0, a.length - 1, element);
	}
	
	public static <T extends Comparable<? super T>> boolean binarySearch(T[] a, int min, int max, T element) {
		boolean found = false;
		if(min > max) {
			// Found the right value, search over
		} else {
			int mid = (min + max) / 2;
			int result = element.compareTo(a[mid]);
			
			if(result == 0) { // basis
				found = true;
			} else if(result < 0) {
				binarySearch(a, min, mid - 1, element);
			} else {
				binarySearch(a, mid + 1, max, element);
			}
		}
		return found;
	}
	
	
	
	

}
