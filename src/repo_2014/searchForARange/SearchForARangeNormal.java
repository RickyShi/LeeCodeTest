package repo_2014.searchForARange;

public class SearchForARangeNormal {
	public static int[] searchRange(int[] A, int target) {
		int[] rtn = new int[2];
		rtn[0] = -1;
		rtn[1] = -1;
		if (A == null || A.length == 0) {
			return rtn;
		}
		int l = 0;
		int r = A.length - 1;
		int s = -1, e = -1;
		boolean flag = false;
		while (l <= r) {
			int m = l + (r - l) / 2;
			if (A[m] < target) {
				l = m + 1;
			} else if (A[m] > target) {
				r = m - 1;
			}
			if (A[m] == target) {
				flag = true;
				for (s = m; s >= 0; s--) {
					if (A[s] != target) {
						break;
					}
				}
				s++;
				for (e = m; e < A.length; e++) {
					if (A[e] != target) {
						break;
					}
				}
				e--;
				rtn[0] = s;
				rtn[1] = e;
				return rtn;
			}
		}
		if (!flag) {
			s = -1;
			e = -1;
		}

		rtn[0] = s;
		rtn[1] = e;
		return rtn;
	}

	public static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.println(i);
		}
		System.out.println();
	}

	public static void main(String[] a) {
		int[] A = { 1, 2, 5, 7, 7, 7, 8, 8, 8, 8, 9, 9, 10 };
		printArr(searchRange(A, 8));
		printArr(searchRange(A, 9));

	}
}
