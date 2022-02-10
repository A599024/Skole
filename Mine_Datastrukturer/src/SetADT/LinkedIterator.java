package SetADT;

//****************************************************************

//    Representerer en iterator for en kjedet struktur av noder 
//    kjedet line�rt. 
//****************************************************************
import java.util.Iterator;
import java.util.NoSuchElementException;

import Node_Hjelp.Node;

/**
 * @author ole olsen
 * 
  */

public class LinkedIterator<T> implements Iterator<T> {
	private Node<T> aktuell; // den aktuelle posisjonen.

	/*************************************************************
	 * Lager en iterator (oppramsar)..
	 *************************************************************/
	/**
	 * @param samling
	 */
	public LinkedIterator(Node<T> samling) {
		aktuell = samling;
	}

	/************************************************************
	 * Returnerer sann hvis iteratoren har minst ett element igjen.
	 *************************************************************/
		
	@Override
	public boolean hasNext() {
		return (aktuell != null);
	}

	/*************************************************************
	 * Returnerer neste element hvis det fins.
	 *************************************************************/

	@Override
	public T next() {
		T resultat = null;
		if (!hasNext())
			throw new NoSuchElementException();
		resultat = aktuell.getData();
		aktuell = aktuell.getNext();
		
		return resultat;
	}

	/*************************************************************
	 * Fjern er ikke implementert..
	 *************************************************************/
	@Override
	public void remove() {
		System.out.println("Denne er ikke implementert.");
	}

}
