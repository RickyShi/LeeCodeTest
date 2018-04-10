package repo_2014.search2DMatrix;

public class Search2DMatrixTrival {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null) {
			return false;
		}
		for (int j = 0; j < matrix[0].length; j++) {
			for (int i = 0; i < matrix.length; i++) {
				if (matrix[i][j] == target) {
					return true;
				}
			}
		}
		return false;
	}
}
