package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

/**
 * 
 * @param <T> elementypen
 */
public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> foerste, siste;

	/**
	 * Lager en ny tom liste.
	 */
	public KjedetOrdnetListe() {
		antall = 0;
		foerste = null;
		siste = null;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = foerste.getElement();
		foerste = foerste.getNeste();
		antall--;
		return resultat;
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = siste.getElement();
		LinearNode<T> node = foerste;
		while(node != null) {
			if(node.equals(siste)) {
				node.setNeste(null);
				siste = node;
			}
			node = node.getNeste();
		}
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T svar = foerste.getElement();

		return svar;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = siste.getElement();

		return resultat;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public void leggTil(T element) {
		LinearNode<T> nyNode = new LinearNode<>(element);
		
		if(erTom())
			foerste = siste = nyNode;
		else {
			
			LinearNode<T> denne = foerste;
			boolean ferdig = false;
			
			if(!(element.compareTo(foerste.getElement()) > 0)) {
				foerste = nyNode;
				foerste.setNeste(denne);
				ferdig = true;
				System.out.println("FØRSTE");
			}
			
			denne = foerste.getNeste();
			LinearNode<T> forrige = denne;

			boolean inserted = false;
			while(denne != null && !inserted) {
						
				System.out.println("HALA");
				
				if(!(element.compareTo(denne.getElement()) > 0)) {
					System.out.println("INSERT");
					forrige.setNeste(nyNode);
					nyNode.setNeste(denne);
				}
				forrige = denne;
				denne = denne.getNeste();
			}
			
		}
		antall++;
			
	}

	@Override
	public T fjern(T element) {
		T svar = null;
		LinearNode<T> forrige = null, denne = foerste;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) { // funnet
			antall--;
			svar = denne.getElement();
			if (forrige == null) { // F�rste element
				foerste = foerste.getNeste();
				if (foerste == null) { // Tom liste
					siste = null;
				}
			} else { // Inni listen eller bak
				forrige.setNeste(denne.getNeste());
				if (denne == siste) { // bak
					siste = forrige;
				}
			}
		} // ikke-funn
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne = foerste;
		boolean resultat = false;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			denne = denne.getNeste();
		}
		if (denne != null) {
			if (element.equals(denne.getElement())) {
				resultat = true;
			}
		} // ikke-funn
		return resultat;
	}
	
	public void visTab() {
		LinearNode<T> node = foerste;
		while(node != null) {
			System.out.println(node.getElement());
			node = node.getNeste();
		}
	}

}// class
