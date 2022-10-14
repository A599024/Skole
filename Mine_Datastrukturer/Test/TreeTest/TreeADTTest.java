package TreeTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TreeADT.BinaryTree;
import TreeADT.TreeADTInterface;


public abstract class TreeADTTest {

	protected abstract TreeADTInterface<Integer> reset();
	
	private TreeADTInterface<Integer> tree;
	
	private Integer root = 3;
	private Integer e1 = 1;
	private Integer e2 = 2;
	// 3
	private Integer e4 = 4;
	private Integer e5 = 5;
	
	
	@BeforeEach
	public void setup() {
		tree = new BinaryTree<>(root);
	}
	
	@Test
	public void contains() {
		tree.add(e1);
		tree.add(e2);
		tree.add(e4);
		
		assertTrue(tree.contains(e2));
	}
	
	@Test
	public void notContains() {
		tree.add(e1);
		tree.add(e2);
		tree.add(e4);
		
		assertFalse(tree.contains(e5));
	}
	
	@Test
	public void find() {
		tree.add(e1);
		tree.add(e2);
		tree.add(e4);
		
		assertEquals(e2, tree.find(e2));
	}
	
	@Test
	public void notFind() {
		tree.add(e1);
		tree.add(e2);
		tree.add(e4);
		
		assertEquals(null ,tree.find(e5));
	}
	
	@Test
	public void add() {
		tree.add(e1);
		tree.add(e2);
		
		assertTrue(tree.contains(e1));
		assertTrue(tree.contains(e2));
	}
	
	@Test
	public void height() {
		tree.add(e5);
		tree.add(e4);
		tree.add(e2);
		tree.add(e1);
		
		assertEquals(2, tree.getHeight());
	}
	
	/*
	@Test
	public void inOrden() {
		tree.add(2);
		tree.add(1);
		tree.add(6);
		tree.add(4);
		tree.add(7);
		
		Integer[] tall = {1, 2, 3, 4, 6, 7};
		
		int i = 0;
		Iterator<Integer> it = tree.getInorderIterator();
		while(it.hasNext()) {
			assertEquals(tall[i], );
		}
	}
	
	*/
	
	
}
