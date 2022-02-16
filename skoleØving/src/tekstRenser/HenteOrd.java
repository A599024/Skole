package tekstRenser;

import java.io.File;
import java.util.Scanner;

public class HenteOrd {
	
	public static void main(String[] args) {
		
		try {
			File file = new File("norskeOrd.txt");
			Scanner reader = new Scanner(file);
			
			while(reader.hasNext()) {
				
			}
			
			
			
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	

}
