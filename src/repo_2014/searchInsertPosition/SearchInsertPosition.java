package repo_2014.searchInsertPosition;

public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		if (A == null) {
			return 0;
		}
		for (int i = 0; i < A.length; i++) {
			if (target <= A[i]) {
				return i;
			}
		}
		return A.length;
	}
}
