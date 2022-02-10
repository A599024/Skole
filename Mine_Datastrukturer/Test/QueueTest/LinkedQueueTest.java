package QueueTest;

import QueueADT.LinkedQueue;
import QueueADT.QueueADTInterface;

public class LinkedQueueTest extends QueueADTTest {

	@Override
	protected QueueADTInterface<Integer> reset() {
		return new LinkedQueue<Integer>();
	}

}
