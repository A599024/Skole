package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import javax.swing.JOptionPane;
import java.lang.Integer;

public class Tekstgrensesnitt {
	
	// Les inn medlem
	public static Medlem lesMedlem() {
		MengdeADT<Hobby> nyttMedlemHobby = new KjedetMengde<>();
		String navn = "";
		
		try {
			int num = Integer.parseInt(JOptionPane.showInputDialog("Angi antall hobbyer"));
			for(int i = 0; i < num; i++) {
				String hobby = JOptionPane.showInputDialog("Angi hobby nummer " + (i+1) + " : ");
				nyttMedlemHobby.leggTil(new Hobby(hobby));
			}

			navn = JOptionPane.showInputDialog("Fornan og etternavn:");
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return new Medlem(navn, nyttMedlemHobby, -1);
		
	}
	
	// skriver ut medlems hobbyer
	public static void skrivHobbyListe(Medlem medlem) {
		medlem.visMedlem();
	}
	
	// Skriver ut oversikt over mnedlemmer som er koblet sammen
	public static void skrivParListe(Datakontakt arkiv) {				
		System.out.println(arkiv.finnAllePartnere());
	}
	
	// Fyller opp arkivet med noen mennesker
	public static void fyllOpp(Datakontakt arkiv) {
		
		// Person 1
		MengdeADT<Hobby> pitbullHobby = new KjedetMengde<>();
		pitbullHobby.leggTil(new Hobby("Synge"));
		pitbullHobby.leggTil(new Hobby("Spise pølser"));
		pitbullHobby.leggTil(new Hobby("Ha på solbriller"));
		pitbullHobby.leggTil(new Hobby("Være skalla"));

		// Person 2
		MengdeADT<Hobby> brittneyHobby = new KjedetMengde<>();
		brittneyHobby.leggTil(new Hobby("Synge"));
		brittneyHobby.leggTil(new Hobby("Spise pølser"));
		brittneyHobby.leggTil(new Hobby("Ha på solbriller"));
		brittneyHobby.leggTil(new Hobby("Være skalla"));

		// Person 3
		MengdeADT<Hobby> barackObamaHobby = new KjedetMengde<>();
		barackObamaHobby.leggTil(new Hobby("Gå tur"));
		barackObamaHobby.leggTil(new Hobby("Musikk"));
		barackObamaHobby.leggTil(new Hobby("Spise mat"));
		barackObamaHobby.leggTil(new Hobby("Trene"));

		// Person 4
		MengdeADT<Hobby> michelleObamaHobby = new KjedetMengde<>();
		michelleObamaHobby.leggTil(new Hobby("Gå tur"));
		michelleObamaHobby.leggTil(new Hobby("Musikk"));
		michelleObamaHobby.leggTil(new Hobby("Spise mat"));
		michelleObamaHobby.leggTil(new Hobby("Trene"));

		// Person 5
		MengdeADT<Hobby> trumpHobby = new KjedetMengde<>();
		trumpHobby.leggTil(new Hobby("Sjefe"));
		trumpHobby.leggTil(new Hobby("Ta solarium"));
		trumpHobby.leggTil(new Hobby("Tweete"));
		trumpHobby.leggTil(new Hobby("Sykle"));

		// Person 6
		MengdeADT<Hobby> ernaHobby = new KjedetMengde<>();
		ernaHobby.leggTil(new Hobby("Trene"));
		ernaHobby.leggTil(new Hobby("Spise kuk"));
		ernaHobby.leggTil(new Hobby("Spise mat"));
		ernaHobby.leggTil(new Hobby("Musikk"));

		// Person 7
		MengdeADT<Hobby> putinHobby = new KjedetMengde<>();
		putinHobby.leggTil(new Hobby("Ukraina"));
		putinHobby.leggTil(new Hobby("Snøscooter"));
		putinHobby.leggTil(new Hobby("Militært utstyr"));
		putinHobby.leggTil(new Hobby("Strikke"));

		// Person 8
		MengdeADT<Hobby> sofieHobby = new KjedetMengde<>();
		sofieHobby.leggTil(new Hobby("Farmen"));
		sofieHobby.leggTil(new Hobby("Lage mat"));
		sofieHobby.leggTil(new Hobby("Influence"));
		sofieHobby.leggTil(new Hobby("Musikk"));

		// Oppretter medlemmer
		Medlem en = new Medlem("Pitbull", pitbullHobby, 1);
		Medlem to = new Medlem("Brittney Spears", brittneyHobby, 0);
		Medlem tre = new Medlem("Barack Obama", barackObamaHobby, 3);
		Medlem fire = new Medlem("Michelle Obama", michelleObamaHobby, 2);
		Medlem fem = new Medlem("Donald Trump", trumpHobby, -1);
		Medlem seks = new Medlem("Erna Solberg", ernaHobby, -1);
		Medlem syv = new Medlem("Putin", putinHobby, -1);
		Medlem åtte = new Medlem("Sofie Elise", sofieHobby, -1);
		
		// legger inn i arkiv
		arkiv.leggTilMedlem(en);
		arkiv.leggTilMedlem(to);
		arkiv.leggTilMedlem(tre);
		arkiv.leggTilMedlem(fire);
		arkiv.leggTilMedlem(fem);
		arkiv.leggTilMedlem(seks);
		arkiv.leggTilMedlem(syv);
		arkiv.leggTilMedlem(åtte);
		
	}
	
	/******************
	 **** M A I N *****
	 ******************/
	public static void main(String[] args) {
		Datakontakt arkiv = new Datakontakt(10);
		
		// Fyller opp arkiv
		fyllOpp(arkiv);
		
		// Viser alle par
		System.out.println("PAR");
		skrivParListe(arkiv);
		System.out.println("--------------");
			
		// Leser inn nytt Medlem
		System.out.println("Nytt Medlem:");
		Medlem nytt = lesMedlem();
		arkiv.leggTilMedlem(nytt);
		
		// Visermedlem
		skrivHobbyListe(nytt);
		System.out.println("--------------");
		
		arkiv.visAlle();
		
		
	}

}
