package uniqueBinarySearchTree;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

 For example,
 Given n = 3, there are a total of 5 unique BST's.
 */

// http://www.lifeincode.net/programming/leetcode-unique-binary-search-trees-i-and-ii-java/
public class UniqueBinarySearchTrees1 {
	/**
	 * Using DP:
	 *
	 * f(n)= Sigma(i: 0...n-1)(f(i)*f(n-1-i))
	 *
	 * @author Ricky
	 *
	 */
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
