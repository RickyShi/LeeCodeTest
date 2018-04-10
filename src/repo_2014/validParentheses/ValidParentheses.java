package repo_2014.validParentheses;

import java.util.HashMap;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 *
 * @author Ricky
 *
 */
public class ValidParentheses {

	public boolean isValid(String s) {
		// containing just the characters '(', ')', '{', '}', '[' and ']'
		// we could do sth below
		if (s.length() % 2 != 0) {
			return false;
		}
		Stack<Character> sk = new Stack<Character>();
		HashMap<Character, Character> hm = new HashMap<Character, Character>();
		hm.put('(', ')');
		hm.put('[', ']');
		hm.put('{', '}');
		char[] charArray = s.toCharArray();
		for (char c : charArray) {
			if (hm.containsKey(c)) { // left parentheses
				sk.push(c);
			} else { // right parentheses
				if (sk.isEmpty() || !hm.get(sk.pop()).equals(c)) {
					return false;
				}
			}
		}
		return sk.isEmpty();
	}
	public static boolean isValid2(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				stack.push(s.charAt(i));
			} else if (s.charAt(i) == ')') {
				if (stack.isEmpty() || !stack.pop().equals('(')) {
					return false;
				}
			} else if (s.charAt(i) == '}') {
				if (stack.isEmpty() || !stack.pop().equals('{')) {
					return false;
				}
			} else if (s.charAt(i) == ']') {
				if (stack.isEmpty() || !stack.pop().equals('[')) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.print(isValid2("()"));

	}
}
