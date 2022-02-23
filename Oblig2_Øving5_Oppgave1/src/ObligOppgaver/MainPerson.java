package ObligOppgaver;

import java.util.Scanner;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.kjedet.KjedetOrdnetListe;
import no.hvl.dat102.listeklient.Person;
import no.hvl.dat102.tabell.TabellOrdnetListe;

import javax.swing.JOptionPane;
import javax.swing.JOptionPane.*;

public class MainPerson {

	
	/*
	 * les inn 5 objekt fra bruker
	 * print ut listen
	 * fjern et og ett objekt i stigende alder
	 * fler pers med samme alder 
	 */
	
	public static void main(String[] args) {
		
		TabellOrdnetListe<Person> personTabell = new TabellOrdnetListe<>();
		KjedetOrdnetListe<Person> personLinked = new KjedetOrdnetListe<>();
		
		for(int i = 0; i < 5; i++) {
			String personJOP = JOptionPane.showInputDialog("Angi info på følgende form:" + "\n" + "(fornavn;etternavn;fødselsår)");
			String[] pv = personJOP.split(";");
			personTabell.leggTil(new Person(pv[0], pv[1], Integer.parseInt(pv[2])));
			personLinked.leggTil(new Person(pv[0], pv[1], Integer.parseInt(pv[2])));
		}
		
		System.out.println("Person tabell:");
		personTabell.visTab();
		System.out.println();
		
		System.out.println("Person kjedet:");
		personLinked.visTab();
		System.out.println();
		
		// Fjerner med elst alder fra tab
		for(int i = 0; i < 5; i++) {
			System.out.println("Fjernet fra tabell:" + personTabell.fjernFoerste());
		}
		
		System.out.println();
		
		// fjerner med elst alder fra kjedet
		for(int i = 0; i < 5; i++) {
			System.out.println("Fjernet fra Kjedet:" + personLinked.fjernFoerste());
		}
		
	}
}
