package HeapADT;

public class MaxHeap<T extends Comparable<? super T>> implements MaxHeapInterface {
	
	
	private T[] heap;
	private int antall;
	private static final int STDK = 100;
	
	
	public MaxHeap() {
		this(STDK);
	}
	
	public MaxHeap(int startkapasitet) {
		@SuppressWarnings("unchecked")
		T[] tmp = (T[]) new Comparable[startkapasitet + 1];
		heap = tmp;
		antall = 0;
	}
	
	public MaxHeap(T[] elementer) {
		this(elementer.length);
		antall = elementer.length;
		
		for(int index = 0; index <= antall; index++) {
			heap[index] = elementer[index - 1];
		}
		
		for(int node = antall/2; node > 0; node--) {
			reparerNed(node);
		}
	}
	
	public T findMax() {
		T root = null;
		
		if(!isEmpty())
			root = heap[1];
		
		return root;
	}
	

	public boolean isEmpty() {
		return antall < 1;
	}
	
	
	public int getAntall() {
		return antall;
	}
	
	public void clear() {
		for(int i = 1; i <= antall; i++) {
			heap[i] = null;
		}
		antall = 0;
	}
	
	public void add(Comparable newElement) {
		int newPos = antall + 1;
		int parentNode = newPos / 2;	// This finds the parent node/root
		
		while(parentNode > 0 && newElement.compareTo(heap[parentNode]) > 0) {
			heap[newPos] = heap[parentNode];
			newPos = parentNode;
			parentNode = newPos / 2;			
		}
		
		heap[newPos] = (T) newElement;
		antall++;
	}

	public T removeMax() {
		T root = null;
		
		if(!isEmpty()) {
			root = heap[1];	// Max value
			heap[1] = heap[antall];	// places the smallest element to the root
			antall--;
			reparerNed(1);
		}
		return root;
	}
	
	public void reparerNed(int node) {
		
		boolean ferdig = false;
		
		T valueRoot = heap[node];
		int posLeftChild = 2 * node;
		
		while(!ferdig && hasLeftChild(node)) {
			int posBiggest = posLeftChild;
			int posRightChild = posLeftChild + 1;
			
			if(hasRightChild(node) && heap[posRightChild].compareTo(heap[posLeftChild]) > 0) {
				posBiggest = posRightChild;
			}
			// sammenlikner verdi i roten med størst barn
			if(valueRoot.compareTo(heap[posBiggest]) < 0) {
				heap[node] = heap[posBiggest];
				node = posBiggest;
				posLeftChild = 2 * node;
			} else {
				ferdig = true;
			}
			
		}
		
		heap[node] = valueRoot;
		
		
		
		
	}
	
	
	/*-----------------------------------------*/
	
	private boolean hasLeftChild(int node) {
		return 2 * node <= antall;
	}
	
	private boolean hasRightChild(int node) {
		return 2 * node + 1 <= antall;
	}
	
	/*-----------------------------------------*/
	

}
