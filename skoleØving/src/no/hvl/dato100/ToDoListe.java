package no.hvl.dato100;

public class ToDoListe {
	
	private ToDoElement[] todoTab;
	private int antall;
	
	
	public ToDoListe(int maksAntall) {
		todoTab = new ToDoElement[maksAntall];
		antall = 0;
	}
	
	
	public void leggTil(ToDoElement tde) {
		if (antall >= todoTab.length)
			System.out.println("Tabellen er full!");
		else {
			todoTab[antall] = tde;
			antall++;
		}
	}
	
	
	public ToDoElement finnViktig() {
		int lavest = Integer.MAX_VALUE;
	
		for(int i = 0; i < antall; i++) {
			if(todoTab[i].getPrioritet() < lavest)
				lavest = todoTab[i].getPrioritet();
		}
		return todoTab[lavest];
	}
	
	public void skrivUt() {
		for(int i = 0; i < antall; i++) {
			System.out.println(todoTab[i].toString() + "\n");
		}
	}

}
