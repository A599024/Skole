package InterfaceEksempler;

abstract class Dog {
	String breed;
	
	public void bark() {
		System.out.println("Bark");
	}
	
	public abstract void poop();
	
}

class Chihuahua extends Dog {
	
	public void poop() {
		System.out.println("Dog pooped!");
	}
}


public class Abstract {

	public static void main(String[] args) {
		
		Chihuahua c = new Chihuahua();
		c.bark();
		c.poop();
		
	}

}
