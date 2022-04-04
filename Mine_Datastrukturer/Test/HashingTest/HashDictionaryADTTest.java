package HashingTest;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Hashing.HashDictionary;

public abstract class HashDictionaryADTTest {

	protected abstract HashDictionary<String, Integer> reset();
	
	private HashDictionary<String, Integer> hash;
	
	private String k1 = "Jan Ove";
	private String k2 = "Kenth Roger";
	private String k3 = "Savannah";
	private String k4 = "MJ";
	
	private Integer v1 = 22;
	private Integer v2 = 19;
	private Integer v3 = 17;
	private Integer v4 = 42;
	// private Integer da2 = 19;

	@BeforeEach
	public void setup() {
		hash = reset();
	}
	
	
	@Test
	public void isEmpty() {
		assertTrue(hash.isEmpty());
	}
	
	@Test
	public void notEmpty() {
		hash.add(k1, v1);
		hash.add(k1, v1);
		
		assertFalse(hash.isEmpty());
	}
	
	@Test
	public void contains() {
		hash.add(k1, v1);
		hash.add(k4, v4);
		hash.add(k3, v3);
		
		assertTrue(hash.contains(k4));
	}
	
	@Test
	public void remove() {
		hash.add(k1, v1);
		hash.remove(k1);
		
		assertTrue(hash.isEmpty());
	}
	
	@Test
	public void getValue() {
		hash.add(k1, v1);
		hash.add(k3, v3);
		hash.add(k2, v2);
		
		assertEquals(v2, hash.getValue(k2));
	}
	
	@Test
	public void getAntall() {
		hash.add(k1, v1);
		hash.add(k3, v3);
		hash.add(k2, v2);
		
		assertEquals(3, hash.getAntall());
	}
	
	@Test
	public void clear() {
		hash.add(k1, v1);
		hash.add(k3, v3);
		hash.add(k2, v2);
		
		hash.clear();
		assertTrue(hash.isEmpty());
	}
	
	@Test
	public void keyIterator() {
		hash.add(k1, v1);
		hash.add(k3, v3);
		hash.add(k2, v2);
		Iterator<String> it = hash.getKeyIterator();
		int el = 0;
		while(it.hasNext()) {
			el++;
			it.next();
		}
		
		assertTrue(el == 3);
	}
	
	@Test
	public void valueIterator() {
		hash.add(k1, v1);
		hash.add(k3, v3);
		hash.add(k2, v2);
		Iterator<Integer> it = hash.getValueIterator();
		int el = 0;
		while(it.hasNext()) {
			el++;
			it.next();
		}
		assertTrue(el == 3);
	}
	
	@Test
	public void expand() {
		hash.add(k1, v1);
		hash.add(k3, v3);
		hash.add(k2, v2);
		
		System.out.println("Antall: " + hash.getAntall());
		System.out.println("Størrelse: " + hash.getStrl());
		hash.expandCapacity();
		System.out.println("Antall etter: " + hash.getAntall());
		System.out.println("Størrelse etter: " + hash.getStrl());
	}


	
}
