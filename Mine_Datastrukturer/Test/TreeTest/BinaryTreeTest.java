package TreeTest;

import TreeADT.BinaryTree;
import TreeADT.TreeADTInterface;

public class BinaryTreeTest extends TreeADTTest {

	@Override
	protected TreeADTInterface<Integer> reset() {
		return new BinaryTree<Integer>();
	}

}
