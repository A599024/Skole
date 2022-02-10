package no.hvl.dato100;

public class Ansatt implements Element {
	
	  private int ansNr;
	  private String fornavn;
	  private String etternavn;
	  private double lønn;
	  
	  
	  public Ansatt(int ansNr,        String fornavn,
	                String etternavn, double lønn) {
	    this.ansNr = ansNr;
	    this.fornavn = fornavn;
	    this.etternavn = etternavn;
	    this.lønn = lønn;    
	  }
	  
	  
	 /*
	  * NB! Har ett problem om vi ønsker å sortere elementene. grunnen
	  * er at for eks. 51 og 114 blir sortert som trenger og ikke som tall,
	  * som vil si at 114 kommer først. 
	  */
	 public String nøkkel() {
		 return Integer.toString(ansNr);
	 }
	 
	  public int getAnsNr() {
	    return ansNr;
	  }
	  
	  public void setAnsNr(int ansNr) {
	    this.ansNr = ansNr;
	  }

	  
	  public String getFornavn() {
	    return fornavn;
	  }
	  
	  public void setFornavn(String fornavn) {
	    this.fornavn = fornavn;
	  }

	  
	  public String getEtternavn() {
	    return etternavn;
	  }
	  
	  public void setEtternavn(String etternavn) {
	    this.etternavn = etternavn;
	  }
	  
	  
	  public double getLønn() {
	    return lønn;
	  }
	  
	  public void setLønn(double lønn) {
	    this.lønn = lønn;
	  }
	  
	  
	  public String toString() {
	    return ansNr + ": " + fornavn + " " + etternavn + " - lønn kr. " + lønn;
	  }
}
