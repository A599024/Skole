package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;

public class FilmArkiv2 implements FilmarkivADT {
	
	private Node<Film> firstNode;
	private int numberOfNodes;
	
	
	public FilmArkiv2() {
		firstNode = null;
		numberOfNodes = 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void visFilm(int nr) {
		Node<Film> thisNode = firstNode;
		
		while(thisNode != null) {
			
			if(thisNode.getData().getFilmnr() == nr) {
				
				 System.out.println(thisNode.getData().toString());
				 return;
				
			} // end if
			thisNode = thisNode.getNext();
			
		} // end for
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		Node<Film> newNode = new Node<>(nyFilm);
		newNode.setNext(firstNode);
		firstNode = newNode;
		numberOfNodes++;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean slettFilm(int filmnr) {
		if(firstNode == null) return false;
		
		boolean deleted = false;
		
		Node<Film> thisNode = firstNode;
		Node<Film> forrige = null;
		
		if(thisNode.getData().getFilmnr() == filmnr) {
			firstNode = firstNode.getNext();
			numberOfNodes--;
			return true;
		} // end if
		forrige = thisNode;
		thisNode = thisNode.getNext();
		
		while(thisNode != null) {
			
			if(thisNode.getData().getFilmnr() == filmnr) {
				deleted = true;
				forrige.setNext(thisNode.getNext());
				numberOfNodes--;
			} // end if
			forrige = thisNode;
			thisNode = thisNode.getNext();
		} // end while
		
		return deleted;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Film[] soekTittel(String delstreng) {
		int i = 0;
		Film[] movies = new Film[numberOfNodes];
		Node<Film> thisNode = firstNode;
		
		while(thisNode != null) {
			
			if(thisNode.getData().getTittel().contains(delstreng)) {
				movies[i] = thisNode.getData();
				i++;
			}
			thisNode = thisNode.getNext();
		}
		return movies;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int antall(Sjanger sjanger) {
		int count = 0;
		
		Node<Film> thisNode = firstNode;
		
		while(thisNode != null) {
			
			if(thisNode.getData().getSjanger().equals(sjanger)) {
				count++;
			}
			thisNode = thisNode.getNext();
			
		} // end while
		return count;
	}

	@Override
	public int antall() {
		return numberOfNodes;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		int i = 0;
		Film[] movies = new Film[numberOfNodes];
		Node<Film> thisNode = firstNode;
		
		while(thisNode != null) {
			
			if(thisNode.getData().getProdusent().contains(delstreng)) {
				movies[i] = thisNode.getData();
				i++;
			}
			thisNode = thisNode.getNext();
		}
		return movies;
	}

}
