package TreeADT;

import java.util.Iterator;

import Node_Hjelp.BinaryNode;

public class asjdasd {

	private static BinaryTree<Integer> tre = new BinaryTree<>(3);
	private static BinaryNode<Integer> rot = tre.getRootNode();
	
	public static<T extends Comparable<? super T>> void main(String[] args) {
		
		
		Integer a = 15;
		Integer b = 14;
		
		int c = a.compareTo(b);
		System.out.println(c);
		
		tre.add(2);
		tre.add(1);
		tre.add(6);
		tre.add(7);
		tre.add(4);
		
		InOrden(rot);
		System.out.println();
		PostOrden(rot);
		System.out.println();
		PreOrden(rot);
	}

	
	public static void PostOrden(BinaryNode<Integer> rot) {
		if(rot != null) {
			PostOrden(rot.getLeft());
			PostOrden(rot.getRight());
			System.out.print(rot.getElement() + "  ");
		}
	}
	
	public static void PreOrden(BinaryNode<Integer> rot) {
		if(rot != null) {
			System.out.print(rot.getElement() + "  ");
			PreOrden(rot.getLeft());
			PreOrden(rot.getRight());
		}
	}
	
	public static void InOrden(BinaryNode<Integer> rot) {
		if(rot != null) {
			InOrden(rot.getLeft());
			System.out.print(rot.getElement() + "  ");
			InOrden(rot.getRight());
		}
	}



	
	
}
