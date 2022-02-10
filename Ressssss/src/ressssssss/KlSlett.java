package ressssssss;

public class KlSlett {
	
	private int time, min;
	
	public KlSlett(int time, int min) {
		this.time = time;
		this.min = min;
	}
	
	public KlSlett(String strKlSlett) {
		String[] tab = strKlSlett.split(":");
		time = Integer.parseInt(tab[0]);
		min = Integer.parseInt(tab[1]);
	}
	
	public boolean lik(KlSlett kl) {
		return (time == kl.time && min == kl.min);
	}
	
	public boolean før(KlSlett kl) {
		String denne = toString();
		String annen = kl.toString();
		
		return (denne.compareTo(annen) < 0);
	}
	
	@Override
	public String toString() {
		String a = "";
		if(min < 10)
			a = "0";
		
		return time + ":" + min + a;
	}

	public boolean lovlig() {
		return (time <= 24 && time >= 0 && min <= 60 && min >= 0);
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}
	
}
