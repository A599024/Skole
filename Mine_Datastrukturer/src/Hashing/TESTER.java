package Hashing;

import java.util.Iterator;

public class TESTER {

	public static void main(String[] args) {
		
		HashDictionary<String, Integer> alder = new HashDictionary<>();
		
		alder.add("Muttern", 95);
		alder.add("Fattern", 73);
		alder.add("Bikkja", 7);
		
		skriv(alder);
		
		
		
		
		
	}
	
	public static void skriv(HashDictionary<String, Integer> alder) {
		Iterator<String> it = alder.getKeyIterator();
		while(it.hasNext()) {
			String next = it.next();
			System.out.println("<" + next + ", " + alder.getValue(next) + ">");
		}
	}

}
