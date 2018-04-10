package repo_2014.findMinInRotatedSortedArray;

/**
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 *
 * Would this affect the run-time complexity? How and why?
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Find the minimum element.
 *
 * The array may contain duplicates.
 *
 * @author Ricky
 *
 */
public class FindMinInRotatedSortedArray2 {
	public int findMin(int[] A) {
		int l = 0;
		int r = A.length - 1;
		int min = Integer.MAX_VALUE;
		while (l <= r) {
			int mid = (l + r) / 2;
			min = A[mid] < min ? A[mid] : min;
			if (l == r) {
				return min;
			}
			if (A[mid] > A[l]) {
				min = A[l] < min ? A[l] : min;
				l = mid + 1;
			} else if (A[mid] < A[r]) {
				r = mid - 1;
			} else if (A[mid] == A[l]) {
				l = l + 1;
			} else if (A[mid] == A[r]) {
				r = r - 1;
			}
		}
		return min;
	}
}
