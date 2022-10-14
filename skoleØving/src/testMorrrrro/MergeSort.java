package testMorrrrro;

public class MergeSort {
	
	/*
	 * M E R G E	S O R T
	 * 
	 * Splits an array by two until every element is alone
	 * starts setting the small seperate arrays together
	 * and sorting them as it grows
	 * 
	 * 
	 * O - N O T A T I O N
	 * 
	 * O(n*logn)
	 * 
	 * 
	 */
	
	
	public static <T extends Comparable<? super T>> void mergeSort(T[] a, int n) {
		mergeSort(a, 0, n - 1);
	}
	
	public static <T extends Comparable<? super T>> void mergeSort(T[] a, int first, int last) {
		@SuppressWarnings("unchecked")
		T[] tmpTab = (T[]) (new Comparable<?>[a.length]);
		mergeSort(a, tmpTab, first, last);
	}
	
	public static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] tmpTab, int first, int last) {
		if(first < last) {
			int mid = (first + last) / 2;
			mergeSort(a, tmpTab, first, mid);	// Sorterer venstre del
			mergeSort(a, tmpTab, mid + 1, last); // Sorterer høyre del
			merge(a, tmpTab, first, mid, last);	// fletter sammen
			
		}
	}
	
	public static <T extends Comparable<? super T>> void merge(T[] a, T[] tempTab, int forste, int midten, int siste) {
	
//		int firstHalf1 = first;
//		int lastHalf1 = mid;
//		int firstHalf2 = mid + 1;
//		int lastHalf2 = last;
//		
//		int index = firstHalf1;
//		while((firstHalf1 <= lastHalf1) && (firstHalf2 <= lastHalf2)) {
//			
//			if(a[firstHalf1].compareTo(a[firstHalf2]) < 0) {
//				tmpTab[index] = a[firstHalf1];
//				firstHalf1++;
//			} else {
//				tmpTab[index] = a[firstHalf2];
//				firstHalf2++;
//			}
//			index++;
//		}
		
		
		int fV = forste;
        int sluttV = midten;
        int fH = midten + 1;
        int sluttH = siste;

        // Så lenge det er element att i begge delane, flytt over den minste til tempTab
        int index = fV; // Next available location in tempArray
        for (; (fV <= sluttV) && (fH <= sluttH); index++) {
            if (a[fV].compareTo(a[fH]) < 0) {
                tempTab[index] = a[fV];
                fV++;
            } else {
                tempTab[index] = a[fH];
                fH++;
            }
        }

        // No vil ein av delane vere to. Kopierer over resten i den andr eedelen

        // Venstre del, kan vere tom
        for (; fV <= sluttV; fV++, index++) {
            tempTab[index] = a[fV];
        }

        // Høgre del, kan vere tom
        for (; fH <= sluttH; fH++, index++) {
            tempTab[index] = a[fH];
        }

        // Kopier den sorterte delen tilbake
        for (index = forste; index <= siste; index++) {
            a[index] = tempTab[index];
        }
		
	}

}

