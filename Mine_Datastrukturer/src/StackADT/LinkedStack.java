package StackADT;

import Node_Hjelp.Node;
import exceptions.EmptyCollectionException;

public class LinkedStack<T> implements StackADTInterface<T> {

	private Node<T> start;
	private int numberOfNodes;
	
	
	public LinkedStack() {
		start = null;
		numberOfNodes = 0;
	}
	
	@Override
	public void push(T element) {
		Node<T> newNode = new Node(element);
		newNode.setNext(start);
		start = newNode;
		numberOfNodes++;
	}

	@Override
	public T pop() {
		if(isEmpty())
			throw new EmptyCollectionException("Stack");
		
		T toRemove = start.getData();
		start= start.getNext();
		numberOfNodes--;
		return toRemove;
	}

	@Override
	public T peek() {
		if(isEmpty())
			throw new EmptyCollectionException("Stack");
		
		return start.getData();
	}

	@Override
	public boolean isEmpty() {
		return (numberOfNodes == 0 && start == null);
	}

	@Override
	public int size() {
		return numberOfNodes;
	}

}
