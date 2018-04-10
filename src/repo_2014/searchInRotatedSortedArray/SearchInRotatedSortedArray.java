package repo_2014.searchInRotatedSortedArray;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * @author Ricky
 *
 */
public class SearchInRotatedSortedArray {
	/**
	 * （1）如果target==A[m]，那么m就是我们要的结果，直接返回；
	 * （2）如果A[m]<A[r]，那么说明从m到r一定是有序的（没有受到rotate的影响），那么我们只需要判断target是不是在m到r之间，
	 * 如果是则把左边缘移到m+1，否则就target在另一半，即把右边缘移到m-1。
	 * （3）如果A[m]>=A[r]，那么说明从l到m一定是有序的，同样只需要判断target是否在这个范围内，相应的移动边缘即可。
	 * 
	 * @param A
	 * @param target
	 * @return
	 */
	public int search(int[] A, int target) {
		int start = 0;
		int end = A.length - 1;

		while (start <= end) {
			int m = (start + end) / 2;
			if (A[m] == target) {
				return m;
			}
			if (A[m] < A[end]) {
				if (A[m] < target && A[end] >= target) {
					start = m + 1;
				}
				else {
					end = m - 1;
				}
			} else {
				if (target < A[m] && target >= A[start]) {
					end = m - 1;
				} else {
					start = m + 1;
				}
			}
		}
		return -1;
	}
}
