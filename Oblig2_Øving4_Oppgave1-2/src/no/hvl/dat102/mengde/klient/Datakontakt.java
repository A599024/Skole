package no.hvl.dat102.mengde.klient;

public class Datakontakt {

    private Medlem [] tab;
    private int antall;
    
    public Datakontakt(int lengde) {
        tab = new Medlem [lengde];
        antall = 0;
    }
    
    public void utvid() {
         Medlem [] nytab = new Medlem [tab.length*2];
         for (int i = 0; i < tab.length; i++) {
             nytab[i] = tab[i];

         }
         tab = nytab;
     }
    
    public boolean erTom () {
        return antall == 0;
    }
    
    public void leggTilMedlem (Medlem person) {
        if (antall == tab.length)
            utvid();
        tab[antall] = person;
        antall++;
    }
    
    
    public int finnMedlemsIndeks(String medlemsnavn) {
        int indeks = -1;
        
        for (int i = 0; i < antall; i++) {
            if (tab[i].getNavn().contentEquals(medlemsnavn)) {
                indeks = i;
            }
        }
        return indeks;
    }
    
    public int finnPartnerFor(String medlemsnavn) {
        int index = finnMedlemsIndeks(medlemsnavn);
        int send = -1;
        if (index == -1)
            return -1;
        Medlem test = tab[index];
        
        for (int i = 0; i < antall; i++) {
            if ((tab[i].passerTil(test)) && (i != index) && (tab[i].getStatusIndex() == -1)) {
                tab[i].setStatusIndex(index);
                test.setStatusIndex(i);
                send = i;
                break;
            } 
        }
        return send;
    }
    
    public void tilbakestillStausIndeks(String medlemsnavn) {
        int index = finnMedlemsIndeks(medlemsnavn);
        Medlem test = tab[index];
        if (index != -1 && test.getStatusIndex() > 0) {
            tab[test.getStatusIndex()].setStatusIndex(-1);
            test.setStatusIndex(-1);
        } else 
            System.out.println("medlem eksisterer ikke eller har ingen partner");    
        
    }
    
    public void visAlle() {
        String ut = "MEDLEMMER" + "\n";
        for(int i = 0; i < antall; i++) {
            ut +=  "-" + tab[i].getNavn() + " " + tab[i].getStatusIndex() + "\n";
        }
        System.out.println(ut);
    }
    
    public int antall() {
    	return antall;
    }
    
    /*
     * Hjelpemetode for skrivHobbyListe
     * returnerer en String med navn til personer som er joblet sammen og, deres hobbier
     */
    public String finnAllePartnere() {
    	int par = 0;
    	String ut = "";
    	
    	/*
    	 * If settninga sjekker et par er koblet med noen andre, ved at status indeksen er større enn -1
    	 * Går den igjennom sjekkes det om personen som er i par har lavest index slik at vi ikke får
    	 * duplikater når vi treffer på den andre partneren.
    	 * 
    	 */
    	for(int i = 0; i < antall; i++) {
    		if(tab[i].getStatusIndex() > -1 && ( tab[i].getStatusIndex() < tab[tab[i].getStatusIndex()].getStatusIndex())) {
    			par++;
    			ut += tab[i].getNavn() + " og " + tab[tab[i].getStatusIndex()].getNavn() + ".          " + tab[i].visHobby() + "\n";
    		}
    	}
    	ut += "Antall PAR: " + par;
    	return ut;
    }
    
    
}