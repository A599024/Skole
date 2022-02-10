package no.hvl.dato100;

public class ToDoApp {

	public static void main(String[] args) {

		ToDoListe liste = new ToDoListe(10);
		
		liste.leggTil( new ToDoElement("Vaske bilen", 2, 6));
		liste.leggTil( new ToDoElement("Handle mat", 7, 1));
		liste.leggTil( new ToDoElement("Jobbe med skole", 3, 2));
		liste.leggTil( new ToDoElement("Spare penger", 5, 4));
		liste.leggTil( new ToDoElement("Ringe muttern", 10, 9));

		System.out.println(liste.finnViktig());
		
		
	}

}
