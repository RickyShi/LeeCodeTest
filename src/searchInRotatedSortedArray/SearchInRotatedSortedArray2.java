package searchInRotatedSortedArray;

/**
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 *
 * Would this affect the run-time complexity? How and why?
 *
 * Write a function to determine if a given target is in the array.
 *
 * @author Ricky
 *
 */
public class SearchInRotatedSortedArray2 {
	/**
	 * o(lgn) slow down to o(n) for duplicated steps
	 * 
	 * @param A
	 * @param target
	 * @return
	 */
	public boolean search(int[] A, int target) {
		int start = 0;
		int end = A.length - 1;

		while (start <= end) {
			int m = (start + end) / 2;
			if (A[m] == target) {
				return true;
			}
			if (A[m] < A[end]) {
				if (A[m] < target && A[end] >= target) {
					start = m + 1;
				}
				else {
					end = m - 1;
				}
			} else if ((A[m] > A[end])) {
				if (target < A[m] && target >= A[start]) {
					end = m - 1;
				} else {
					start = m + 1;
				}
			} else {
				end--;
			}
		}
		return false;
	}

}
