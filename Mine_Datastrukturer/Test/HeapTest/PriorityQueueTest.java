package HeapTest;

import HeapADT.PriorityQueue;

public class PriorityQueueTest extends PriorityQueueADTTest {

	@Override
	protected PriorityQueue<Integer> reset() {
		return new PriorityQueue<Integer>();
	}

}
