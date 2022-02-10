package BagTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BagADT.BagADTInterface;
import exceptions.EmptyCollectionException;

public abstract class BagADTTest {

	protected abstract BagADTInterface<Integer> reset();
	
	private BagADTInterface<Integer> bag;
	
	private Integer e1 = 1;
	private Integer e2 = 2;
	private Integer e3 = 3;
	private Integer e4 = 4;
	private Integer e5 = 5;
	
	@BeforeEach
	public void setup() {
		bag = reset();
	}
	
	@Test
	public void emptyBagFrom() {
		assertTrue(bag.isEmpty());
	}
	
	@Test
	public void remove() {
		bag.add(e1);
		Integer el = bag.remove(e1);
		assertEquals(el, e1);
	}
	
	@Test
	public void addAndContains() {
		bag.add(e1);
		assertTrue(bag.contains(e1));
	}
	
	@Test
	public void nodeExists() {
		bag.add(e1);
		bag.add(e2);
		bag.add(e3);
		
		assertTrue(bag.contains(e2));
		assertTrue(bag.contains(e3));
	}
	
	@Test
	public void nodeNotExists() {
		bag.add(e1);
		bag.add(e2);
		
		assertFalse(bag.contains(e3));
	}
	
	
	@Test
	public void clearBag() {
		bag.add(e1);
		bag.add(e2);
		bag.add(e3);
		bag.add(e4);
		
		bag.clear();
		assertTrue(bag.isEmpty());
	}
	
	@Test
	public void size() {
		bag.add(e1);
		bag.add(e2);
		bag.add(e3);
		bag.add(e4);
		bag.add(e5);
		
		assertEquals(bag.size(), 5);
	}
	
//	@Test
//	public void toArray() {
//		Object[] inter = new Integer[5];
//		inter[0] = e1;
//		inter[1] = e2;
//		inter[2] = e3;
//		inter[3] = e4;
//		inter[4] = e5;
//		
//		bag.add(e1);
//		bag.add(e2);
//		bag.add(e3);
//		bag.add(e4);
//		bag.add(e5);
//		
//		Object[] bagArray = bag.toArray();
//		
//		for (int i = 0; i < bagArray.length; i++) {
//			assertEquals(inter[i], bagArray[i]);
//		}
//		
//	}
	
	@Test
	public void popFromEmptyIsUnderflowed() {
		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			bag.remove(e1);
		});
	}
	
	
	
}
