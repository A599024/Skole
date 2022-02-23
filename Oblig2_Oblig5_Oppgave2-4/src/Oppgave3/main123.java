package Oppgave3;

public class main123 {

	public static void main(String[] args) {
		String ikkePar = "([)";
		String par = "({})";
		String riktig = "(jeg liker is)";
		
		TabellStabel<String> ss = new TabellStabel<>();
		
		System.out.println("Skal være false: " + ss.erBalansert(ikkePar));
		System.out.println("Skal være true: " + ss.erBalansert(par));
		System.out.println("Skal være true: " + ss.erBalansert(riktig));
	}

}
