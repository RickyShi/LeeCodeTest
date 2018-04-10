package repo_2014.jumpGame;

public class JumpGame1DP {
	/**
	 * 一维DP，定义 jump[i]为从index 0 走到第i步时，剩余的最大步数。
	 *
	 * 那么转移方程可定义为 jump[i] = max(jump[i-1], A[i-1]) -1, i!=0 = 0 , i==0
	 *
	 * @param A
	 * @return
	 */
	public boolean canJumpDP(int[] A) {
		if (A == null || A.length == 0) {
			return true;
		}
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

	/**
	 * maxCover: max length one node could go
	 *
	 * @param A
	 * @return
	 */
	public boolean canJumpDPEasy(int[] A) {
		if (A == null || A.length == 0) {
			return true;
		}
		int maxCover = 0;
		for (int start = 0; start <= maxCover && start < A.length; start++) {
			if (A[start] + start > maxCover) {
				maxCover = A[start] + start;
			}
			if (maxCover >= A.length - 1) {
				return true;
			}
		}
		return false;
	}
}
