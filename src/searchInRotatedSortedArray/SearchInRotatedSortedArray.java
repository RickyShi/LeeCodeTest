package searchInRotatedSortedArray;

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
