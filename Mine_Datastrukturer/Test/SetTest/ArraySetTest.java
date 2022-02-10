package SetTest;

import SetADT.ArraySet;
import SetADT.SetADTInterface;

public class ArraySetTest extends SetADTTest {

	@Override
	protected SetADTInterface<Integer> reset() {
		return new ArraySet<Integer>();
	}

}
