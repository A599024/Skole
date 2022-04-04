package Hashing;

import java.util.Iterator;

import exceptions.NoSuchElementException;

public class HashDictionary<K, V> implements DictionaryADTInterface<K, V> {

	private int numElements;
	private static final int STDK = 17;
	
	private ArrayElement<K, V>[] hashArray;
	private int arraySize;
	private static final double MAX_LOADFACTOR = 0.5;
	
	
	public HashDictionary() {
		this(STDK);
	}
	
	public int getStrl() {
		return hashArray.length;
	}
	
	public HashDictionary(int size) {
		
		size = checkCapacity(size);
		numElements = 0;
		arraySize = getNextPrimenumber(size);
		
		@SuppressWarnings("unchecked")
		ArrayElement<K, V>[] temp = new ArrayElement[arraySize];
		hashArray = temp;
	}
	
	@Override
	public V add(K key, V value) {
		
		if((key == null) || (value == null)) {
			throw new IllegalArgumentException("Cannot add null to a dictionary");
		} else {
			V oldValue;	// Value to return
			
			int index = getHashIndex(key);			
			index = probe(index, key, hashArray);
			
			if((hashArray[index] == null) || (hashArray[index].isRemoved())) {
				hashArray[index] = new ArrayElement<>(key, value);
				numElements++;
				oldValue = null;
			} else {	// Key already exists
				oldValue = hashArray[index].getVerdi();
				hashArray[index].setVerdi(value);;
			}
			
			if(toFull())
				expandCapacity();
			
			return oldValue;						
		
		}
		
	}

	@Override
	public V remove(K key) {
		
		V removedValue = null;
		
		int index = getHashIndex(key);
		index = locate(index, key);
		
		if(index != -1) {
			// NB Noden vil være der men markert som fjerna
			removedValue = hashArray[index].getVerdi();
			hashArray[index].setToRemoved();;
			numElements--;
		}
		
		return removedValue;
		
	}

	@Override
	public V getValue(K key) {
		
		V result = null;
		
		int index = getHashIndex(key);
		index = locate(index, key);
		
		if(index != -1) {
			result = hashArray[index].getVerdi();
		}
		
		return result;
	
	}

	@Override
	public boolean contains(K key) {
		return getValue(key) != null;
	}

	@Override
	public Iterator<K> getKeyIterator() {
		return new KeyIterator();
	}

	@Override
	public Iterator<V> getValueIterator() {
		return new ValueIterator();
	}

	@Override
	public boolean isEmpty() {
		return numElements == 0;
	}

	@Override
	public int getAntall() {
		return numElements;
	}

	@Override
	public void clear() {
		for(int index = 0; index < hashArray.length; index++) {
			hashArray[index] = null;
		}
		
		numElements = 0;
		
	}
	
	/*---------------------------------------------------*/
	/*				PRIVATE HJELPEMETODER	   		     */
	/*---------------------------------------------------*/
	
	private boolean toFull() {
		return numElements > MAX_LOADFACTOR * hashArray.length;
	} // end toFull
	
	private int getNextPrimenumber(int size) {
		int num = (size + 1) * 2;
		
		for(int i = 2; i < num; i++) {
			if(num % i == 0) {
				num++;
				i = 2;
			} else {
				continue;
			}
		}
		return num;
	
	} // end getNextPrimenumber
	
	public int checkCapacity(int size) {
		if(size < STDK)
			size = STDK;
		
		return size;
	} // end checkCapacity
			
	private int getHashIndex(K key) {
		int hashIndex = key.hashCode() % hashArray.length;
		
		if(hashIndex < 0)
			hashIndex = hashIndex + hashArray.length;
		
		return hashIndex;
	} // end getHashIndex
	
	private int probe(int index, K key, ArrayElement<K, V>[] array) {
		boolean found = false;
		int availableIndex = -1;

		while (!found && (array[index] != null)) {
			if (array[index].erMed()) {
				if (key.equals(array[index].getKey()))
					found = true; // Key found
				else // Follow probe sequence
					index = (index + 1) % array.length; // Linear probing
			} else // Skip entries that were removed
			{
				// Save index of first location in removed state
				if (availableIndex == -1)
					availableIndex = index;

				index = (index + 1) % array.length; // Linear probing

			}
		}

		if (found || (availableIndex == -1))
			return index; // Index of either key or null
		else
			return availableIndex; // Index of an available location
	} // end probe
	
	private int locate(int index, K key) {
		boolean found = false;
		
		while(!found && hashArray[index] != null) {
			
			if(hashArray[index].erMed() && key.equals(hashArray[index].getKey()))
				found = true;
			else
				index = (index + 1) % hashArray.length;	// Linear probing
		} 
		
		int result = -1;
		if(found)
			result = index;
		
		return result;
	} // end locate
	
	public void expandCapacity() {
		int newSize = getNextPrimenumber(hashArray.length);
		@SuppressWarnings("unchecked")
		ArrayElement<K, V>[] newArray = new ArrayElement[newSize];
		
		KeyIterator keys = new KeyIterator();
		while(keys.hasNext()) {
			
			K nextKey = keys.next();
			V value = getValue(nextKey);			// value from old array
			
			int index = getHashIndex(nextKey);		// gets the hasCode index
			index = probe(index, nextKey, newArray);// uses linear probing if the spot is occupied in the new array
			
			addForExpand(nextKey, value, newArray);
		}
		hashArray = newArray;
		
	}
	
	/*---------------------------------------------------*/

	
	
	
	
	/*---------------------------------------------------*/
	/*				INDRE HJELPEKLASSER				     */
	/*---------------------------------------------------*/
	
	private static class ArrayElement<S, T> {
		
		private S key;
		private T value;
		private Tilstander tilstand;
		
		private enum Tilstander {
			OPPTATT, FJERNA
		}
		
		private ArrayElement(S searchKey, T dataValue) {
			key = searchKey;
			value = dataValue;
			tilstand = Tilstander.OPPTATT;
		}
		
		private S getKey() {
			return key;
		}

		private T getVerdi() {
			return value;
		}

		private void setVerdi(T newValue) {
			value = newValue;
		}

		// Returns true if this entry is currently in the hash table.
		private boolean erMed() {
			return tilstand == Tilstander.OPPTATT;
		}

		// Returns true if this entry has been removed from the hash table.
		private boolean isRemoved() {
			return tilstand == Tilstander.FJERNA;
		}

		// Sets the state of this entry to removed.
		private void setToRemoved() {
			key = null;
			value = null;
			tilstand = Tilstander.FJERNA; // Entry not in use, ie deleted from table
		} 

		private void setToOccupied() {
			tilstand = Tilstander.OPPTATT;
		}
	
	}
	
	/*---------------------------------------------------*/
	
	private class KeyIterator implements Iterator<K> {
		private int currentIndex; // Current position in hash table
		private int numberLeft; // Number of entries left in iteration

		private KeyIterator() {
			currentIndex = 0;
			numberLeft = numElements;
		}

		@Override
		public boolean hasNext() {
			return numberLeft > 0;
		}

		@Override
		public K next() {
			
			K result = null;
			if(!hasNext()) throw new NoSuchElementException();
			
			while(hashArray[currentIndex] == null || hashArray[currentIndex].isRemoved()) {
				currentIndex++;
			}
			
			result = hashArray[currentIndex].getKey();
			numberLeft--;
			currentIndex++;
			
			return result;
			
		}
	}
		
	/*---------------------------------------------------*/
		
	private class ValueIterator implements Iterator<V> {

		private int currentIndex;
		private int numberLeft;
		
		
		public ValueIterator() {
			currentIndex = 0;
			numberLeft = numElements;
		}
		
		@Override
		public boolean hasNext() {
			return numberLeft > 0;
		}

		@Override
		public V next() {
			
			V result;
			if(!hasNext()) throw new NoSuchElementException();
			
			while(hashArray[currentIndex] == null || hashArray[currentIndex].isRemoved()) {
				currentIndex++;
			}
			
			result = hashArray[currentIndex].getVerdi();
			numberLeft--;
			currentIndex++;
			
			return result;
					
		}
				
	}	
	
	/*---------------------------------------------------*/
	/*		private HJELPEMETODE FOR UTVID				 */
	/*---------------------------------------------------*/
	
	private V addForExpand(K key, V value, ArrayElement<K, V>[] array) {
		
		if((key == null) || (value == null)) {
			throw new IllegalArgumentException("Cannot add null to a dictionary");
		} else {
			V oldValue;	// Value to return
			
			int index = getHashIndex(key);
			index = probe(index, key, array);
			
			if((array[index] == null) || (array[index].isRemoved())) {
				array[index] = new ArrayElement<>(key, value);
				oldValue = null;
			} else {	// Key already exists
				oldValue = array[index].getVerdi();
				array[index].setVerdi(value);;
			}
			
			return oldValue;						
		
		}
		
	}
	
	/*---------------------------------------------------*/

}
