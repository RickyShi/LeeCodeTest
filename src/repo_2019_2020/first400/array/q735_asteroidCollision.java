package repo_2019_2020.first400.array;

import java.util.Arrays;
import java.util.Stack;

public class q735_asteroidCollision {
    /**
     * Approach #1: Stack [Accepted]
     * Intuition
     *
     * A row of asteroids is stable if no further collisions will occur.
     * After adding a new asteroid to the right, some more collisions may happen before it becomes stable again,
     * and all of those collisions (if they happen) must occur right to left.
     * This is the perfect situation for using a stack.
     */
    /**
     * Algorithm
     * <p>
     * Say we have our answer as a stack with rightmost asteroid top, and a new asteroid comes in.
     * If new is moving right (new > 0), or if top is moving left (top < 0), no collision occurs.
     * <p>
     * Otherwise, if abs(new) < abs(top), then the new asteroid will blow up;
     * if abs(new) == abs(top) then both asteroids will blow up;
     * and if abs(new) > abs(top),
     * then the top asteroid will blow up (and possibly more asteroids will, so we should continue checking.)
     */

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for (int ast : asteroids) {
            collision:
            {
                while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) {
                    if (stack.peek() < -ast) {
                        stack.pop();
                        continue;
                    } else if (stack.peek() == -ast) {
                        stack.pop();
                    }
                    break collision;
                }
                stack.push(ast);
            }
        }

        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;
    }

    /**
     * avoid use break to certain group
     */
    public int[] asteroidCollision2(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a:asteroids){
            if(a>0) stack.push(a);
            while(!stack.isEmpty()&&-a>stack.peek()&&stack.peek()>0){
                stack.pop();
            }
            if(!stack.isEmpty()&&-a==stack.peek()){
                stack.pop();
            }else if(stack.isEmpty()||stack.peek()<0){
                stack.push(a);
            }
        }
        int[] rtn = new int[stack.size()];
        for(int i = stack.size()-1;i>=0;i--){
            rtn[i]=stack.pop();
        }
        return rtn;
    }


    public static void main(String[] args) {
        q735_asteroidCollision test = new q735_asteroidCollision();
        int[] arr = new int[]{5, 10, -3};
        Arrays.stream(test.asteroidCollision(arr)).forEach(System.out::println);
    }
}
