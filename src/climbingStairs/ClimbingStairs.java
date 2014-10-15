package climbingStairs;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * @author Ricky
 * 
 */
public class ClimbingStairs {
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
