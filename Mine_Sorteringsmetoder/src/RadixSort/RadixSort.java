package RadixSort;

import java.util.ArrayDeque;
import java.util.Queue;

public class RadixSort {
	
	/*
	 * R A D I X	S O R T 
	 * 	
	 * We first start of making a number of queues that match the number
	 * of decimals that are used. Although using an array will be a better alternative.
	 * the we start with the decimal farthest to the left and then we add the numbers
	 * to their matching array/queue, so number 532 will be placed in array for decimal 2
	 * when we have iterated trough the whole list we start with array 1 and now we check
	 * the second decimal and place the number to the correct place.
	 * When we have gone trough all decimals in every number we are finished and can place
	 * everything back again and it will be sorted.
	 * If we sort names we will need 26 array/queues.
	 * 
	 * When there is different length of integers the list we need to add 0´s so all numbers
	 * have equal number of decimales. or we can sort the decimales into smallers lists then sort
	 * them after their length first.
	 * 
	 * 
	 * O - N O T A T I O N
	 * 
	 * we will iterate trough the arrays/queues (numberOfDecimaltimes) * n.
	 * if the length is k vi get O(k*n)
	 * so o-notation will be O(n)
	 */
	
	private static final int RADIX = 10;
	
	public static void radixSort(int[] data) {
		
		int n = data.length;
		int max = findLargest(data);
		int maxDecimal = length(max);
		
		ArrayQueue<Integer>[] decimalQueue = new ArrayQueue[RADIX];
		for(int i = 0; i < RADIX; i++) {
			decimalQueue[i] = new ArrayQueue<>(n);
		}
		
		int weight = 1;
		for(int i = 0; i < maxDecimal; i++) {
			for(int j = 0; j < n; j++) {
				int decimal = findDecimal(data[j], weight);
				decimalQueue[decimal].inQueue(data[j]);
			}
			
			// Sets the Queues together
			int p = 0;
			for(int k = 0; k < RADIX; k++) {
				while(!decimalQueue[k].isEmpty()) {
					data[p] = decimalQueue[k].outQueue();
					p++;
				}
				
			}
			weight *= 10;
		}
	}

	
	
	
	public static int findLargest(int[] data) {
		if(data.length == 0)
			return 0;
		
		int largest = data[0];
		
		for(int i = 1; i < data.length; i++) {
			if(data[i] >= largest) {
				largest = data[i];
			}
		}
		return largest;
	}
	
	public static int length(int max) {
		return ("" + max).length();
	}
	
	public static int findDecimal(int num, int weight) {
		return (num / weight) % 10;
	}
	
	
	
	/*********************************************
	 * R A D I X	S O R T, 	A L P H A B E T
	 *********************************************/
	private static final int ALPHABET = 26;
	
	public static void radixAlphabetSort(int[] data) {
		
		int n = data.length;
		int max = findLargest(data);
		int maxDecimal = length(max);
		
		@SuppressWarnings("unchecked")
		ArrayQueue<Integer>[] decimalQueue = new ArrayQueue[ALPHABET];
		for(int i = 0; i < RADIX; i++) {
			decimalQueue[i] = new ArrayQueue(n);
		}
		
		int weight = 1;
		for(int i = 0; i < maxDecimal; i++) {
			for(int j = 0; j < n; j++) {
				int decimal = findDecimal(data[j], weight);
				decimalQueue[decimal].inQueue(data[j]);
			}
			
			// Sets the Queues together
			int p = 0;
			for(int k = 0; k < RADIX; k++) {
				while(!decimalQueue[k].isEmpty()) {
					data[p] = decimalQueue[k].outQueue();
					p++;
				}
				
			}
			weight *= 10;
		}
	}
	
//	public static int findChar(int[] data) {
//		if(data.length == 0)
//			return 0;
//		
//		int largest = data[0];
//		
//		for(int i = 1; i < data.length; i++) {
//			if(data[i] >= largest) {
//				largest = data[i];
//			}
//		}
//		return largest;
//	}
//	
//	public static int lengthA(int max) {
//		return ("" + max).length();
//	}
//	
//	public static int findDecimal(int num, int weight) {
//		return (num / weight) % 10;
//	}
	
	
	
	
	
}
