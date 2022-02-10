package QueueADT;

import exceptions.EmptyCollectionException;

public class ArrayQueue<T> implements QueueADTInterface<T> {
	
	private final static int STDK = 100;
	private final static int MAX = 10000;
	private int numberOfElements;
	private int front, back;
	private T[] queue;
	
	
	public ArrayQueue() {
		this(STDK);
	}
	
	public ArrayQueue(int size) {
		if(size() > MAX)
			size = STDK;
		
		queue = (T[]) (new Object[size + 1]);
		numberOfElements = 0;
		
		front = 0;
		back = size;	
	}
	
	
	@Override
	public void inQueue(T el) {
		if(front == ((back + 2) % queue.length))
			extend();
		
		numberOfElements++;
		back = (back + 1) % queue.length;
		queue[back] = el;
	}

	@Override
	public T first() {
		if(isEmpty())
			throw new EmptyCollectionException("Queue");
		
		return queue[front];
	}

	@Override
	public T outQueue() {
		if(isEmpty())
			throw new EmptyCollectionException("Queue");
		
		numberOfElements--;
		T result = queue[front];
		queue[front] = null;
		front = (front + 1) % queue.length;
		return result;
	}

	@Override
	public boolean isEmpty() {
		return (numberOfElements == 0);
	}
	
	public int size() {
		return numberOfElements;
	}
	
	public void extend() {
		T[] newArray = (T[]) (new Object[queue.length * 2]);
		for (int i = 0; i < queue.length && queue[i] != null; i++) {
			newArray[i] = queue[i];
		}
		
		queue = newArray;
	}

}
