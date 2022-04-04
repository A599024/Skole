package DictionaryTest;

import DictionaryADT.DictionaryADT;

public class DictionaryTest extends DictionaryADTTest {

	@Override
	protected DictionaryADT<String, Integer> reset() {
		return new DictionaryADT<String, Integer>();
	}

}
