package trappingRainWater;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 *
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *
 *
 * @author Ricky
 *
 */
public class TrappingRainWater {
	/**
	 * [解题思路]
	 * 核心思想是：对某个值A[i]来说，能trapped的最多的water取决于在i之前最高的值leftMostHeight[i]
	 * 和在i右边的最高的值rightMostHeight[i]。（均不包含自身）。如果min(left,right) >
	 * A[i]，那么在i这个位置上能trapped的water就是min(left,right) – A[i]。
	 *
	 * 对于任何一个坐标，检查其左右的最大坐标，然后相减就是容积。所以，
	 * 1. 从左往右扫描一遍，对于每一个坐标，求取左边最大值。
	 * 2. 从右往左扫描一遍，对于每一个坐标，求最大右值。
	 * 3. 再扫描一遍，求取容积并加和。
	 * #2和#3可以合并成一个循环，
	 */
	public static int trap(int[] A) {
		if (A == null || A.length <= 2) {
			return 0;
		}
		int[] leftMax = new int[A.length];
		int rtn = 0;
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			leftMax[i] = max;
			max = A[i] > max ? A[i] : max;

		}
		int rightMax = A[A.length - 1];
		for (int i = A.length - 2; i > 0; i--) {
			rightMax = rightMax > A[i] ? rightMax : A[i];
			int tempTrap = Math.min(leftMax[i], rightMax) - A[i];
			if (tempTrap > 0) {
				rtn += tempTrap;
			}
		}
		return rtn;
	}

	public static void main(String[] args){
		int[] a = { 2, 0, 2 };
		System.out.print(trap(a));
	}
}
