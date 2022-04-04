package HeapADT;

public interface MaxHeapInterface<T extends Comparable<? super T>> {
	
	/**
	 * removes the highest value node in the tree
	 * 
	 * @return the highest value element
	 */
	T removeMax();
	
	/**
	 * Finds the highest value node in the tree
	 * 
	 * @return the highest value element
	 */
	T findMax();
	
	/**
	 * Checks if the tree is empty
	 * 
	 * @return true if empty, if else false
	 */
	boolean isEmpty();
	
	/**
	 * Gets the number of nodes in the tree
	 * 
	 * @return number of nodes
	 */
	int getAntall();
	
	/**
	 * Removes every node/ element in the tree
	 */
	void clear();
	
	/**
	 * Adds a new node to the tree
	 * at the right position
	 * 
	 * @param newElement
	 */
	void add(Comparable newElement);

}
