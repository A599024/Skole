package TreeADT;

import Node_Hjelp.BinaryNode;

public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> implements BinarySearchTreeInterface<T> {

	
	public BinarySearchTree() {
		super();
	}
	
	public BinarySearchTree(T root) {
		super();
		setRootNode(new BinaryNode<T>(root));
	}
	
	@Override
	public T getEntry(T anEntry) {
		return getEntry(this.getRootNode(), anEntry);
	}
	
	private T getEntry(BinaryNode<T> bst, T anEntry) {
		
		if(bst == null)
			return null;
		else if(anEntry.equals(bst.getElement()))
			return anEntry;
		else if(anEntry.compareTo(bst.getElement()) < 0)
			return getEntry(bst.getLeft(), anEntry);
		else
			return getEntry(bst.getRight(), anEntry);
		
	}

	@Override
	public T addEntry(T anEntry) {
		return addEntry(this.getRootNode(), anEntry);
	}
	
	private T addEntry(BinaryNode<T> node, T anEntry) {
		// TODO
		return null;
	}
	
	public void setTree(T rootData) {
		throw new UnsupportedOperationException();
	}
	
	public void setTree(T element, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		throw new UnsupportedOperationException();
	}



}
