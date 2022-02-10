package prove;

import static javax.swing.JOptionPane.*;

public class BestillingMain {

	public static void main(String[] args) {
		
		Bestilling[] bestillinger = new Bestilling[10];
		int nesteLedig = 0;
		String mer;		
		
		do {
			int svar = Integer.parseInt(showInputDialog("Ønsker du å bestille snarest mulig?  ( 1 )" + "\n" + "eller til et tidspunkt?  ( 2 )"));

			switch(svar) {
			case 1:
				String navn = showInputDialog("Navn: ");
				int kontaktnummer = Integer.parseInt(showInputDialog("Kontaktnummer: "));
				String adresse = showInputDialog("Adresse: ");
				int maxtid = Integer.parseInt(showInputDialog("Maxtid: "));
				
				bestillinger[nesteLedig] = new SnarestMulig(navn, kontaktnummer, adresse, maxtid);
				nesteLedig++;
				break;
			case 2:
				String navn2 = showInputDialog("Navn: ");
				int kontaktnummer2 = Integer.parseInt(showInputDialog("Kontaktnummer: "));
				String adresse2 = showInputDialog("Adresse: ");
				String dato2 = showInputDialog("Dato: ");
				String tidspunkt2 = showInputDialog("Tidspunkt: ");
				
				bestillinger[nesteLedig] = new Tidspunkt(navn2, kontaktnummer2, adresse2, dato2, tidspunkt2);
				nesteLedig++;
				break;
			}
			
			mer = showInputDialog("Vil du legge til fler bestillinger?");
		
		} while(mer.equals("ja"));
				
		for(int i = 0; i < nesteLedig; i++) {
			bestillinger[i].skrivUt();
		}
		
		
	}

}
