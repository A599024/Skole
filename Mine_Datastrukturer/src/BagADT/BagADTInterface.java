package BagADT;

import exceptions.EmptyCollectionException;

public interface BagADTInterface<T> {
	
	/**
	 * Legger til et nytt element.
	 * 
	 * @param el er objektet som blir lagt til.
	 */
	public void add(T el);
	
	/**
	 * Fjerner en forekomst av el hvis den eksisterer.
	 * 
	 * @param el er objektet som fjernes hvis det eksisterer
	 * @return el er elmentet som fjernes hvis det fins ellers null-referanse
	 * @exception EmptyCollectionException n�r samlingen er tom
	 */
	public T remove(T el);
	
	/**
	 * Teller antall ganger el fins.
	 * 
	 * @param el er objektet som fins
	 * @return Antall ganger el fins i bag'en.
	 */
	// TODO public int hyppighet(T el);

	/**
	 * Unders�ker om bag'en inneholder el.
	 * 
	 * @param el er objektet det s�kes etter
	 * @return sann hvis bag'en inneholder el, ellers usann
	 */
	public boolean contains(T el);
	
	/**
	 * Gir antall elementer i bag'en.
	 * 
	 * @return antall elementer i bag'en
	 */
	public int size();
	
	/**
	 * Unders�ker om bag'en er tom
	 * 
	 * @return Sann hvis bag'en er tom, elelsr usann.
	 */
	public boolean isEmpty();
	
	/**
	 * Gir en tabell av elementen i tabellen.
	 * 
	 * @return en tabell av elementene i tabell'en
	 */
	public T[] toArray();
	
	
	public void clear();
	
	

} // end interface
