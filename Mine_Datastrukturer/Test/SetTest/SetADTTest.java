package SetTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import SetADT.SetADTInterface;

public abstract class SetADTTest {

	protected abstract SetADTInterface<Integer> reset();
		
	private SetADTInterface<Integer> set;
	
	private Integer e1 = 1;
	private Integer e2 = 2;
	private Integer e3 = 3;
	private Integer e4 = 4;
	private Integer e5 = 5;
	
	private SetADTInterface<Integer> m1;
	private SetADTInterface<Integer> m2;
	
	
	@BeforeEach
	public void setup() {
		set = reset();
		m1 = reset();
		m2 = reset();
	}
	
	@Test
	public void newIsEmpty() {
		assertTrue(set.isEmpty());
	}
	
	@Test
	public void addaddsize() {
		set.add(e1);
		set.add(e2);
		assertEquals(set.size(), 2);
	}
	
	@Test 
	public void addaddDuplicateSize() {
		set.add(e1);
		set.add(e2);
		set.add(e2);
		assertEquals(set.size(), 2);
	}
	
	@Test
	public void addAll() {
		m1.add(e1);
		m1.add(e2);
		m1.add(e3);
		
		set.addAll(m1);
		assertEquals(set.size(), 3);
	}
	
	@Test
	public void union() {
		m1.add(e1);
		m1.add(e2);
		
		set.add(e3);
		set.add(e4);
		
		SetADTInterface<Integer> union = set.union(m1);
		
		System.out.println(union.size());
		System.out.println(union.getClass());
		
		assertEquals(union.size(), 4);
	}
	
	@Test
	public void snitt() {
		m1.add(e1);
		m1.add(e2);
		m1.add(e3);
		
		set.add(e1);
		set.add(e2);
		
		SetADTInterface<Integer> snitt = set.snitt(m1);
		
		assertEquals(snitt.size(), 2);
	}
	
	
	
	
	
	
}
