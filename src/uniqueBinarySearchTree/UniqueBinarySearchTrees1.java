package uniqueBinarySearchTree;

/**
 * Using DP:
 *
 * f(n)= Sigma(i: 0...n-1)(f(i)*f(n-1-i))
 *
 * @author Ricky
 *
 */
public class UniqueBinarySearchTrees1 {
	public static int numTrees(int n) {
		int[] f = new int[n + 1];
		f[0] = 1;
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int k = 0; k < i; k++) {
				sum += f[k] * f[i - k - 1];
			}
			f[i] = sum;
		}
		return f[n];
	}

	public static void main(String[] args) {
		System.out.print(numTrees(4));
	}
}
