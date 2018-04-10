package repo_2014.Sort;

public class mergeSort {
	private int[] mergeSortMethod(int[] unSorted, int l, int r){
		if (l<r){
			int middle = (l+r)/2;
			mergeSortMethod(unSorted, l, middle);
			mergeSortMethod(unSorted, middle+1, r);
			mergeArray(unSorted,l,middle,r);
		}
		return unSorted;
		
	}

	private void mergeArray(int[] unSorted, int l, int middle, int r) {
		int[] tmpArray = new int[unSorted.length];
		int rightPartToCompare = middle + 1;
		int tmpArrayCurrentIndex = l;
		int tmpArrayFirstIndexInUnsorted = l;
		while (l<=middle && rightPartToCompare <=r){
			if (unSorted[l]<unSorted[rightPartToCompare]){
				tmpArray[tmpArrayCurrentIndex++]=unSorted[l++];
			} else {
				tmpArray[tmpArrayCurrentIndex++]=unSorted[rightPartToCompare++];
			}
		}
		
		while (l<=middle){
			tmpArray[tmpArrayCurrentIndex++]=unSorted[l++];
		}
		
		while (rightPartToCompare<=r){
			tmpArray[tmpArrayCurrentIndex++]=unSorted[rightPartToCompare++];
		}
		
		while (tmpArrayFirstIndexInUnsorted<=r){
			unSorted[tmpArrayFirstIndexInUnsorted]=tmpArray[tmpArrayFirstIndexInUnsorted];
			tmpArrayFirstIndexInUnsorted++;
		}
	}
	private String toString(int[] array){
		StringBuffer t = new StringBuffer();
		for (int e : array){
			t.append(e).append(",");
		}
		return t.substring(0, t.length()-1).toString();
	}
	public static void main(String[] args){
		mergeSort ex = new mergeSort();
		int[] unsorted = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51,-1};
		System.out.println(ex.toString(unsorted));
		int[] sorted = ex.mergeSortMethod(unsorted,0,unsorted.length-1);		
		System.out.println(ex.toString(sorted));
	}
}
