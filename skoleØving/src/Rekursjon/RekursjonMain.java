package Rekursjon;

public class RekursjonMain {
	
	static int maks(int[] tab, int start, int slutt) {
		if(start == slutt) {	//Basistilfellet
			return tab[start];
		}
		int midten = (start + slutt) / 2;
		
		int maksVenstre = maks(tab, start, midten);
		int maksHøyre = maks(tab, midten+1, slutt);
		
		if(maksVenstre > maksHøyre) {
			return maksVenstre;
		} else {
			return maksHøyre;
		}
		
	}
	
	
	
	
	
	
}
