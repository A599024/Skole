package HeapADT;

public interface PriorityQueueInterface<T extends Comparable<? super T>> {
	
	/**
	 * Adds a element to the queue
	 * 
	 * @param newElement to be added
	 */
	void add(T newElement);
	
	/**
	 * @return the element that was removed
	 */
	T remove();
	
	/**
	 * @return the element in the front of the queue
	 */
	T peek();
	
	/**
	 * @return true if empty, false if else
	 */
	boolean isEmpty();
	
	/**
	 * @return number of elements
	 */
	int antall();
	
	/**
	 * Removes all elements from queue
	 */
	void clear();
	
	

}
