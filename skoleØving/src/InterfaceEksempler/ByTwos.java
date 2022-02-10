package InterfaceEksempler;

public class ByTwos implements Series {
	
	int val;
	
	public ByTwos() {
		val = 0;
	}
	
	public int getNext() {
		if(val >= MAX) {
			System.out.println(ERRORMSG);
		} else {
			val += 2;
		}
		return val;
	}
	
}
