package no.hvl.dat102.listeklient;

public class test1234 {
	
	public static void main(String[] args) {
		
		Person amund = new Person("Amund", "Bremming", 1999);
		Person p2 = new Person("Amund", "Bremming", 1999);
		
		System.out.println(amund.compareTo(p2));
		
		
	}
}
