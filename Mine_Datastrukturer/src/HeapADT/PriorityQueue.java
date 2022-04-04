package HeapADT;

public class PriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface {

	private MaxHeapInterface<T> h;
	private int antall = 0; 
	private static final int STDK = 100;
	
	public PriorityQueue() {
		this(100);
	}
	
	@SuppressWarnings("unchecked")
	public PriorityQueue(int size) {
		h = new MaxHeap<>(size);
	}
	
	@Override
	public void add(Comparable newElement) {
		h.add(newElement);
	}

	@Override
	public Comparable remove() {
		return h.removeMax();
	}

	@Override
	public Comparable peek() {
		return h.findMax();
	}

	@Override
	public boolean isEmpty() {
		return h.isEmpty();
	}

	@Override
	public int antall() {
		return h.getAntall();
	}

	@Override
	public void clear() {
		h.clear();
	}

	
	
	
	
	
}
