package ArvEksempler;

public class MainVehicle {

	public static void main(String[] args) {
		
		Car car = new Car(50, 4);
		car.stop();
		
		Bicycle bike = new Bicycle(10, 2);
		bike.go();
		
		System.out.println(car.getSpeed());
		car.setSpeed(100);
		System.out.println(car.getSpeed());

		System.out.println(bike.getPedals());
		bike.setPedals(2);
		System.out.println(bike.getPedals());
	
	}
	
}
