package generateParenthese;

import java.util.ArrayList;

public class GenerateParenthese_2 {
	/**
	 * 一种新的写法，left，right表示手上有的左右括号括号数量。因此条件要改变一些。
	 * 
	 * @param n
	 * @return
	 */
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> ret = new ArrayList<String>();
		rec(n, n, "", ret);
		return ret;
	}

	public void rec(int left, int right, String s, ArrayList<String> ret) {
		if (left == 0 && right == 0) {
			ret.add(s);
			return;
		}
		if (left == 0) {
			rec(left, right - 1, s + ")", ret);
			return;
		}
		if (right == 0) {
			return;
		}
		if (left > right) {
			return;
		}
		rec(left - 1, right, s + "(", ret);
		rec(left, right - 1, s + ")", ret);
	}
}
