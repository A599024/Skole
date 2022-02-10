package no.hvl.dato100;

public class ToDoElement {
	
	private String beskrivelse;
	  private int nummer;
	  private int prioritet;
	  
	  
	  public ToDoElement(String beskrivelse, int nummer, int prioritet) {
	    this.beskrivelse = beskrivelse;
	    this.nummer = nummer;
	    this.prioritet = prioritet;
	  }
	  
	  public String getBeskrivelse() {
	    return beskrivelse;
	  }
	  
	  public void setBeskrivelse(String nyBeskrivelse) {
	    this.beskrivelse = nyBeskrivelse;
	  }
	  
	  
	  public int getNummer() {
	    return nummer;
	  }
	  
	  public void setNummer(int nyNummer) {
	    this.nummer = nyNummer;
	  }
	  
	  
	  public int getPrioritet() {
	    return prioritet;
	  }
	  
	  public void setPrioritet(int nyPrioritet) {
	    this.prioritet = nyPrioritet;
	  }
	  
	  
	  public String toString() {
	    return beskrivelse + "\n" + "Nummer   : " + nummer + "\n" + "Prioritet: " + prioritet; 
	  }
	  
	
}
