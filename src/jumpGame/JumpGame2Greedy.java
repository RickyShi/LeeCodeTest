package jumpGame;

public class JumpGame2Greedy {

	public int jump(int[] A) {
		// Need to notice Length<=1
		if (A == null || A.length <= 1) {
			return 0;
		}

		// For type int array, the default value is zero, that is, 0.
		// The min steps could go to the current point
		int[] minSteps = new int[A.length];
		// The max place at current node could touch
		int max = 0;

		for (int i = 0; i < A.length; i++) {
			if (i > max) {
				return -1;
			}

			if (i + A[i] >= A.length - 1) {
				return minSteps[i] + 1;
			}

			if (i + A[i] > max) {
				for (int j = max + 1; j <= i + A[i]; j++) {
					minSteps[j] = minSteps[i] + 1;
				}
				max = i + A[i];
			}

		}
		return -1;
	}
}
