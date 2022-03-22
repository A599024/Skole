package TreeADT;

import java.util.Iterator;

import Node_Hjelp.BinaryNode;
import exceptions.EmptyTreeException;

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
	
	/*
	 * 
	 */
	public void setTree(T rootData) {
		root = new BinaryNode<>(rootData);
	}
	
	/*
	 * 
	 */
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
		// TODO Auto-generated method stub
		return false;
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
		
		// Basis p == null
		if(root.getElement() != null) {
			int comp = element.compareTo(root.getElement());
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
	public Iterator<T> getInordenIterator() {
		// TODO Auto-generated method stub
		return null;
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
		return root.getHeight();
	}

	@Override
	public int getNumberOfNodes() {
		return root.getNumberOfNodes();
	}
}
