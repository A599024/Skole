package GraphTimen;

import java.util.Iterator;

public interface NodeInterface<T> {
	
	T getObjekt();
	
	void besok();
	
	boolean erBesokt();
	
	boolean koble(NodeInterface<T> sluttnode);
	
	boolean koble(NodeInterface<T> sluttnode, int vekt);
	
	Iterator<NodeInterface<T>> getNaboIterator();
	
	Iterator<NodeInterface<T>> getVektInterface();
	
	boolean harNabo();
	
	NodeInterface<T> getUbesøktNabo();
	
	void setForgjenger(NodeInterface<T> forgjenger);
	
	NodeInterface<T> getForgjenger();
	
	boolean harForgjenger();
	
	/**
	 * Registrerer kostnad til noden (for korteste og billigste sti) 
	 */
	void setKostnad(double nyKostnad);
	
	/**
	 * Henter kostnad av sti fra startnode til noden (for korteste sti og billigste sti)
	 */
	void getKostnad();
	
	

}
