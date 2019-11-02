package repo_2019_2020.first400.array;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class q155_minStack {
    /**
     * Core Idea:
     * 1.Minimum value is always followed by the second minimum value (duplicate value of the second minimum value,
     * to ensure that when pop function removes the 2nd min, it does not disrupt the stack order).
     * 2.And while popping you pop min and 2nd min so that,
     * you get the correct min value for the remaining stack and the remaining stack top also points to the right place.
     */
    class MinStack {
        private Stack<Integer> stack;
        private int min;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            // only push the old minimum value when the current
            // minimum value changes after pushing the new value x
            if (x <= min) {
                stack.push(min);
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            // if pop operation could result in the changing of the current minimum value,
            // pop twice and change the current minimum value to the last minimum value.
            if (stack.pop() == min) {
                min = stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

    /**
     * Using PriorityQueue
     */
    class MinStack2 {
        PriorityQueue<Integer> min = new PriorityQueue<Integer>();
        LinkedList<Integer> stack = new LinkedList<Integer>();

        /**
         * initialize your data structure here.
         */
        public MinStack2() {

        }

        public void push(int x) {
            stack.push(x);
            min.add(x);
        }

        public void pop() {
            min.remove(stack.peek());
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }
}