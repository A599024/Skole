package SetADT;

import java.util.Iterator;
import java.util.Objects;
import Node_Hjelp.Node;
import exceptions.EmptyCollectionException;

public class LinkedSet<T> implements SetADTInterface<T> {

	private int antall;
	private Node<T> start;
	
	
	public LinkedSet() {
		antall = 0;
		start = null;
	}
	
	@Override
	public void add(T element) {
		if(!contains(element)) {
			Node<T> node = new Node<>(element);
			node.setNext(start);
			start = node;
			antall++;
		}
	}

	@Override
	public void addAll(SetADTInterface<T> m2) {
		Iterator<T> iterator = m2.iterator();
		while(iterator.hasNext()) {
			add(iterator.next());
		}
	}

	@Override
	public T removeRandom() {
		return null;
	}

	@Override
	public T remove(T element) {
		if(isEmpty())
			throw new EmptyCollectionException("Set");
		
		T result = null;
		boolean found = false;
		Node<T> denne = start;
		Node<T> forrige = null;
		
		if(denne.getData().equals(element)) {
			start = start.getNext();
			antall--;
			return element;
		}
		
		forrige = denne;
		denne = denne.getNext();
		
		while(denne != null && !found) {
			if(denne.getData().equals(element)) {
				found = true;
				forrige.setNext(denne.getNext());
				antall--;
				result = denne.getData();
			}
			forrige = denne;
			denne = denne.getNext();
		}
		return result;
	}
	
	@Override
	public SetADTInterface<T> union(SetADTInterface<T> m2) {
		SetADTInterface<T> both = new LinkedSet<T>();
		Node<T> thisNode = start;
		T element = null;
	
		while(thisNode != null) {
			((LinkedSet<T>) both).insert(thisNode.getData());
			thisNode = thisNode.getNext();
		}
		
		Iterator<T> iterator = m2.iterator();
		while(iterator.hasNext()) {
			element = iterator.next();
			if(!this.contains(element)) {
				((LinkedSet<T>) both).insert(element);
			}
		}
		
		return both;
	}
	
	@Override
	public void insert(T el) {
		Node<T> node = new Node<>(el);
		node.setNext(start);
		start = node;
		antall++;
	}
	
	@Override
	public boolean contains(T element) {
		boolean found = false;
		Node<T> thisNode = start;
		for (int i = 0; i < antall && !found; i++) {
			if(thisNode.getData().equals(element)) {
				found = true;
			} else {
				thisNode = thisNode.getNext();
			}
		}
		return found;
	}

	@Override
	public boolean isEmpty() {
		return antall == 0 || start == null;
	}

	@Override
	public int size() {
		return antall;
	}

	@Override
	public SetADTInterface<T> snitt(SetADTInterface<T> m2) {
		SetADTInterface<T> intersection = new LinkedSet<T>();
		Node<T> thisNode = start;
		
		while(thisNode != null) {			
			if(!intersection.contains(thisNode.getData()) && m2.contains(thisNode.getData())) {				
				intersection.insert(thisNode.getData());
			}
			thisNode = thisNode.getNext();
		}
		return intersection;
	}

	@Override
	public SetADTInterface<T> differens(SetADTInterface<T> m2) {
		SetADTInterface<T> differensM = new LinkedSet<T>();
		Node<T> denne = start;
		
		while(denne != null) {
			if(!m2.contains(denne.getData())) {
				differensM.add(denne.getData());
			}
			denne = denne.getNext();
		}
		return differensM;
	}

	@Override
	public boolean subset(SetADTInterface<T> m2) {
		Iterator<T> teller = m2.iterator();
		boolean subset = true;
		
		while(teller.hasNext()) {
			T element = teller.next();
			if(!this.contains(element)) {
				subset = false;
				break;
			}
		}
		return subset;
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedIterator<T>(start);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + antall;
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object ny) {

		if (this == ny) {
			return true;
		}
		if (ny == null) {
			return false;
		}
		if (getClass() != ny.getClass()) {
			return false;
		}
		boolean likeMengder = true;
		SetADTInterface<T> m2 = (SetADTInterface<T>) ny;
		if (this.antall != m2.size()) {
			likeMengder = false;
		} else {
			likeMengder = true;
			Iterator<T> teller = m2.iterator();
			while (teller.hasNext() && likeMengder) {
				T element = teller.next();
				if (!this.contains(element)) {
					likeMengder = false;
				}
			}
			return likeMengder;
		}

		return false;
	}
	
	
	

}
