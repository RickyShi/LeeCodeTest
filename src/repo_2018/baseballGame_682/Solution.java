package repo_2018.baseballGame_682;

import java.util.Stack;

public class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String s: ops){
            if (s.equals("D")){
                stack.push(stack.peek()*2);
            } else if (s.equals("C")){
                stack.pop();
            } else if (s.equals("+")){
                int t1 = stack.pop();
                int newTop = t1+stack.peek();
                stack.push(t1);
                stack.push(newTop);
            } else{
                stack.push(Integer.valueOf(s));
            }
        }
        int rtn = 0;
        for (int i: stack){
            rtn +=i;
        }
        return rtn;
    }
}
