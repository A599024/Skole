package ressssssss;

import static javax.swing.JOptionPane.*;

import java.io.*;
import java.util.Arrays;
import java.util.*;

public class MainRes {

	public static void main(String[] args) {
			
		
		try {
			String svar;
			final int MAX_RES = 100;
			Reservasjon[] resTab = new Reservasjon[MAX_RES];
			int nesteLedige = 0;
			
			File fil = new File("reservasjoner.txt");
			Scanner leser = new Scanner(fil);
			while (leser.hasNextLine()) {
				String linje = leser.nextLine();
				String[] filTab = linje.split(";");
				String navn = filTab[0];
				Dato dato = new Dato(filTab[1]);
				KlSlett start = new KlSlett(filTab[2]);
				KlSlett slutt = new KlSlett(filTab[3]);
				Reservasjon filRes = new Reservasjon(navn, dato, start, slutt);				
				resTab[nesteLedige] = filRes;
				nesteLedige++;
			}
			leser.close();
			
			do {
				Dato dato = new Dato(showInputDialog("Angi dato (dd.mm.åååå): "));
				KlSlett start = new KlSlett(showInputDialog("Angi start-klokkelsett (mm:tt): "));
				KlSlett slutt = new KlSlett(showInputDialog("Angi slutt-klokkeslett: (mm:tt)"));
				if (dato.lovlig() && start.lovlig() && slutt.lovlig()) {
					String navn = showInputDialog("Angi navn");
					Reservasjon res = new Reservasjon(navn, dato, start, slutt);
					if (nesteLedige == 0) {
						resTab[nesteLedige] = res;
						nesteLedige++;
					}
					else {
						boolean kollisjon = false;
						for (int i = 0; i < nesteLedige; i++) {
							
							if(res.kollisjonMed(resTab[i])) { 
								kollisjon = true;
								showMessageDialog(null, "Reservasjonen er opptatt");
							}
						}
						if (kollisjon == false) {
							resTab[nesteLedige] = res;
							nesteLedige++;
						}
					}
			
				}
				else {
					showMessageDialog(null, "Beklager, ugyldig dato eller tid");
				}
				
				svar = showInputDialog("Vil du legge til fler reservasjoner? \n   ( ja / nei)");
			} while (!svar.equals("nei"));
			
			// Sortere her
			
			String utTekst = "RESERVASJONSLISTE" + "\n";
			String[] sortertResTab = new String[nesteLedige];
			for (int i = 0; i < nesteLedige; i++) {
				sortertResTab[i] = resTab[i].toString();
			}
			// Endre sorteringen til å sortere etter dato, deretter tid, lett oversikt.
			Arrays.sort(sortertResTab);
			
			for (int i = 0; i < sortertResTab.length; i++) {
				utTekst += sortertResTab[i].toString() + "\n";
			}
			showMessageDialog(null, utTekst);
			
			PrintWriter skriver = new PrintWriter(fil);
			for (int i = 0; i < nesteLedige; i++) {
				skriver.println(resTab[i].toFil());
			}
			skriver.close();
				
		} catch(NumberFormatException e) {
			showMessageDialog(null, "Noe gikk galt, prøv igjen");
		} catch(ArrayIndexOutOfBoundsException e) {
			showMessageDialog(null, "Noe gikk galt, prøv igjen");
		} catch(FileNotFoundException e) {
			showMessageDialog(null, "Fil ikke funnet!");
		} catch (NullPointerException e) {
			// Programmet lukkes normalt
		}
		
	}

}
