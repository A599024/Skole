package TreeADT;

import java.util.Iterator;

import Node_Hjelp.BinaryNode;

public interface BinarySearchTreeInterface<T extends Comparable<? super T>> extends TreeADTInterface<T> {

	/** sees if anEntry is in the search tree. */
	boolean contains(T anEntry);
	
	/** Gets the entry of the search tree */
	T getEntry(T anEntry);
		
	/** Removes a given entry from the search tree */
	T remove(T anEntry);
	
	/** Returns a inorder iterator. */
	Iterator<T> getInorderIterator();
	
	/** Adds a given entry to the seach tree. */
	T addEntry(T anEntry);
	
	/** OLD METHOD, use other. */
	BinaryNode<T> add(T anEntry);

}
