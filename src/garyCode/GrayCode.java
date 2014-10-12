package garyCode;

import java.util.ArrayList;

/**
 * The gray code is a binary numeral system where two successive values differ
 * in only one bit.
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 *
 * @author Ricky
 *
 */
public class GrayCode {
	/**
	 * 以3位格雷码为例。
	 * 0 0 0
	 * 0 0 1
	 * 0 1 1
	 * 0 1 0
	 * 1 1 0
	 * 1 1 1
	 * 1 0 1
	 * 1 0 0
	 * 可以看到第n位的格雷码由两部分构成，一部分是n-1位格雷码，再加上 1<<(n-1)和n-1位格雷码的逆序的和。
	 * 
	 * @param n
	 * @return
	 */
	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (n == 0) {
			result.add(0);
			return result;
		}

		ArrayList<Integer> tmp = grayCode(n - 1);
		int addNumber = 1 << (n - 1);
		result.addAll(tmp);
		for (int i = tmp.size() - 1; i >= 0; i--) {
			result.add(addNumber + tmp.get(i));
		}
		return result;
	}
}
