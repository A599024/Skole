package HeapTest;

import HeapADT.MaxHeap;
import HeapADT.MaxHeapInterface;

public class MaxHeapTest extends HeapADTTest {

	@Override
	protected MaxHeapInterface<Integer> reset() {
		return new MaxHeap<Integer>();
	}

}
