package prove;

public class Tidspunkt extends Bestilling {

	private String dato;
	private String tidspunkt;
	public Tidspunkt(String navn, int kontaktnummer, String adresse, String dato, String tidspunkt) {
		super(navn, kontaktnummer, adresse);
		this.dato = dato;
		this.tidspunkt = tidspunkt;
	}
	
	public void skrivUt() {
		super.skrivUt();
		System.out.println("Dato: " + dato + "\n" + "Tidspunkt: " + tidspunkt + "\n");
	}
	
}
