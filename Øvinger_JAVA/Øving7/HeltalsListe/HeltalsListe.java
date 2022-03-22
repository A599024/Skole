package HeltalsListe;

import java.util.ArrayList;
import java.util.List;

import QuickSort.*;

public class HeltalsListe {
	
	private HNode start;
	
	
	public HeltalsListe() {
		start = null;
	}
	
	public HeltalsListe(int verdi) {
		start = new HNode(verdi);
	}
	
	public void leggTilFoerste(int verdi) {
		HNode ny = new HNode(verdi);
		ny.setNeste(start);
		start = ny;
	}
	
	public void skrivUt() {
		HNode aktuell = start;
		while(aktuell.getNeste() != null) {
			System.out.print(aktuell.getVerdi() + " ");
			aktuell = aktuell.getNeste();
		}
		System.out.print(aktuell.getVerdi());
	}
	
	public int getStart() {
		return start.getVerdi();
	}
	
	public void sort() {
		
		HeltalsListe sortert = new HeltalsListe();
		List<Object> liste = new ArrayList<>();
		HNode aktuell = start;
		
		while(aktuell.getNeste() != null) {
			liste.add(aktuell.getVerdi());
			aktuell = aktuell.getNeste();
		}
		
		liste.sort(null);
		start.setNeste(null);
		
		for(int i = liste.size() - 1; i >= 0; i--) {
			leggTilFoerste((int) liste.get(i));
		}
	}
	
	/****************************************/
	
	public int antall() {
		return antall(0, start);
	}
	
	private int antall(int ant, HNode node) {
		if(node.getNeste() == null) {
			return ant;
		} else {
			return antall(ant + 1, node.getNeste());
		}
	}
	
	/****************************************/
	
	public int sum() {
		return sum(start);
	}
	
	private int sum(HNode node) {
		
		if(node.getNeste() == null)
			return 0;
		
		return sum(node.getNeste()) + node.getVerdi();
	}
	
	/****************************************/
	
	public int maks() {
		return maks(0, start);
	}
	
	private int maks(int maks, HNode node) {
		
		if(node.getNeste() == null) {
			return maks;
		} else if(node.getVerdi() < maks) {
			return maks(maks, node.getNeste());
		} else {
			return maks(node.getVerdi(), node.getNeste());
		}
	}
	
	/****************************************/
	
	public boolean erSortert() {
		return erSortert(false, start);
	}
	
	private boolean erSortert(boolean res, HNode node) {
		if(node.getNeste() == null && res == false) {
			return false;
		}
		if(node.getNeste() == null && res == true) {
			return true;
		}
		
		if(node.getVerdi() < node.getNeste().getVerdi()) {
			return erSortert(true, node.getNeste());
		} else {
			return false;
		}
		
	}
	
	/****************************************/
	
	public void skrivBaklengs() {
		skrivBaklengs(start);
	}
	
	public void skrivBaklengs(HNode node) {
		if (node == null)
			return;
		else {
			skrivBaklengs(node.getNeste());
			System.out.print(node.getVerdi() + " ");
		}
		
		
	}
	
	/****************************************/

	
}
