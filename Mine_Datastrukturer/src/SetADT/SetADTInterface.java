package SetADT;

import java.util.Iterator;

public interface SetADTInterface<T> {
	
	/**
	 * Adds a new object off the class T to this set,
	 * if it does not exists in the set
	 * 
	 * @param	Element to be added
	 */
	public void add(T element);
	
	/**
	 * Adds all from a given set to this set
	 * 
	 * @param m2 is the set to be added
	 */
	public void addAll(SetADTInterface<T> m2);
	
	/**
	 * @param	Removes and returns a random element from the set
	 * @exception	EmptyCollectionException when the set is empty
	 */
	public T removeRandom();
	
	/**
	 * Removes a given element from the set
	 * 
	 * @param	The element to be removed
	 * @return	the removed element
	 * @exception	EmptyCollectionException when the set is empty
	 */
	public T remove(T element);
	
	/**
	 * @param	m2 is the set to make union with.
	 * @return	The union of set m2 and this set
	 */
	public SetADTInterface<T> union(SetADTInterface<T> m2);
	
	/**
	 * @param	Element to be searched
	 * @return	true if the element is in the set, false if not
	 */
	public boolean contains(T element);
	
	/**
	 * Tests if this set and element contains the same elements
	 * 
	 * @param	m2 is the set to be tested
	 * @return	true if the sets are equals, false if not
	 */
	public boolean equals(Object m2);
	
	/**
	 * Tests if the set is empty
	 * 
	 * @return true if the set is empty, false if not
	 */
	public boolean isEmpty();
	
	/**
	 * Finds the number of elements in the set
	 * 
	 * @return	Number of elements
	 */
	public int size();
	
	/**
	 * Finds the snitt of to sets
	 * 
	 * @param	m2 is the second set
	 * @return	returns a new set that contains the snitt
	 */
	public SetADTInterface<T> snitt(SetADTInterface<T> m2);
	
	/**
	 * 
	 * @param m2
	 * @return
	 */
	public SetADTInterface<T> differens(SetADTInterface<T> m2);
	
	/**
	 * @param	m2 is the second set
	 * @return	true if m2 is a subset of this set, if else false
	 */
	public boolean subset(SetADTInterface<T> m2);
	
	/**
	 * Creates a Iterator object to be used to go trough all elements in the set
	 * 
	 * @return	Iterator object
	 */
	public Iterator<T> iterator();

	/**
	 * A method for inserting a element in a list without
	 * checking if the element already is in the list
	 * useful for inserting, when we know its not duplicate
	 * 
	 * @param el	to be added
	 */
	public void insert(T el);
	
	

} // end Interface
