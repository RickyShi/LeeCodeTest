package repo_2014.uniqueBinarySearchTree;

/**
 * Using Catalan number f(n)= Sigma(i: 0...n-1)(f(i)*f(n-1-i)) =>
 * C(n,2n)-C(n+1,2n) => f(n)=f(n-1)*2*(2n-1)/(n+1)
 * 
 * @author Ricky
 * 
 */
public class UniqueBinarySearchTree1Catalan {
	public static int numTreesCatalan(int n) {
		int sum = 1;
		for (int i = 1; i <= n; i++) {
			sum = sum * 2 * (2 * i - 1) / (i + 1);
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.print(numTreesCatalan(6));
	}
}
