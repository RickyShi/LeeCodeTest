package repo_2014.Sort;

public class quickSort {
	public int[] quickSortMethod(int[] unSorted, int l, int r){
		if (l<r){
		int middle = getMiddleArrayRearrange(unSorted, l, r);
		quickSortMethod(unSorted,l,middle-1);	
		quickSortMethod(unSorted,middle+1,r);	
		}
		
		return unSorted;		
	}

	private int getMiddleArrayRearrange(int[] unSorted, int l, int r) {
		//choose first index value as radix
		int radix = unSorted[l];
		while (l<r){
			//try to put the large value to the left if found
			while (l<r && unSorted[r]>=radix){
				r--;
			}
			unSorted[l] = unSorted[r];
			//try to put the small value to the right if found
			while (l<r && unSorted[l]<radix){
				l++;
			}
			unSorted[r] = unSorted[l];
		}
		//put radix into the correct place
		unSorted[l] = radix;
		return l;
	}
	
	private String toString(int[] array){
		StringBuffer t = new StringBuffer();
		for (int e : array){
			t.append(e).append(",");
		}
		return t.substring(0, t.length()-1).toString();
	}
	public static void main(String[] args){
		quickSort ex = new quickSort();
		int[] unsorted = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51,-1};
		System.out.println(ex.toString(unsorted));
		int[] sorted = ex.quickSortMethod(unsorted,0,unsorted.length-1);		
		System.out.println(ex.toString(sorted));
	}
}
