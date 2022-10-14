package GraphTimen;

import QueueADT.QueueADTInterface;
import StackADT.StackADTInterface;

public interface GrafAlgoritmerInterface<T> {
	
	QueueADTInterface<T> breddeForstGjennomgang(T start);
	
	QueueADTInterface<T> dybdeForstGjennomgang(T start);
	
	StackADTInterface<T> topologiskOrdning();
	
	int lengdeKortesteSti(T start, T slutt, StackADTInterface<T> sti);
	
	double billigsteSti(T start, T slutt, StackADTInterface<T> sti);

}
