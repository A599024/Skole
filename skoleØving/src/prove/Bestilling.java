package prove;

public class Bestilling {

	private int kontaktnummer;
	private String kundenavn;
	private String adresse;
	
	public Bestilling(String navn, int kontaktnummer, String adresse) {
		this.kundenavn = navn;
		this.kontaktnummer = kontaktnummer;
		this.adresse = adresse;
	}

	public int getKontaktnummer() {
		return kontaktnummer;
	}

	public void setKontaktnummer(int kontaktnummer) {
		this.kontaktnummer = kontaktnummer;
	}

	public String getKundenavn() {
		return kundenavn;
	}

	public void setKundenavn(String kundenavn) {
		this.kundenavn = kundenavn;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public void skrivUt() {
		System.out.println("Navn: " + kundenavn + "\n" + "Nummer: " + kontaktnummer + "\n" + "Adresse: " + adresse + "\n");
	}
	
	
	
	
	
}
