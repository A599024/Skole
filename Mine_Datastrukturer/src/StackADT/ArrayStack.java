package StackADT;

import StackADT.StackADTInterface;
import exceptions.EmptyCollectionException;

public class ArrayStack<T> implements StackADTInterface<T> {
	
	private final static int STDK = 100;
	private final static int MAX = 10000;
	private int topp;
	private T[] stack;
	
	
	public ArrayStack() {
		this(STDK);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int size) {
		if(size > MAX)
			return;
		
		stack = (T[]) (new Object[size]);
		topp = 0;
	}
	
	@Override
	public void push(T element) {
		if(size() == stack.length)
			extend();
		
		stack[topp] = element;
		topp++;
	}
	
	@Override
	public T pop() {
		if(isEmpty())
			throw new EmptyCollectionException("Stack");
			
		topp--;
		T result = stack[topp];
		
		return result;
	}
	
	@Override
	public T peek() {
		if(isEmpty())
			throw new EmptyCollectionException("Queue");
		
		return stack[topp - 1];
	}
	
	@Override
	public boolean isEmpty() {
		return topp == 0;
	}
	
	@Override
	public int size() {
		return topp;
	}
	
	@SuppressWarnings("unchecked")
	public void extend() {
		T[] extendedArray = (T[]) (new Object[size() * 2]);
		
		for(int i = 0; i < stack.length && stack[i] != null; i++) {
			extendedArray[i] = stack[i];
		}
		
		stack = extendedArray;
	}

}
