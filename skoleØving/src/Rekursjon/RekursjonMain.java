package Rekursjon;

public class RekursjonMain {
	
	// Finne maks tall i en tab
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
	
	// sum Node
	static int sum(Node<Integer> node) {
		if(node == null) {
			return 0;
		}
		
		return node.getData() + sum(node.getNext());
	
	}
	
	// rekursiv fakultet funskjon
	static int fakultet(int n) {
		if(n == 1) {
			return 1;
		}
		
		return n * fakultet(n-1);
		
	}
	
	// rekursiv sum for alle tall
	static int sumAlleTall(int n) {
		if(n == 1) {
			return 1;
		}
		
		return n + sumAlleTall(n - 1);
	}

	
	
	
	
	public static void main(String[] args) {
		
		int[] tab = {102, 22, 3, 46, 5 , 62, 73, 19, 12, 47,};
		
		System.out.println(maks(tab, 0, tab.length - 1));
		
		boolean sant = true;
		
		int tall = sant ? 10 : 2;
		System.out.println(tall);
		
		
		
		Node<Integer> n1 = new Node(1);
		Node<Integer> n2 = new Node(2);
		Node<Integer> n3 = new Node(3);
		
		n1.setNext(n2);
		n2.setNext(n3);
		Node<Integer> start = n1;
		
		System.out.println(sum(start));
		
		
		System.out.println(sumAlleTall(12));
	}
	
	
	
	
	
	
	
}
