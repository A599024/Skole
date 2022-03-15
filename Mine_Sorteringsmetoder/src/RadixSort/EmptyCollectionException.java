package RadixSort;

@SuppressWarnings("serial")
public class EmptyCollectionException extends RuntimeException {

	public EmptyCollectionException(String collection) {
		super(" Denne " + collection + " er tom.");
	}
	
}
