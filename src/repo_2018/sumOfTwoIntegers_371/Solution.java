package repo_2018.sumOfTwoIntegers_371;

public class Solution {

    /** Iterative */
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            //a & b is carry
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }

    /** Recursive */
    public int getSumRecursive(int a, int b) {
        return (b == 0) ? a : getSumRecursive(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args){
        int i = 8;
        System.out.println(i << 1);

        Solution solution = new Solution();
        System.out.println(solution.getSum(7,2));

    }
}
