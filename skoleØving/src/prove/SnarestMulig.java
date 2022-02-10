package prove;

public class SnarestMulig extends Bestilling {

	private int maxtid;

	public SnarestMulig(String navn, int kontaktnummer, String adresse, int maxtid) {
		super(navn, kontaktnummer, adresse);
		this.maxtid = maxtid;
	}
	
	public void skrivUt() {
		super.skrivUt();
		System.out.println("Maxtid: " + maxtid + "\n");
	}
	
}
