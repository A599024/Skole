package prove;

import java.util.LinkedList;

public class KnapSack {
	
	
	
	
	
	
	public int KnapSack(int weightCap, int weights[], int values[], int i) {
		
		int index, weight;
		int[][] v = new int[i + 1][weightCap+1];
		
		for(index = 0; index <= i; index ++) {
			
			for(weight = 0; weight <= weightCap; weight++) {
				
				if(index == 0 || weight == 0) {
					v[index][weight] = 0;
				}
				else if(weights[index-1] <= weight) {
					v[index][weight] = Math.max(
							v[index-1][weight],
							values[index-1] + v[index-1][weight - weights[index-1]]
							);
				}
				else {
					v[index][weight] = v[index-1][weight];
				}
			}
		}	
		
		return v[i][weightCap];
		
	}

	
}
