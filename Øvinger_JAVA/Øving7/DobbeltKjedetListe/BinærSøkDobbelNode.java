package DobbeltKjedetListe;

public class BinærSøkDobbelNode {

	public static <T extends Comparable<? super T>> boolean binarySearch(int size, T el, DobbelNode<T> forste, DobbelNode<T> siste) {
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
			DobbelNode<T> midNode = aktuell;
			// comparer miderste el
			int result = el.compareTo(midNode.getElement());
			
			if(result == 0) { // basis
				found = true;
			} else if(result < 0) {
				found = binarySearch(mid - 1, el, forste, midNode.getForrige());
			} else {
				found = binarySearch(mid - 1, el, midNode.getNeste(), siste);
			}
		}
		return found;
	}
}
