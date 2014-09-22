package reverseInteger;

import java.util.Stack;

public class ReverseInteger {

	public int reverseEasy(int x) {
		int reverse = 0;
		while (x != 0) {
			reverse = reverse * 10 + x % 10;
			x /= 10;
		}
		return reverse;
	}

	/**
	 * complex way
	 * 
	 * @param x
	 * @return
	 */
	public int reverse(int x) {
		Stack<String> stack = new Stack<String>();
		String reverse = "";
		int rtn;
		String ori = String.valueOf(x);
		if (x >= 0) {
			for (int i = 0; i < ori.length(); i++) {
				stack.add(ori.substring(i, i + 1));
			}
			while (!stack.isEmpty()) {
				reverse += stack.pop();
			}
			rtn = Integer.parseInt(reverse);
		} else {
			for (int i = 1; i < ori.length(); i++) {
				stack.add(ori.substring(i, i + 1));
			}

			while (!stack.isEmpty()) {
				reverse += stack.pop();
			}
			rtn = 0 - Integer.parseInt(reverse);
		}
		return rtn;
	}

	public static void main(String[] args) {
		ReverseInteger r = new ReverseInteger();
		System.out.println(r.reverse(231));
		System.out.println(r.reverse(0));
		System.out.println(r.reverse(-231));
		System.out.println(r.reverseEasy(231));
		System.out.println(r.reverseEasy(0));
		System.out.println(r.reverseEasy(-231));
	}
}
