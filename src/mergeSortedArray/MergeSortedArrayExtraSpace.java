package mergeSortedArray;

public class MergeSortedArrayExtraSpace {
	public void merge(int A[], int m, int B[], int n) {
		int i = 0, j = 0;
		int k = 0;
		int[] C = new int[m + n];
		while (i <= m - 1 && j <= n - 1) {
			if (A[i] <= B[j]) {
				C[k++] = A[i++];
			} else {
				C[k++] = B[j++];
			}
		}
		while (i <= m - 1) {
			C[k++] = A[i++];
		}
		while (j <= n - 1) {
			C[k++] = B[j++];
		}
		k = 0;
		while (k <= m + n - 1) {
			A[k] = C[k];
			k++;
		}
	}
}
