package search2DMatrix;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the
 * previous row.
 * For example,
 * 
 * Consider the following matrix:
 * 
 * [
 * [1, 3, 5, 7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * 
 * @author Ricky
 * 
 */
public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null) {
			return false;
		}
		int w = matrix.length, h = matrix[0].length;
		for (int j = 0; j < h; j++) {
			if (matrix[w - 1][j] == target) {
				return true;
			}
			if (matrix[w - 1][j] > target) {
				for (int i = 0; i < w - 1; i++) {
					if (matrix[i][j] == target) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
