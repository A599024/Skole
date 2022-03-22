package TreeADT;

import java.util.Iterator;

import Node_Hjelp.BinaryNode;

public interface TreeADTInterface<T extends Comparable<? super T>> {
	
	
	/**
	 * Searches for a given element in the tree
	 * 
	 * @param element we are searching for
	 * @return true if the element exists, else false
	 */
	boolean contains(T element);
	
	/**
	 * Finds an element in the Tree
	 * 
	 * @param element to be found
	 * @return the element that was searched for, else null
	 */
	T find(T element);
	
	/**
	 * Adds a given element to the Tree
	 * 
	 * @param element to be added
	 * @return the element that was added
	 */
	BinaryNode<T> add(T element);
	
	/**
	 * Removes a given element from the Tree
	 * 
	 * @param element to be removed
	 * @return The removed element
	 */
	T remove(T element);
	
	/**
	 * Iterates the Tree inOrden
	 * 
	 * @return Iterator Object
	 */
	Iterator<T> getInorderIterator();
	
	/**
	 * @return Height of the tree
	 */
	int getHeight();

	/** 
	 * @return Number of nodes
	 */
	int getNumberOfNodes();

	
	

}
