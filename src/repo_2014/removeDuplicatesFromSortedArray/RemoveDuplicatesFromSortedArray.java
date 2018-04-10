package repo_2014.removeDuplicatesFromSortedArray;

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * @author Ricky
 * 
 */
public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int dupLen = 0;
		int insert = 0;
		for (int i = 0; i < A.length; i++) {
			while (i < A.length - 1 && A[i] == A[i + 1]) {
				dupLen++;
				i++;
			}
			// A[insert]=A[i];
			// insert++;
			A[insert++] = A[i];
		}
		return A.length - dupLen;
	}
}
