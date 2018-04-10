package repo_2014.removeDuplicatesFromSortedArray;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 *
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 *
 * @author Ricky
 *
 */
public class RemoveDuplicatesFromSortedArray2 {
	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int dupLen = 0;
		int insert = 0;

		for (int i = 0; i < A.length; i++) {
			boolean flag = false;
			while (i < A.length - 1 && A[i] == A[i + 1]) {
				if (!flag) {
					A[insert++] = A[i];
					flag = true;
				} else {
					dupLen++;
				}
				i++;
			}
			A[insert++] = A[i];
		}
		return A.length - dupLen;
	}
}
