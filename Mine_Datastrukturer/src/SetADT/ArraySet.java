package SetADT;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Iterator.*;
import java.util.Objects;
import java.util.Random;

import exceptions.EmptyCollectionException;

public class ArraySet<T> implements SetADTInterface<T> {

	private final static int STDK = 100;
	private final static int MAX = 10000; 
	private int numberOfElements;
	private T[] set;
	
	
	public ArraySet() {
		this(STDK);
	}
	
	@SuppressWarnings("unchecked")
	public ArraySet(int size) {
		if(size > MAX)
			return;
		
		set = (T[]) (new Object[STDK]);
		numberOfElements = 0;
	}
	
	@Override
	public void add(T element) {
		if(contains(element)) return;
		
		if(set.length == numberOfElements)
			extend();
		
		set[numberOfElements] = element;
		numberOfElements++;
	}

	@Override
	public void addAll(SetADTInterface<T> m2) {
		Iterator<T> teller = m2.iterator();
		
		while (teller.hasNext()) {
			add(teller.next());
		}
	}

	@Override
	public T removeRandom() {
		Random random = new Random();
		
		if(isEmpty())
			throw new EmptyCollectionException("Set");
		
		int index = random.nextInt(numberOfElements);
		T result = set[index];
		numberOfElements--;
		set[index] = set[numberOfElements];
		set[numberOfElements] = null;
		
		return result;
	}

	@Override
	public T remove(T element) {
		if(isEmpty())
			throw new EmptyCollectionException("Set");
		
		T result = null;
		boolean found = false;
		for (int i = 0; i < set.length && !found; i++) {
			
			if(set[i].equals(element) ) {
				
				result = set[i];
				numberOfElements--;
				set[i] = set[numberOfElements];
				set[numberOfElements] = null;
				found = true;
				
			}
		}
		return result;
	}

	@Override
	public SetADTInterface<T> union(SetADTInterface<T> m2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T element) {
		if(isEmpty()) return false;
		
		boolean found = false;
		for (int i = 0; i < set.length && set[i] != null; i++) {
			if(set[i].equals(element)) {
				found = true;
				break;
			}
		}
		return found;
	}

	@Override
	public boolean isEmpty() {
		return numberOfElements == 0;
	}

	@Override
	public int size() {
		return numberOfElements;
	}

	@Override
	public SetADTInterface<T> snitt(SetADTInterface<T> m2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SetADTInterface<T> differens(SetADTInterface<T> m2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean subset(SetADTInterface<T> m2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayIterator<T>(set, numberOfElements);
	}
	
	public void extend() {
		T[] extended = (T[]) (new Object[set.length * 2]);
		for (int i = 0; i < extended.length && set[i] != null; i++) {
			extended[i] = set[i];
		}
		set = extended;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(set);
		result = prime * result + Objects.hash(numberOfElements);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArraySet m2 = (ArraySet) obj;
		boolean similarSet = false;
		
		if(this.size() != m2.size()) {
			return false;
		} else {
			Iterator<T> teller = m2.iterator();
			
			while(teller.hasNext() && !similarSet) {
				if(!this.contains(teller.next())) {
					similarSet = false;
				}
			}
		}
		return similarSet;		
	}

	/*
	 * For å gjøre union raskere i LinkedSet
	 */
	@Override
	public void insert(T el) {
		// TODO Auto-generated method stub
		
	}
	


}
