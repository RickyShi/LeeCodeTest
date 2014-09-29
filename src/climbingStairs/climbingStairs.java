package climbingStairs;

public class climbingStairs {
	/**
	 * DP Solution num[n]=num[n-1]+num[n-2]; num[1]=1; num[2]=2;
	 * 
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {
		int prepre = 0;
		int pre = 1;
		for (int i = 1; i <= n; i++) {
			int sum = pre + prepre;
			prepre = pre;
			pre = sum;
		}
		return n <= 0 ? 0 : pre;
	}
}
