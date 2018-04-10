package repo_2014.rotateImage;

/**
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Follow up:
 * Could you do this in-place?
 *
 * @author Ricky
 *
 */
public class RotateImage {
	/**
	 * in-place
	 * The code here:
	 * 交换四个元素
	 * reference： http://blog.csdn.net/kenden23/article/details/17200067
	 *
	 * or 先逆对角线交换再上下交换
	 * reference:
	 * http://fisherlei.blogspot.com/2013/01/leetcode-rotate-image.html
	 * 
	 * @param matrix
	 */
	public void rotateInPlace(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - j - 1][i];
				matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
				matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
				matrix[j][n - i - 1] = temp;
			}
		}
	}

	public void rotateTrival(int[][] matrix) {
		int n = matrix.length;
		int[][] rtn = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				rtn[j][n - i - 1] = matrix[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = rtn[i][j];
			}
		}
	}
}
