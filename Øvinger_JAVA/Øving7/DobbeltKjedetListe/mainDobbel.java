package DobbeltKjedetListe;

public class mainDobbel {
	
	public static void main(String[] args) {
		
		DobbelKjedetListe<Integer> tall = new DobbelKjedetListe<>(-99, 99);
		tall.leggTil(1);
		tall.leggTil(4);
		tall.leggTil(3);
		tall.leggTil(2);
		tall.leggTil(5);
		tall.leggTil(6);
		tall.leggTil(7);
		tall.leggTil(8);
		tall.leggTil(9);
		tall.leggTil(10);
		tall.visListe();

		System.out.println(tall.fins(1));

		
//		tall.fjern(3);
//		tall.visListe();
//		System.out.println(tall.size());
		

		
		
	}

	
	
}
