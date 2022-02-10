package ArvEksempler;

public class Bicycle extends Vehicle {
	
	protected int pedals;
	
	public Bicycle(double speed, int wheels) {
		super(speed, wheels);
		this.pedals = pedals;
	}

	public int getPedals() {
		return pedals;
	}

	public void setPedals(int pedals) {
		this.pedals = pedals;
	}
	
}
