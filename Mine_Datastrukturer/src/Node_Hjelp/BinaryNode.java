package Node_Hjelp;

public class BinaryNode<T> {

	private T element; 
	private BinaryNode<T> left;
	private BinaryNode<T> right;
	
	
	public BinaryNode(T el) {
		element = el;
		left = null;
		right = null;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public BinaryNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryNode<T> left) {
		this.left = left;
	}

	public BinaryNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryNode<T> right) {
		this.right = right;
	}
	
	public BinaryNode<T> copy() {
		BinaryNode<T> newRoot = new BinaryNode<>(element);
		
		if(left != null)
			newRoot.setLeft(left.copy());
		
		if(right != null)
			newRoot.setRight(right.copy());
		
		return newRoot;
			
	}
	
	public int getHeight() {
		return getHeight(this);
	}
	
	private int getHeight(BinaryNode<T> node) {
		int height = 0;
		if(node != null)
			height = 1 + Math.max(getHeight(node.getLeft()),
								  getHeight(node.getRight()));
		
		return height;
	}
	
	public int getNumberOfNodes() {
		int leftNum = 0;
		int rightNum = 0;
		
		if(left != null)
			leftNum = left.getNumberOfNodes();
		
		if(right != null)
			rightNum = right.getNumberOfNodes();
		
		return 1 + leftNum + rightNum;
	}
	
	
	
}
