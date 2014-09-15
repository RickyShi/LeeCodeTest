package Sort;

public class bubbleSort {
	public int[] bubbleSortMethod(int[] unSorted){
		for (int i=0;i<unSorted.length;i++){
			for (int j=unSorted.length-1;j>0;j--){
				if (unSorted[j]<unSorted[j-1]){
					int temp = unSorted[j];
					unSorted[j] = unSorted[j-1];
					unSorted[j-1] = temp;
				}
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
		bubbleSort ex = new bubbleSort();
		int[] unsorted = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51,-1};
		System.out.println(ex.toString(unsorted));
		int[] sorted = ex.bubbleSortMethod(unsorted);		
		System.out.println(ex.toString(sorted));
	}
}
