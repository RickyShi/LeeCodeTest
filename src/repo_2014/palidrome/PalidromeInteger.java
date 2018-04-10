package repo_2014.palidrome;

public class PalidromeInteger {
	/**
	 * Reverse and see whether they are the same
	 * 
	 * @param x
	 * @return
	 */
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int target = x;
		int reverse = 0;
		int curNum = target;
		while (curNum != 0) {
			reverse = 10 * reverse + curNum % 10;
			curNum /= 10;
		}
		return reverse == target;
	}

	/**
	 * Compare First and last till the middle
	 * 
	 * @param x
	 * @return
	 */
	public boolean isPalindrome2(int x) {
		if (x < 0) {
			return false;
		}
		int rightBase = 1;
		while (x / rightBase >= 10) {
			rightBase *= 10;
		}
		while (x > 0) {
			int right = x / rightBase;
			int left = x % 10;
			x = x - right * rightBase;
			x = x / 10;
			rightBase = rightBase / 100;
			if (right != left) {
				return false;
			}
		}
		return true;
	}
}
