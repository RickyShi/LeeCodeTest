package repo_2014.sortColors;

/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 *
 * Could you come up with an one-pass algorithm using only constant space?
 *
 * @author Ricky
 *
 */
public class SortColorsOnePass {
	/**
	 * Think About Quick repo_2014.Sort Partition
	 *
	 * Using three points
	 *
	 * @param A
	 */
	public void sortColors(int[] A) {
		if (A == null) {
			return;
		}
		int rIndex = 0, bIndex = A.length - 1;
		// make last while loop iterate less steps
		// could not use the following two loops
		// then just set
		// int index = 0;
		while (rIndex <= A.length - 1 && A[rIndex] == 0) {
			rIndex++;
		}
		while (bIndex >= 0 && A[bIndex] == 2) {
			bIndex--;
		}
		int index = rIndex;

		// The VIP Loop
		while (index <= bIndex) {
			if (A[index] == 0) {
				swap(A, index, rIndex);
				rIndex++;
				index++;
			}
			else if (A[index] == 2) {
				swap(A, index, bIndex);
				bIndex--;
			} else {
				index++;
			}
		}

		/**
		 * Another Loop doing the same thing
		 */
		// while (index <= bIndex) {
		// if (A[index] == 0 && index > rIndex) {
		// swap(A, index, rIndex);
		// rIndex++;
		// index++;
		// }
		// if (A[index] == 2) {
		// swap(A, index, bIndex);
		// bIndex--;
		// }
		// index++;
		// }
	}

	private void swap(int A[], int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
}
