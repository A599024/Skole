package OOP;

public class Rekursjon {

	public static int fakultet(int n) {
		if(n < 2)
			return 1;
		else
			return n * fakultet(n-1);
	}
	
	public static void main(String[] args) {
		
		System.out.println(fakultet(4));
		
		boolean funnet = true;
		int a = 0;
		
		if(funnet)
			a = 2;
		else if(!funnet)
			a = 3;
		
		
	}
	
}
