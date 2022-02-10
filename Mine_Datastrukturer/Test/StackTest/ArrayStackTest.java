package StackTest;

import StackADT.ArrayStack;
import StackADT.StackADTInterface;

public class ArrayStackTest extends StackADTTest {

	@Override
	protected StackADTInterface<Integer> reset() {
		return new ArrayStack<Integer>();
	}

}
