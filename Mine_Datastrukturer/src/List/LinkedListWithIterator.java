package List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedListWithIterator<T>{

	private List<T> list;
	private int numElements;
	
	
	public LinkedListWithIterator() {
		list = new ArrayList<>();
		numElements = 0;
	}
	
	public void add(T el) {
		list.add(el);
		numElements = 0;
	}
	
	public void remove(T el) {
		list.remove(el);
		numElements--;
	}
	
	public boolean isEmpty() {
		return numElements == 0;
	}
	
	public Iterator<T> getIterator() {
		return list.iterator();	
	}
	
	
}
