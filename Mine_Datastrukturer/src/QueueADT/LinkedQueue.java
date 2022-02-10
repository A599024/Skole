package QueueADT;

import Node_Hjelp.Node;
import exceptions.EmptyCollectionException;

public class LinkedQueue<T> implements QueueADTInterface<T> {

	private Node<T> front, back;
	private int numberOfNodes;
	
	public LinkedQueue() {
		front = back = null;
		numberOfNodes = 0;
	}

	@Override
	public T first() {
		if(isEmpty())
			throw new EmptyCollectionException("Queue");
		
		T result = front.getData();
		return result;
	}

	@Override
	public T outQueue() {
		if(isEmpty())
			throw new EmptyCollectionException("Queue");
		
		T result = front.getData();
		front = front.getNext();
		numberOfNodes--;
		
		if(front == null)
			back = null;
		
		return result;
	}

	@Override
	public boolean isEmpty() {
		return (numberOfNodes == 0);
	}

	@Override
	public void inQueue(T el) {
		Node<T> newNode = new Node(el);
		
		if(isEmpty()) {
			front = back = newNode;
		}
		else {
			back.setNext(newNode);
			back = newNode; 
		}
	
		numberOfNodes++;
	}

	
	
}
