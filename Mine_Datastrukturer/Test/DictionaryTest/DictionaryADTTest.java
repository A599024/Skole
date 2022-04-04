package DictionaryTest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import DictionaryADT.DictionaryADT;

public abstract class DictionaryADTTest {

	protected abstract DictionaryADT<String, Integer> reset();
	
	private DictionaryADT<String, Integer> dict;
	
	private Integer a1 = 22;
	private Integer a2 = 19;
	private Integer a3 = 17;
	private Integer a4 = 42;
	// private Integer da2 = 19;

	private String n1 = "";
	private String n2 = "";
	private String n3 = "";
	private String n4 = "";
	
	
	@BeforeEach
	public void setup() {
		dict = new DictionaryADT<>();
	}
	
	@Test
	public void isEmpty() {
		dict.isEmpty();
	}
	
	
	
}
