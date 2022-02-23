package tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
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
	private Integer e6 = 6;
	
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
	
	@Test
	public void unionTest() {
        m1.leggTil(e1);
        m1.leggTil(e2);
        m1.leggTil(e3);
        
        mengde.leggTil(e4);
        mengde.leggTil(e5);
        mengde.leggTil(e6);
        
        MengdeADT<Integer> union = mengde.union(m1);
        assertEquals(union.antall(), 6);
        
        assertTrue(union.inneholder(e1));
        assertTrue(union.inneholder(e2));
        assertTrue(union.inneholder(e3));
        assertTrue(union.inneholder(e4));
        assertTrue(union.inneholder(e5));
        assertTrue(union.inneholder(e6));
    }
	
	
	
	
	
	
	
}
