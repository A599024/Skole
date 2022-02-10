package BagTest;

import BagADT.ArrayBag;
import BagADT.BagADTInterface;

public class ArrayBagTest extends BagADTTest {

	@Override
	protected BagADTInterface<Integer> reset() {
		return new ArrayBag<Integer>();
	}
	
	
	
}
