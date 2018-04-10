package repo_2014.Sort;

/**
 * o(n2)
 * @author Ricky
 *
 */
public class selectionSort {
	public int[] selectionSortMethod(int[] unSorted){
		int min;
		int minKey;
		for (int i=0; i<unSorted.length-1; i++){
			min = unSorted[i];
			minKey = -1;
			for (int j=i+1; j<unSorted.length; j++){
				if (unSorted[j]<min){
					min = unSorted[j];
					minKey = j;
				}
			}
			if (min<unSorted[i]){
				unSorted[minKey] =  unSorted[i];
				unSorted[i] =min;
			}
		}
		return unSorted;
	}
	
	public String toString(int[] array){
		StringBuffer t = new StringBuffer();
		for (int e : array){
			t.append(e).append(",");
		}
		return t.substring(0, t.length()-1).toString();
	}
	
	public static void main(String[] args){
		selectionSort ex = new selectionSort();
		int[] unsorted = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51,-1};
		System.out.println(ex.toString(unsorted));
		int[] sorted = ex.selectionSortMethod(unsorted);		
		System.out.println(ex.toString(sorted));
	}
}
