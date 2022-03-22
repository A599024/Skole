package DobbeltKjedetListe;

public class DobbelKjedetListe<T extends Comparable<T>> {
	
	private DobbelNode<T> forste;
	private DobbelNode<T> siste;
	private int antall;
	
	public DobbelKjedetListe() {
		// this(Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public DobbelKjedetListe(T minVerdi, T maksVerdi) {
		forste = new DobbelNode<>(minVerdi);
		siste = new DobbelNode<>(maksVerdi);
		forste.setNeste(siste);
		siste.setForrige(forste);
		antall = 0;
	}
	
	public void leggTil(T ny) {
		DobbelNode<T> nyNode = new DobbelNode<>(ny);
		DobbelNode<T> aktuell = forste;
		
		while(ny.compareTo(aktuell.getElement()) > 0) {
			aktuell = aktuell.getNeste();
		}
		
		nyNode.setNeste(aktuell);
		nyNode.setForrige(aktuell.getForrige());
		aktuell.getForrige().setNeste(nyNode);
		aktuell.setForrige(nyNode);
		antall++;
	}
	
	public T fjern(T x) {
		if(!fins(x))
			return null;
		
		DobbelNode<T> aktuell = forste;
		while(!aktuell.getElement().equals(x)) {
			aktuell = aktuell.getNeste();
		}
		aktuell.getForrige().setNeste(aktuell.getNeste());
		antall--;
		return x;
	}
	
	public boolean fins(T x) {
		return BinærSøkDobbelNode.binarySearch(antall, x, forste, siste);
	}
	
	public void visListe() {
		DobbelNode<T> node = forste.getNeste();
		String s = "{" + node.getElement().toString();
		node = node.getNeste();
		while(node != siste) {
			s += ", " + node.getElement().toString();
			node = node.getNeste();
		}
		s += "}";
		System.out.println(s);
	}
	
	public int size() {
		return antall;
	}
	
	

}
