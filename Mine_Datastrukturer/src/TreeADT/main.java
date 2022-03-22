package TreeADT;

import BS_Tre.no.hvl.dat100.BS_Tre;

public class main {
	
	public static void main(String[] args) {
		
		int trær = 100;
		int noder = 1023;
		
		Object[] landområde = new Object[trær];
		fyllTrær(landområde, trær, noder);
		
		
		
	}
	
	public static void fyllTrær(Object[] landområde, int trær, int noder) {
		
		for(int i = 0; i < trær; i ++) {
			Integer random = (int) Math.random() * trær;
			landområde[i] = new BS_Tre<>(random);
			
			for(int j = 0; j < noder; j++) {
				
				Integer rand = (int) Math.random() * trær;
				BS_Tre<Integer> tre = (BS_Tre<Integer>) landområde[i];
				tre.leggTil(rand);
			}
			
			
		}
	}

}
