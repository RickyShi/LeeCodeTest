package repo_2014.printPrime;

public class PrintPrime {
	public static void printPrime(int n) {
		if (n > 1) {
			System.out.print(2 + " ");
			if (n > 2) {
				System.out.print(3 + " ");
				for (int i = 3; i <= n; i++) {
					for (int j = 2; j <= (int) (Math.sqrt(i)); j++) {
						if (i % j == 0) {
							break;
						}
						if (j == (int) (Math.sqrt(i))) {
							System.out.print(i + " ");
						}
					}
				}
			}
		}
	}

	// better solution : Sieve_of_Eratosthenes O(nlog(log(n)))
	// reference:
	// http://www.algolist.net/Algorithms/Number_theoretic/Sieve_of_Eratosthenes
	public static void runEratosthenesSieve(int upperBound) {
		int upperBoundSquareRoot = (int) Math.sqrt(upperBound);
		boolean[] isComposite = new boolean[upperBound + 1];
		for (int m = 2; m <= upperBoundSquareRoot; m++) {
			if (!isComposite[m]) {
				System.out.print(m + " ");
				for (int k = m * m; k <= upperBound; k += m) {
					isComposite[k] = true;
				}
			}
		}
		for (int m = upperBoundSquareRoot + 1; m <= upperBound; m++) {
			if (!isComposite[m]) {
				System.out.print(m + " ");
			}
		}
	}

	public static void main(String[] args) {
		printPrime(121);
		System.out.println();
		runEratosthenesSieve(122);
	}
}
