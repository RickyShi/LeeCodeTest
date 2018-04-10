package repo_2014.findMinInRotatedSortedArray;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author Ricky
 * 
 */
public class FindMinInRotatedSortedArray {
	public int findMin(int[] num) {
	    int l = 0;
	    int r = num.length-1;
	    int min = Integer.MAX_VALUE;
	    while (l<=r){
	        int m = (l+r)/2;
	        if (num[m]<min){
	            min=num[m];
	        }
	        if (l==r){
	            return min;
	        }
	        if (num[m]>num[l]){
	                if (min > num[l]) {
						min = num[l];
					}
	                l = m+1;
	        } else {
	            if (min > num[m+1]) {
					min = num[m+1];
				}
	            r = m-1;
	        }
    }
    return min;
	}
}
