package SetADT;

public class testSnitt {
	
	public static void main(String[] args) {
		
		LinkedSet<Integer> mengde1 = new LinkedSet<Integer>();
		LinkedSet<Integer> mengde2 = new LinkedSet<Integer>();
		
		mengde1.add(1);
		mengde1.add(2);
		mengde1.add(5);
		mengde1.add(6);
		
		mengde2.add(5);
		mengde2.add(6);
		mengde2.add(7);
		mengde2.add(8);
		
		
		
		LinkedSet<Integer> union = (LinkedSet<Integer>) mengde1.union(mengde2);
		// LinkedIterator<Integer> it = (LinkedIterator<Integer>) union.iterator();

		System.out.println(mengde1.contains(2));
		System.out.println(mengde2.contains(5));
		
		System.out.println(union.size());
		
		System.out.println(union.contains(8));
		
		System.out.println("\n\n");
		
		LinkedSet<Integer> snitt = (LinkedSet<Integer>) mengde1.snitt(mengde2);
		
		System.out.println(snitt.size());
		System.out.println(snitt.contains(5));
		System.out.println(snitt.contains(6));
		
		
		
	}
	
}
