package repo_2014.spiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 *
 * For example,
 * Given the following matrix:
 *
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 *
 * @author Ricky
 *
 */
public class SpiralMatrix1 {

	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (matrix == null || matrix.length == 0) {
			return result;
		}

		int m = matrix.length;
		int n = matrix[0].length;

		int x = 0;
		int y = 0;

		while (m > 0 && n > 0) {

			// if one row/column left, no circle can be formed
			if (m == 1) {
				for (int i = 0; i < n; i++) {
					result.add(matrix[x][y++]);
				}
				break;
			} else if (n == 1) {
				for (int i = 0; i < m; i++) {
					result.add(matrix[x++][y]);
				}
				break;
			}

			// below, process a circle
			// each time go n-2 or m-2 steps

			// top - move right
			for (int i = 0; i < n - 1; i++) {
				result.add(matrix[x][y++]);
			}

			// right - move down
			for (int i = 0; i < m - 1; i++) {
				result.add(matrix[x++][y]);
			}

			// bottom - move left
			for (int i = 0; i < n - 1; i++) {
				result.add(matrix[x][y--]);
			}

			// left - move up
			for (int i = 0; i < m - 1; i++) {
				result.add(matrix[x--][y]);
			}

			x++;
			y++;
			m = m - 2;
			n = n - 2;
		}

		return result;
	}

	public List<Integer> spiralOrder2(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0) {
			return list;
		}
		int minRow = 0;
		int minColumn = 0;
		int maxRow = matrix.length - 1;
		int maxColumn = matrix[0].length - 1;
		while (minRow <= maxRow && minColumn <= maxColumn) {
			for (int i = minColumn; i <= maxColumn; i++) {
				list.add(matrix[minRow][i]);
			}
			minRow++;
			for (int i = minRow; i <= maxRow; i++) {
				list.add(matrix[i][maxColumn]);
			}
			maxColumn--;
			// This is important
			if (minRow <= maxRow) {
				for (int i = maxColumn; i >= minColumn; i--) {
					list.add(matrix[maxRow][i]);
				}
				maxRow--;
			}

			if (minColumn <= maxColumn) {
				for (int i = maxRow; i >= minRow; i--) {
					list.add(matrix[i][minColumn]);
				}
				minColumn++;
			}
		}
		return list;
	}
}
