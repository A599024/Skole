package SetADT;

public class test {

	public static void main(String[] args) {
		
		
		ArraySet<Integer> tabSet = new ArraySet<Integer>();
		System.out.println("ArraySet er tom? " + tabSet.isEmpty());
		tabSet.add(1);
		System.out.println("ArraySet størrelse: " + tabSet.size());
		System.out.println("ArraySet er tom? " + tabSet.isEmpty());

		
		System.out.println("\n" + "-----------------------" + "\n");
		
		
		LinkedSet<Integer> tabSet2 = new LinkedSet<Integer>();
		System.out.println("LinkedSet er tom? " + tabSet2.isEmpty());
		tabSet2.add(1);
		System.out.println("LinkedSet størrelse: " + tabSet2.size());
		System.out.println("LinkedSet er tom? " + tabSet2.isEmpty());


	}

}
