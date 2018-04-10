package repo_2014.nQueen;

public class NQueens_2 {

	public int totalNQueens(int n) {
		int[] rowQ = new int[n];
		return findSolutions(rowQ, 0, n);
	}

	private int findSolutions(int[] rowQ, int row, int n) {
		int rtn = 0;
		for (int c = 0; c < n; c++) {
			if (!isAttack(rowQ, row, c)) {
				rowQ[row] = c;
				if (row == n - 1) {
					rtn++;
				} else {
					// This is important. To add the sum always.
					rtn += findSolutions(rowQ, row + 1, n);
				}
			}
		}
		return rtn;
	}

	private boolean isAttack(int[] rowQ, int row, int col) {
		for (int r = 0; r < row; r++) {
			if ((rowQ[r] == col) || (col - rowQ[r] == row - r)
					|| (rowQ[r] - col == row - r)) {
				return true;
			}
		}
		return false;
	}
}
