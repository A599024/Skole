package OOP;

public class Kalkulator {
	
	private int tall;
	private boolean inputFase;
	private int forrige;
	private char operat;
	private boolean divMedNull = false;
	
	
	public Kalkulator() {
		nullstill();
	}
	
	public void nullstill() {
		tall = 0;
		forrige = 0;
		operat = ' ';
		inputFase = false;
		divMedNull = false;
	}
	
	public void siffer(int n) {
		
		if(inputFase) {
			
			if(tall < 0)
				tall = tall * 10 - n;
			else
				tall = tall * 10 + n;
		}
		else {
			
			forrige = tall;
			tall = n;
			inputFase = true; 
			
		}
		
	}
	
	public void oper(char op) {
		
		if(!inputFase) {
			nullstill();
			return;
		}
		
		if(operat == '+') 
			tall += forrige;
		if(operat == '-')
			tall-= forrige;
		if(operat == '*')
			tall *= forrige;
		if(operat == '/')
			if(tall == 0)
				divMedNull = true;
			else
				tall = forrige / tall;			
		
		operat = op;
		inputFase = false;
		
	}
	
	public void erLik() {
		oper('=');	
	}
	
	public String hentVerdi() {
		String retur = "";
		
		if(divMedNull)
			retur = "Feil, Divisjon med 0";
		else 
			retur = Integer.toString(tall);
		
		return retur;
	}
	
	public void snuFortegn() {
		tall = -tall;
	}
	
	public void dump() {
		String s = "Kalkulator: "
			      + "tall="         + tall
			      + ", forrige="    + forrige
			      + ", inputFase="  + inputFase
			      + ", divMedNull=" + divMedNull
			      + ", operat="     + operat;
			    System.out.println(s);
	}
	
	
}
