package HashingTest;

import org.junit.jupiter.api.BeforeEach;

import DictionaryADT.DictionaryADT;
import Hashing.HashDictionary;

public class HashDictionaryTest extends HashDictionaryADTTest {

	@Override
	protected HashDictionary<String, Integer> reset() {
		return new HashDictionary<String, Integer>();
	}
	
}
