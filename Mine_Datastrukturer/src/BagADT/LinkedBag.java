package BagADT;

import Node_Hjelp.Node;
import exceptions.EmptyCollectionException;

public class LinkedBag<T> implements BagADTInterface<T> {
	
	private int antall;
	private Node<T> forste;

	public LinkedBag() {
		antall = 0;
		forste = null;
	}

	@Override
	public void add(T el) {
		Node<T> newNode = new Node<T>(el);
		newNode.setNext(forste);
		forste = newNode;
		antall++;

	}

	@Override
	public T remove(T el) {
		T resultat = null;
		if (isEmpty())
			throw new EmptyCollectionException("bag");
		Node<T> node = findNode(el);
		if (node != null) {
			resultat = node.getData();
			T forsteEl = forste.getData();
			node.setData(forsteEl);
			forste = forste.getNext();
			antall--;

		}
		return resultat;
	}

	private Node<T> findNode(T el) {
		boolean funnet = false;
		Node<T> node = null;
		Node<T> aktuell = forste;
		for (int soek = 0; soek < antall && !funnet; soek++) {
			if (aktuell.getData().equals(el)) {
				funnet = true;
				node = aktuell;
			} else {
				aktuell = aktuell.getNext();
			}
		}
		return node;
	}

	@Override
	public boolean contains(T el) {
		boolean funnet = false;
		Node<T> aktuell = forste;
		for (int soek = 0; soek < antall && !funnet; soek++) {
			if (aktuell.getData().equals(el)) {
				funnet = true;
			} else {
				aktuell = aktuell.getNext();
			}
		}
		return funnet;
	}

	@Override
	public void clear() {
		while (!isEmpty()) {
			fjern();
		}
	}

	private void fjern() {
		if (forste != null) {
			forste = forste.getNext(); // Fjerner forste node
			antall--;
		}

	}

	@Override
	public int size() {
		return antall;

	}

	@Override
	public boolean isEmpty() {
		return antall == 0;
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[antall];
		int i = 0;
		Node<T> thisNode = forste;
		while (thisNode != null) {
			array[i] = thisNode.getData();
			i++;
			thisNode = thisNode.getNext();
		}
		return array;
	}

	public void printOut() {
		Node<T> aktuell = forste;
		while (aktuell != null) {
			System.out.println(aktuell.getData());
			aktuell = aktuell.getNext();
		}
	}

	public void skrivnyBag() {
		T[] nyBag = toArray();
		for (T el : nyBag) {
			System.out.println(el);

		}

	}

}// class

