package exceptions;

@SuppressWarnings("serial")
public class EmptyTreeException extends RuntimeException {
	
	public EmptyTreeException() {
		super(" Dette " + " treet " + " er tom.");
	}
}
