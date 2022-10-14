package testMorrrrro;

import java.util.Objects;

public class Student {
	
	private int studNr;
	private String navn;
	
	public Student(int studNr, String navn) {
		this.studNr = studNr;
		this.navn = navn;
	}
	
	public static void main(String[] args) {
		
		Student a = new Student(10, "Ole");
		Student b = new Student(10, "Ole");
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		
		
	}

}
