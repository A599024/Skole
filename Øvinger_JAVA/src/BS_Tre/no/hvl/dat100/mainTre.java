package BS_Tre.no.hvl.dat100;

public class mainTre {
	
	public static void main(String[] args) {
		
		BS_Tre<Integer> tre = new BS_Tre<>(10);
		tre.leggTil(7);
		tre.leggTil(17);
		tre.leggTil(5);
		tre.leggTil(9);
		tre.leggTil(13);
		tre.leggTil(19);
		tre.leggTil(1);
		
		// Høyde
		System.out.println(tre.finnHoyde());
		
		
		
	}
}
