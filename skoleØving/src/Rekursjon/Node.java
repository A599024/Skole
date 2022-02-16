package Rekursjon;

public class Node<T> {
	
	private Node next;
	private T data;
	
	
	public Node() {
		this.next = null;
		this.data = null;
	}
	
	public Node(T dataPortion) {
		this.data = dataPortion;
		
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
