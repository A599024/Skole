package testMorrrrro;

public class BinarySearch {
	
	/*
	 * ::::Mulig feil::::
	 * 	found = binarySearch(...)
	 */
	
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
				found = binarySearch(a, min, mid - 1, element);
			} else {
				found = binarySearch(a, mid + 1, max, element);
			}
		}
		return found;
	}
	
	public static <T extends Comparable<? super T>> boolean binaryNode(int size, T el, DobbelNode<T> forste, DobbelNode<T> siste) {
		boolean found = false;
		if(forste.getElement().compareTo(siste.getElement()) > 0) {
			// min > max
			// Found the right value, search over
		} else {
			int mid = size / 2;
			DobbelNode<T> aktuell = forste;
			for(int i = 0; i < mid; i ++) {
				aktuell = aktuell.getNeste();
			}
			// comparer miderste el
			int result = el.compareTo(aktuell.getElement());
			
			if(result == 0) { // basis
				found = true;
			} else if(result < 0) {
			found = binaryNode(mid - 1, el, forste, aktuell);
			} else {
				found = binaryNode(mid + 1, el, aktuell, siste);
			}
		}
		return found;
	}
	
	
	
	

}
