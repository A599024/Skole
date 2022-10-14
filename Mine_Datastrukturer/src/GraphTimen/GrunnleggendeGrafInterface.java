package GraphTimen;

public interface GrunnleggendeGrafInterface<T> {

	boolean leggTilNode(T node);
	
	boolean leggTilKant(T fra, T til);
	
	boolean leggTilKant(T fra, T til, double vekt);
	
	boolean harKant(T fra, T til);
	
	boolean erTom();
	
	int antallNoder();
	
	int antallKanter();
	
	void toem();
	
	
	
}
