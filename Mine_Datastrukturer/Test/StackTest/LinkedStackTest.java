package StackTest;

import StackADT.LinkedStack;
import StackADT.StackADTInterface;

public class LinkedStackTest extends StackADTTest {

	@Override
	protected StackADTInterface<Integer> reset() {
		return new LinkedStack<Integer>();
	}

}
