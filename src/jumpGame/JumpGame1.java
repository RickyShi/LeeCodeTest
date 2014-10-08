package jumpGame;

public class JumpGame1 {
	/**
	 * 一维DP，定义 jump[i]为从index 0 走到第i步时，剩余的最大步数。
	 *
	 * 那么转移方程可定义为 jump[i] = max(jump[i-1], A[i-1]) -1, i!=0 = 0 , i==0
	 *
	 * @param A
	 * @return
	 */
	public boolean canJumpDP(int[] A) {
		int[] canJumpSteps = new int[A.length];
		canJumpSteps[0] = 0;
		for (int i = 1; i < A.length; i++) {
			canJumpSteps[i] = Math.max(canJumpSteps[i - 1], A[i - 1]) - 1;
			if (canJumpSteps[i] < 0) {
				return false;
			}
		}
		return canJumpSteps[A.length - 1] >= 0;
	}

}
