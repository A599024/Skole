package Rekursjon;

public class HanoiTowers {

	public void hanoiTowers(int disks, int start, int temp, int end) {
		if(disks == 1) {
			// flytte fra en til 3
		} else {
			hanoiTowers(disks-1, start, end, temp);
			hanoiTowers(disks, temp, start, end);
		}
		
	}
	
}
