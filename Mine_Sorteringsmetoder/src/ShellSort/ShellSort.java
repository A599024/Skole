package ShellSort;

import InsertionSort.*;
import java.lang.reflect.Array;

import InsertionSort.*;

public class ShellSort {
	
	public static <T extends Comparable<? super T>> void shellSort(T[] a) {
		int space = a.length / 3;
		shellSort(a, space);
	}
	
	public static <T extends Comparable<? super T>> void shellSort(T[] a, int space) {
		if(space == 1 || space == 0) {	// Basis
			InsertionSort.sortIterative(a, a.length);
		} else {
			for(int i = 0; i < a.length - space - 1; i++) {
				if(a[i].compareTo(a[i + space]) > 0) {
					T tmp = a[i];
					a[i] = a[i + space];
					a[i + space] = tmp;
				}
			}
			shellSort(a, (space / 2));
		}
	}


}
