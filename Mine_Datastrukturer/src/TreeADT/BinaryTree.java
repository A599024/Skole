package TreeADT;

import java.util.Iterator;

import Node_Hjelp.BinaryNode;
import StackADT.LinkedStack;
import StackADT.StackADTInterface;
import exceptions.EmptyTreeException;
import exceptions.NoSuchElementException;

public class BinaryTree<T extends Comparable<? super T>> implements TreeADTInterface<T> {

	
	private BinaryNode<T> root;
	
	public BinaryTree() {
		root = null;
	} // default constructor
	
	public BinaryTree(T element) {
		root = new BinaryNode<>(element);
	}
	
	public BinaryTree(T element, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		privateSetTree(element, leftTree, rightTree);
	}
	
	public void setTree(T rootData) {
		root = new BinaryNode<>(rootData);
	}
	
	public void setTree(T element, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		privateSetTree(element, leftTree, rightTree);
	}
	
	private void privateSetTree(T element, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		
		root = new BinaryNode<>(element);
	
		if((leftTree != null) && !leftTree.isEmpty())
			root.setLeft(leftTree.getRootNode());
		
		if((rightTree != null) && !rightTree.isEmpty()) {
			
			if(rightTree != leftTree)
				root.setRight(rightTree.getRootNode());
			else
				root.setRight(rightTree.getRootNode().copy());
		}
		
		if((leftTree != null) && leftTree != this)
			leftTree.clear();
		
		if((rightTree != null) && rightTree != this)
			rightTree.clear();
		
	}
	
	
	@Override
	public boolean contains(T element) {
		if(find(element) == null)
			return false;
		
		return true;
	}

	@Override
	public T find(T element) {
		return find(element, root);
	}
	
	/*********************************
	  	REKURSIV HJELPEMETODE		
	**********************************/
	private T find(T element, BinaryNode<T> p) {
		T result = null;
		
		if(p == null) {
			// basis
		}
		else if(p.getElement() != null) {
			int comp = element.compareTo(p.getElement());
			if(comp == 0)
			{
				result = p.getElement();
			}
			else if(comp < 0)
			{
				result = find(element, p.getLeft());
			}
			else if(comp > 0)
			{
				result = find(element, p.getRight());
			}
		}
		return result;
	}
	

	@Override
	public BinaryNode<T> add(T element) {
		return add(root, element);
	}
	
	/*********************************
  		REKURSIV HJELPEMETODE		
	**********************************/
	private BinaryNode<T> add(BinaryNode<T> p, T element) {
		if(p == null)
		{
			// Rett plass
			return new BinaryNode<>(element);
		}
		else
		{
			if(element.compareTo(p.getElement()) < 0)
			{
				p.setLeft(add(p.getLeft(), element));
			}
			else if(element.compareTo(p.getElement()) > 0)
			{
				p.setRight(add(p.getRight(), element));
			}
		}
		return p;
	}
	

	@Override
	public T remove(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getInorderIterator() {
		return new InorderIterator();
	}
	
	public T getRootData() {
		if(isEmpty())
			throw new EmptyTreeException();
		else
			return root.getElement();
	}
	
	public boolean isEmpty() {
		return root == null;
	}

	public void clear() {
		root = null;
	}
	
	protected void setRootData(T rootData) {
		root.setElement(rootData);
	}
	
	protected void setRootNode(BinaryNode<T> rootNode) {
		root = rootNode;
	}
	
	protected BinaryNode<T> getRootNode() {
		return root;
	}

	@Override
	public int getHeight() {
		return getHeight(root) - 1;
	}
	
	private int getHeight(BinaryNode<T> node) {
		int height = 0;
		
		if(node != null)
			height = 1 + Math.max(getHeight(node.getLeft()),
								  getHeight(node.getRight()));
		
		return height;
	}

	@Override
	public int getNumberOfNodes() {
		return root.getNumberOfNodes();
	}
	
	
	
	
	
	/**********************************
		PRIVAT HJELPEKLASSE
	**********************************/
	private class InorderIterator implements Iterator<T> {

		private StackADTInterface<BinaryNode<T>> nodeStack;
		private BinaryNode<T> currentNode;
		
		public InorderIterator() {
			nodeStack = new LinkedStack<>();
			currentNode = root;
		}

		@Override
		public boolean hasNext() {
			return !nodeStack.isEmpty() || currentNode != null;
		}

		@Override
		public T next() {
			BinaryNode<T> nextNode = null;
			
			while(currentNode != null) {
				nodeStack.push(currentNode);
				currentNode = currentNode.getLeft();
			}
			
			if(!nodeStack.isEmpty()) {
				nextNode = nodeStack.pop();
				assert nextNode != null;
				currentNode = nextNode.getRight();
			}
			else {
				throw new NoSuchElementException();
			}
			return nextNode.getElement();
		}
	}
}
