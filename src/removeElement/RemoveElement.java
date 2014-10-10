package removeElement;

/**
 * 1&2 are replacing the element with last one
 * 3 is put the not-delete item in the first of the Array
 *
 * @author Ricky
 *
 */
public class RemoveElement {
	public int removeElement1(int[] A, int elem) {
		int newLength = A.length - 1;
		for (int i = 0; i <= newLength; i++) {
			while (A[newLength] == elem) {
				newLength--;
				if (newLength == -1) {
					return 0;
				}
			}
			if (A[i] == elem && i < newLength) {
				A[i] = A[newLength];
				newLength--;
			}
		}
		return newLength + 1;
	}

	public int removeElement2(int[] A, int elem) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int start = 0;
		int end = A.length - 1;
		while (start <= end) {
			if (A[start] == elem && A[end] != elem) {
				A[start] = A[end];
				start++;
				end--;
			}

			if (A[start] != elem) {
				start++;
			}
			if (A[end] == elem) {
				end--;
			}
		}
		return end + 1;
	}

	public int removeElement3(int[] A, int elem) {
		int index = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != elem) {
				if (i != index) {
					A[index] = A[i];
				}
				index++;
			}
		}
		return index;
	}
}
