package repo_2014.Sort;

/**
 * Gap choose n/2.../2.../2...till 1. And always choose odd.
 * @author Ricky
 *
 */
public class shellSort {
	public int[] shellSortMethod(int[] unSorted){
		double doubleGap = unSorted.length;
		int dataToBeInserted;
		int gap;
		
		while (true){
			doubleGap = Math.ceil(doubleGap/2);
			gap = (int) doubleGap;
			//select different group based on the gap
			for (int i = 0; i<gap;i++){
				//sort each group
				for(int j=i+gap; j<unSorted.length; j+=gap){
					int k = j-gap;
					dataToBeInserted = unSorted[j];
					while (k>=0 && dataToBeInserted < unSorted[k]){
						unSorted[k+gap] = unSorted[k];
						k-=gap;
					}
					unSorted[k+gap] = dataToBeInserted;
				}
			}
			if (gap==1)
				break;
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
		shellSort ex = new shellSort();
		int[] unsorted = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		System.out.println(ex.toString(unsorted));
		int[] sorted = ex.shellSortMethod(unsorted);		
		System.out.println(ex.toString(sorted));
	}
}
