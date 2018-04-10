package repo_2014.nQueen;

import java.util.ArrayList;
import java.util.List;

public class NQueen_1 {
	public List<String[]> solveNQueens(int n) {
		List<String[]> result = new ArrayList<String[]>();
		// i is row, rowQ[i] is column
		int[] rowQ = new int[n];
		findResult(result, rowQ, 0, n);
		return result;
	}

	/**
	 *
	 * @param result
	 *            : final results
	 * @param rowQ
	 *            : rowQ[i] is column
	 * @param row
	 *            : current row
	 * @param n
	 *            : board's size
	 */
	private void findResult(List<String[]> result, int[] rowQ, int row, int n) {
		for (int i = 0; i < n; i++) {
			if (!isAttack(rowQ, row, i)) {
				rowQ[row] = i;
				if (row == n - 1) {
					// last line
					// Use newRe to contains one solution
					String[] newRe = new String[n];
					for (int r = 0; r < n; r++) {
						StringBuilder sb = new StringBuilder();
						for(int c=0;c< n;c++){
                            if(c==rowQ[r]){
                                sb.append('Q');
                            }else{
                                sb.append('.');
                            }
						}
						newRe[r] = sb.toString();
					}
					result.add(newRe);
				} else {
					findResult(result, rowQ, row + 1, n);
				}
			}
		}
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
