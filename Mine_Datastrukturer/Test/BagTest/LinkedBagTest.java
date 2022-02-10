package BagTest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BagADT.BagADTInterface;
import BagADT.LinkedBag;

public class LinkedBagTest extends BagADTTest {

	@Override
	protected BagADTInterface<Integer> reset() {
		return new LinkedBag<Integer>();
	}
	
//	private LinkedBag<Integer> linkedBag;
//	
//	private Integer e1 = 1;
//	private Integer e2 = 2;
//	private Integer e3 = 3;
//	private Integer e4 = 4;
//	private Integer e5 = 5;
//	
//
//	@BeforeEach
//	public void setup() {
//		linkedBag = (LinkedBag<Integer>) reset();
//	}
//	
//	@Test
//	public void toArray() {
//		Object[] inter = new Integer[5];
//		inter[0] = e1;
//		inter[1] = e2;
//		inter[2] = e3;
//		inter[3] = e4;
//		inter[4] = e5;
//		
//		linkedBag.add(e5);
//		linkedBag.add(e4);
//		linkedBag.add(e3);
//		linkedBag.add(e2);
//		linkedBag.add(e1);
//		
//		Object[] bagArray = linkedBag.toArray();
//		
//		for (int i = 0; i < bagArray.length; i++) {
//			assertEquals(inter[i], bagArray[i]);
//		}
//		
//	}

}
