package maxSubArrayDivideConquer;

public class MaxSubArray {
	/**
	 * Divide_Conquer O(nlgn)
	 *
	 * 1、计算[left,middle]最大值
	 *
	 * 2、计算[middle+1,right]最大值
	 *
	 * 3、计算[left,right]包含中间点middle的序列最大和
	 *
	 * 4、返回三个和中最大的那个。
	 *
	 * @param A
	 * @return
	 */
	public int maxSubArray(int[] A) {
		if (A.length < 1 || A == null) {
			return 0;
		}
		return subMax(A, 0, A.length - 1);
	}

	int subMax(int A[],int left,int right){
	        if(left==right){
	            return A[left];
	        }
		int middle = (left + right) / 2;
		int leftMaxSum = subMax(A, left, middle);
		int rightMaxSum = subMax(A, middle + 1, right);
		int sum = 0;
		// int rightSum = Integer.MIN_VALUE;
		// int leftSum = Integer.MIN_VALUE;
		int leftSum = A[middle];
		int rightSum = A[middle + 1];

		// 包含middle+1右边的最大值
		for (int i = middle + 1; i <= right; i++) {
			sum += A[i];
			rightSum = rightSum > sum ? rightSum : sum;
		}
		sum = 0;
		// 包含middle左边的最大值
		for (int j = middle; j >= left; j--) {
			sum += A[j];
			leftSum = leftSum > sum ? leftSum : sum;
		}
		// 取三者最大值
		return Math.max(leftSum + rightSum, Math.max(leftMaxSum, rightMaxSum));
	}
}
