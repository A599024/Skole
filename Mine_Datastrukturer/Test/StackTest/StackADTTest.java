package StackTest;

import StackADT.StackADTInterface;
import exceptions.EmptyCollectionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class StackADTTest {
	
	protected abstract StackADTInterface<Integer> reset();
	
	private StackADTInterface<Integer> stack;
	
	private Integer e1 = 1;
	private Integer e2 = 2;
	private Integer e3 = 3;
	private Integer e4 = 4;
	private Integer e5 = 5;
	
	@BeforeEach
	public void setup() {
		stack = reset();
	}
	
	@Test
	public void emptyNewStack() {
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void peek() {
		stack.push(e1);
		stack.push(e2);
		stack.push(e3);
		
		assertEquals(stack.peek(), e3);
	}
	
	@Test
	public void testSize() {
		stack.push(e1);
		stack.push(e2);
		stack.push(e3);
		stack.push(e4);
		stack.push(e5);
		
		assertEquals(stack.size(), 5);
	}
	
	@Test
	public void pushPushPopSize() {
		stack.push(e1);
		stack.push(e2);
		stack.pop();
		
		assertEquals(stack.size(), 1);
	}
	
	@Test
	public void pushPopEmpty() {
		stack.push(e1);
		stack.pop();
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void pushNotEmpty() {
		stack.push(e1);
		assertFalse(stack.isEmpty());
	}
	
	@Test
	public void pushPeekPopIsEmpty() {
		stack.push(e1);
		assertEquals(e1, stack.peek());
		stack.pop();
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void popFromEmptyIsUnderflowed() {
		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			stack.pop();
		});
	}
	
	
	

}
