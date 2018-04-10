package repo_2014.searchInsertPosition;

/**
 * Dichotomy method is much better
 *
 * @author Ricky
 *
 */
public class SearchInsertPositionDichotomy {
	public int searchInsertDichotomy(int[] A, int target) {
		if (A == null) {
			return 0;
		}
		int left = 0;
		int right = A.length - 1;
		while (left <= right) {
			if (A[left] > target) {
				return left;
			} else if (A[right] < target) {
				return right + 1;
			} else {
				int middle = (left + right) / 2;
				if (A[middle] == target) {
					return middle;
				} else if (A[middle] > target) {
					right = middle - 1;
				} else {
					left = middle + 1;
				}
			}
		}
		return 0;

	}
}
