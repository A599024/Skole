package SetTest;

import SetADT.LinkedSet;
import SetADT.SetADTInterface;

public class LinkedSetTest extends SetADTTest {

	@Override
	protected SetADTInterface<Integer> reset() {
		return new LinkedSet<Integer>();
	}

}
