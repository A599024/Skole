package ressssssss;

public class Reservasjon {
	
	private String navn;
	private Dato dato;
	private KlSlett start, slutt;
	
	public Reservasjon(String navn, Dato dato, KlSlett start, KlSlett slutt) {
		this.navn = navn;
		this.dato = dato;
		this.start = start;
		this.slutt = slutt;
	}
	
	public boolean lovlig() {
		return (start.lovlig() && slutt.lovlig() && dato.lovlig());
	}
	
	public boolean kollisjonMed(Reservasjon r) {
		if (!dato.lik(r.dato))
			return false;
		// return !(slutt.før(r.start) || slutt.lik(r.start) || r.slutt.før(start) || r.slutt.lik(start));
		boolean b = (slutt.før(r.start) || slutt.lik(r.start) || r.slutt.før(start) || r.slutt.lik(start));
		
		return !b;
	}

	@Override
	public String toString() {
		return (navn + " | " + "Dato: " + dato + " | " + "Tid: "+ start + "-" + slutt + ".");
	}
	
	public String toFil() {
		return navn + ";" + dato.toString() + ";" + start.toString() + ";" + slutt.toString();
	}	
	
}
