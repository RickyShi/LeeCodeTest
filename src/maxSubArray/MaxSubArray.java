package maxSubArray;


public class MaxSubArray {
	/**
	 * Using DP O(n) subSum = preSum + A[i]； when preSum>=0;
	 *
	 * subSum = A[i]; when preSum<0;
	 *
	 * then preSubSum = subSum, if sumSum>max, then max=subSum.
	 *
	 * @param A
	 * @return
	 */
	public static int maxSubArray(int[] A) {
		if (A==null||A.length==0){
			return 0;
		}
		int max = A[0];
		int preSum = A[0];

		for (int i=1;i<A.length;i++){
			int subSum;
			if (preSum < 0) {
				subSum = A[i];
			} else {
				subSum = A[i] + preSum;
			}
			max = max < subSum ? subSum : max;
			preSum = subSum;
		}
		return max;
	}
	// O(n2)
	public static int maxSubArrayBAD(int[] A) {
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			int sum = 0;
			for (int k = i; k < A.length; k++) {
				sum += A[k];
				if (sum > max) {
					max = sum;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] a = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArrayBAD(a));
		System.out.print(maxSubArray(a));
	}
}
