package InterfaceEksempler;

public interface Series {
	
	int MAX = 10;
	String ERRORMSG = "Cannot go above value: " + MAX;
	
	int getNext();
}
