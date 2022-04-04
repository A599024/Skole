package HeapTest;

import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import HeapADT.PriorityQueue;

public abstract class PriorityQueueADTTest {
	
	protected abstract PriorityQueue<Integer> reset();
	
	private PriorityQueue<Integer> queue;
	
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
	public void isEmpty() {
		assertTrue(queue.isEmpty());
	}
	
	@Test
	public void notEmpty() {
		queue.add(e1);
		assertFalse(queue.isEmpty());
	}
	
	@Test
	public void remove() {
		queue.add(e1);
		queue.add(e2);
		queue.remove();
		queue.remove();
		
		assertTrue(queue.isEmpty());
	}
	
	@Test
	public void peek() {
		queue.add(e1);
		queue.add(e4);
		queue.add(e2);
		
		assertEquals(e4, queue.peek());
	}
	
	@Test
	public void add() {
		queue.add(e1);
		
		assertFalse(queue.isEmpty());
		assertEquals(e1, queue.peek());
	}
	
	@Test
	public void clear() {
		queue.add(e1);
		queue.add(e3);
		queue.add(e5);
		queue.add(e4);
		queue.add(e2);
		
		assertEquals(5, queue.antall());
		
		queue.clear();
		
		assertTrue(queue.isEmpty());
	}

}
