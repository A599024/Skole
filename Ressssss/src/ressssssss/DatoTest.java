package ressssssss;

public class DatoTest {

	public static void main(String[] args) {
		
		KlSlett start1 = new KlSlett("12:00");
		KlSlett slutt1 = new KlSlett("13:00");
		
		KlSlett start2 = new KlSlett("12:00");
		KlSlett slutt2 = new KlSlett("14:00");
		
		
		Dato d1 = new Dato("24.04.2021");
		Dato d2 = new Dato("24.04.2021");
		
		Reservasjon res1 = new Reservasjon("Amund", d1, start1, slutt1);
		// Reservasjon res2 = new Reservasjon("Amund", d1, start1, slutt1);

		Reservasjon res2 = new Reservasjon("Åse",  d2, start2, slutt2);
		
		boolean b = res1.kollisjonMed(res2);
		//boolean b = d1.lik(d2);
		
		
		System.out.println(res1.toString() + "\n" + b);
			
	}

}
