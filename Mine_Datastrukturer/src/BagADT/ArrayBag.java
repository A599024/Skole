package BagADT;

import exceptions.EmptyCollectionException;

public class ArrayBag<T> implements BagADTInterface<T> {
	
	private static final int STDK = 100; // Standardkapasitet
	private static final int NOT_FOUND = -1;
	private int numElements;
	private T[] bag;

	public ArrayBag() {
		this(STDK);
	}

	public ArrayBag(int start) {
		numElements = 0;
		bag = (T[]) (new Object[start]);
	}

	/**
	 * @return the antall
	 */
	public int getAntall() {
		return numElements;
	}

	/**
	 * @param antall the antall to set
	 */
	public void setAntall(int num) {
		this.numElements = num;
	}

	/**
	 * @return returnerer tabellen
	 */
	public T[] getBag() {
		return bag;
	}

	/**
	 * @param bag the bag to set
	 */
	public void setBag(T[] bag) {
		this.bag = bag;
	}

	@Override
	public void add(T el) {
		if (numElements == bag.length) {
			extend();
		}
		bag[numElements] = el;
		numElements++;
	}

	private void extend() {
		T[] hjelpebag = (T[]) (new Object[2 * bag.length]);
		for (int i = 0; i < bag.length; i++) {
			hjelpebag[i] = bag[i];
		}
		bag = hjelpebag;
	}

	@Override
	public T remove(T el) {
		if (isEmpty())
			throw new EmptyCollectionException("tom bag ");

		boolean funnet = false;
		T svar = null;

		for (int i = 0; (i < numElements && !funnet); i++) {
			if (bag[i].equals(el)) {
				svar = bag[i];
				bag[i] = bag[numElements - 1];
				bag[numElements - 1] = null;
				numElements--;
				funnet = true;
			}
		}
		return svar;

	}

	@Override
	public boolean contains(T el) {
		boolean funnet = false;
		for (int i = 0; (i < numElements) && (!funnet); i++) {
			if (bag[i].equals(el)) {
				funnet = true;
			}
		}
		return (funnet);

	}

	@Override
	public int size() {
		return numElements;
	}

	@Override
	public boolean isEmpty() {
		return numElements == 0;

	}

	@Override
	public T[] toArray() {
		T[] nyBag = (T[]) new Object[numElements];
		for (int i = 0; i < numElements; i++) {
			nyBag[i] = bag[i];
		}
		return nyBag;

	}

	@Override
	public void clear() {
		for (int i = 0; i < bag.length; i++) {
			bag[i] = null;
			numElements = 0;
		}
	}
}

