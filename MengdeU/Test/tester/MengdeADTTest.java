package tester;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import no.hvl.dat102.mengde.adt.MengdeADT;

public abstract class MengdeADTTest {
	
	protected abstract MengdeADT<Integer> reset();
	
	private MengdeADT<Integer> mengde;
	
	private Integer e1 = 1;
	private Integer e2 = 2;
	private Integer e3 = 3;
	private Integer e4 = 4;
	private Integer e5 = 5;
	
	private MengdeADT<Integer> m1;
	private MengdeADT<Integer> m2;
	
	@BeforeEach
	public void setup() {
		mengde = reset();
		m1 = reset();
		m2 = reset();
	}
	
	@Test
	public void emptyNewStack() {
		assertTrue(mengde.erTom());
	}
	
	
	
	
	
	
	
}
