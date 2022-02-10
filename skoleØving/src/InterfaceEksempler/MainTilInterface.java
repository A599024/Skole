package InterfaceEksempler;

public class MainTilInterface {
	
	public static void main(String[] args) {
		
		ByTwos byTwos = new ByTwos();
		ByThrees byThrees = new ByThrees();
		Series obj;
		
		
		for(int i = 0; i < 5; i++) {
			
			obj = byTwos;
			
			System.out.println(obj.getNext());
		}
		
		
		
		// ByThrees byThrees = new ByThrees();
		

		
		
		
	}
	
}
