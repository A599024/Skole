package ArvEksempler;

public class Vehicle {
	
	protected double speed;
	protected int wheels;
	
	public Vehicle(double speed, int wheels) {
		this.speed = speed;
		this.wheels = wheels;
	}
	
	public void go() {
		System.out.println("This vehicle is moving");
	}
	
	public void stop() {
		System.out.println("This vehicle is stopped");
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public void setWheels(int wheels) {
		this.wheels = wheels;
	}
	
	public int getWheels() {
		return wheels;
	}

}
