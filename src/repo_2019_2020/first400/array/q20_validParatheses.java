package repo_2019_2020.first400.array;

import java.util.Stack;

public class q20_validParatheses {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) return true;
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.empty()) return false;
                char pop = stack.pop();
                if (c == ')' && pop != '(') return false;
                if (c == '}' && pop != '{') return false;
                if (c == ']' && pop != '[') return false;
            }
        }
        return stack.empty();
    }
}
