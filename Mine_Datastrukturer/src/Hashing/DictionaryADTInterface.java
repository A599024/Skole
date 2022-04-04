package Hashing;

import java.util.Iterator;

public interface DictionaryADTInterface<K, V> {

	/**
	 * Adds a given key value pair to the dictionary.
	 * if the value exists, it will be replaced by the new
	 * and the old one will be returned. 
	 *
	 * @param key
	 * @param value
	 * @return	new added element, or the old element. 
	 */
	V add(K key, V value);
	
	/**
	 * @param key to the value to be removed
	 * @return	the remopved key value pair.
	 */
	V remove(K key);
	
	/**
	 * @param key that stores a value
	 * @return the value connected to the key
	 */
	V getValue(K key);
	
	/**
	 * @return true if the element is in the dictionary,
	 * false if else
	 */
	boolean contains(K key);
	
	/**
	 * @return Key iterator
	 */
	Iterator<K> getKeyIterator();
	
	/**
	 * @return Value iterator
	 */
	Iterator<V> getValueIterator();
	
	/**
	 * @return true if empty, false if else.
	 */
	boolean isEmpty();
	
	/**
	 * returns number of elements in the dictionary.
	 */
	int getAntall();
	
	/**
	 * Clears the whole dictionary
	 */
	void clear();
	
}
