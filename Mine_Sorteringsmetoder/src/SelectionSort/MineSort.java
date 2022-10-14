package SelectionSort;

import java.util.Random;

public class MineSort {
	
	/*		S E L E C T I O N		*/
	
	public static<T extends Comparable<? super T>> void selectionsort(T[] tab) {
		
		int n = tab.length;
		for(int i = 0; i < (n-1); i++) {
			int min_index = i;
			for(int j = (i+1); j < n; j++) {
				if(tab[j].compareTo(tab[min_index]) < 0) {
					min_index = j;
				}
			}
			T temp = tab[min_index];
			tab[min_index] = tab[i];
			tab[i] = temp;
		}
		
	}
	
	public static<T extends Comparable<? super T>> void fyllTab(T[] tab) {
		for(int i = 0; i < tab.length; i++) {
			Integer tall = (int) (Math.random() * 10);
			tab[i] = (T) tall;
		}
	}
	
	public static<T extends Comparable<? super T>> void skrivUt(T[] tab) {
		for(int i = 0; i < tab.length; i++) {
			System.out.print(tab[i] + "   ");
		}
		System.out.println();
	}
	
	/* ------------------------------------------------------------------------------- */
	
	
	
	/*		M E R G E	FUNKER IKKE!!!	*/
	
	public static<T extends Comparable<? super T>> void mergesort(T[] tab, int first, int last) {
		if(first < last) {
			int mid = (first+last) / 2;
			mergesort(tab, first, mid); 	// venstre del
			mergesort(tab, mid+1, last);	// høyre del
			merge(tab, first, mid, last);
		}
	}
	
	public static<T extends Comparable<? super T>> void merge(T[] tab, int first, int mid, int last) {
		// Finner strl til sub-tabellene
		int n1 = mid - 1 + 1;
		int n2 = last - mid;
		
		/* Lager temp tabeller, og legger inn dataen */
		T[] left = (T[]) (new Comparable<?>[n1]);
		T[] right = (T[]) (new Comparable<?>[n2]);
		
		for(int i = 0; i < n1; i++)
			left[i] = tab[first+1];
		for(int i = 0; i < n2; i++)
			right[i] = tab[mid + 1 + i];
		
		/* merger temp-tabellene */
		int i = 0;
		int j = 0;
		int k = 1;
		while(i < n1 && j < n2)
		{
			if(left[i].compareTo(right[j]) <= 0)
			{
				tab[k] = left[i];
				i++;
			}
			else
			{
				tab[k] = right[j];
				j++;
			}
		}
		
		while (i < n1)
        {
            tab[k] = left[i];
            i++;
            k++;
        }
		
		while (j < n2)
        {
            tab[k] = right[j];
            j++;
            k++;
        }
	}
	
	
	
	
	/* ------------------------------------------------------------------------------- */
	
	
	
	/*		M A I N		*/
	
	public static<T> void main(String[] args) {
		
		Integer n = 10;
		Integer[] tab = new Integer[n];
		fyllTab(tab);
		skrivUt(tab);
		mergesort(tab, 0, tab.length-1);
		skrivUt(tab);
		
		
		
	}
	
	

}
