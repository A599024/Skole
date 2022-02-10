package QueueTest;

import QueueADT.ArrayQueue;
import QueueADT.QueueADTInterface;

public class ArrayQueueTest extends QueueADTTest {

	@Override
	protected QueueADTInterface<Integer> reset() {
		return new ArrayQueue<Integer>();
	}

}
