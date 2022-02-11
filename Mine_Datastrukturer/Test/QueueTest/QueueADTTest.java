package QueueTest;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import QueueADT.QueueADTInterface;

public abstract class QueueADTTest {

	protected abstract QueueADTInterface<Integer> reset();
	
	private QueueADTInterface<Integer> queue;
	
	private Integer e1 = 1;
	private Integer e2 = 2;
	private Integer e3 = 3;
	private Integer e4 = 4;
	private Integer e5 = 5;
	
	@BeforeEach
	public void setup() {
		queue = reset();
	}
	
	@Test
	public void newIsEmpty() {
		assertTrue(queue.isEmpty());
	}
	
	
}
