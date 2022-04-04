package DictionaryADT;

public class SortedPair<S, T> {
	
	private S first;
	private T second;
	
	
	public SortedPair(S first, T second) {
		this.first = first;
		this.second = second;
	}


	public S getFirst() {
		return first;
	}


	public void setFirst(S first) {
		this.first = first;
	}


	public T getSecond() {
		return second;
	}


	public void setSecond(T second) {
		this.second = second;
	}
	
	public String toString() {
		return "<" + first + ", " + second + ">";
	}

}
