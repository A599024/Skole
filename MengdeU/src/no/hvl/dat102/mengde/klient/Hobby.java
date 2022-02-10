package no.hvl.dat102.mengde.klient;

import java.util.Objects;

public class Hobby {

	private String hobbyNavn;
	
	public Hobby(String hobby) {
		this.hobbyNavn = hobby;
	}
	
	public String toString() {
		return hobbyNavn + "";
	}

	@Override
	public int hashCode() {
		return Objects.hash(hobbyNavn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hobby other = (Hobby) obj;
		return Objects.equals(hobbyNavn, other.hobbyNavn);
	}
	
}
