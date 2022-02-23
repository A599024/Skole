package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		bak--;
		T resultat = liste[bak];
		liste[bak] = null;
		return resultat;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];
		for (int i = 0; i < bak; i++) {
			liste[i] = liste[i+1];
		}
		bak--;
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];
		return resultat;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		return liste[bak-1];
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}

	@Override
	public void leggTil(T element) {
		if(bak == liste.length)
			utvid();
		
		int plass = bak;
		for (int i = 0; i < bak && liste[i] != null; i++) {
			if(!(element.compareTo(liste[i]) > 0)) {
				plass = i;
				for(int j = bak; j > plass; j--) {
					liste[j] = liste[j-1];
				}
				break;
			}
		}
		liste[plass] = element;
		bak++;
		
	}

	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {
		int index = finn(element);
		T resultat = liste[index];
		liste[index] = null;
		
		for(int i = index; i < bak; i++) {
			liste[i] = liste[i+1];
		}
		bak--;
		return resultat;
	}

	private int finn(T el) {
		int i = 0, resultat = IKKE_FUNNET;
		for (int j = 0; j < bak && liste[j] != null; j++) {
			if(liste[j].equals(el)) {
				resultat = j;
			}
		}
		return resultat;
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}

	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++) {
			hjelpeTabell[i] = liste[i];
		}

		liste = hjelpeTabell;
	}
	
	
	public void visTab() {
		for(int i = 0; i < bak; i++) {
			System.out.println(liste[i]);
		}
	}

}// class
