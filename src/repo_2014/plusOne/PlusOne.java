package repo_2014.plusOne;

/**
 * Given a non-negative number represented as an array of digits, plus one to
 * the number.
 *
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 *
 * @author Ricky
 *
 */
public class PlusOne {

	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return digits;
		}
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int digit = (digits[i] + carry) % 10;
			carry = (digits[i] + 1) / 10;
			digits[i] = digit;
			if (carry == 0) {
				return digits;
			}
		}
		int[] newDigits = new int[digits.length + 1];
		newDigits[0] = 1;
		return newDigits;
	}

	/**
	 * public int[] plusOneSoSo(int[] digits) {
	 * if (digits == null || digits.length == 0) {
	 * return digits;
	 * }
	 * for (int i = digits.length - 1; i >= 0; i--) {
	 * int num = digits[i] + 1;
	 * if (num <= 9) {
	 * digits[i]++;
	 * return digits;
	 * } else {
	 * if (i == 0) {
	 * int[] newDigits = new int[digits.length + 1];
	 * newDigits[0] = 1;
	 * newDigits[1] = 0;
	 * for (int k = 2; k < newDigits.length; k++) {
	 * newDigits[k] = digits[k - 1];
	 * }
	 * return newDigits;
	 * }
	 * digits[i] = 0;
	 * }
	 * }
	 * return digits;
	 * }
	 **/
}
