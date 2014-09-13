package Sort;

/**
 * 
 * @author Ricky
 *	Data structure Array Worst case performance O(n2) comparisons, swaps 
 *	Best case performance O(n) comparisons, O(1) swaps 
 *	Average case performance О(n2) comparisons, swaps 
 *	Worst case space complexity О(n) total, O(1) auxiliary
 * @param <E>
 */
public class insertionSort {
	 int dataToBeInserted = 0;
	public  int[] insertionSortMethod(int[] unsorted){
		for (int i=1; i<unsorted.length; i++){
			int j = i-1;
			dataToBeInserted =  unsorted[i];
			while(j>=0 && dataToBeInserted<unsorted[j]){
				unsorted[j+1] = unsorted[j];
				j--;
			}
			unsorted[j+1] = dataToBeInserted;
		}
		return unsorted;
	}
	
	public String toString(int[] array){
		StringBuffer t = new StringBuffer();
		for (int e : array){
			t.append(e).append(",");
		}
		return t.substring(0, t.length()-1).toString();
	}
	
	public static void main(String[] args){
		insertionSort ex = new insertionSort();
		int[] unsorted = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		System.out.println(ex.toString(unsorted));
		int[] sorted = ex.insertionSortMethod(unsorted);		
		System.out.println(ex.toString(sorted));
	}
}
