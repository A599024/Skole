package HeapTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import HeapADT.MaxHeap;
import HeapADT.MaxHeapInterface;

public abstract class HeapADTTest {
	
	protected abstract MaxHeapInterface<Integer> reset();
	
	private MaxHeapInterface<Integer> heap;
	
	private Integer e1 = 1;
	private Integer e2 = 2;
	private Integer e3 = 3;
	private Integer e4 = 4;
	private Integer e5 = 5;
	
	@BeforeEach
	public void setup() {
		heap = reset();
	}
	
	@Test
	public void isEmpty() {
		assertTrue(heap.isEmpty());
	}
	
	@Test
	void getAntall() {
		heap.add(e1);
		heap.add(e2);
		heap.add(e3);
		assertEquals(3, heap.getAntall());
	}
	
	@Test
	public void clear() {
		heap.add(e1);
		heap.add(e2);
		heap.add(e3);
		heap.clear();
		assertTrue(heap.isEmpty());
	}
	
	@Test
	public void add() {
		heap.add(e1);
		assertEquals(1, heap.getAntall());
	}
	
	@Test
	public void findMax() {
		heap.add(e1);
		heap.add(e3);
		heap.add(e5);
		heap.add(e2);
		
		assertEquals(e5, heap.findMax());
	}
	
	@Test
	public void removeMax() {
		heap.add(e1);
		heap.add(e3);
		heap.add(e5);
		heap.add(e2);
		
		assertEquals(e5, heap.removeMax());
		assertEquals(3, heap.getAntall());
	}

}
