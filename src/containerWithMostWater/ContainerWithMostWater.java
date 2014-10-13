package containerWithMostWater;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container.
 *
 * @author Ricky
 *
 */
public class ContainerWithMostWater {
	/**
	 * Two point move to middle
	 * 
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {
		int l = 0, r = height.length - 1;
		int max = (Math.min(height[l], height[r])) * (r - l);
		while (l < r) {
			if (height[l] < height[r]) {
				l++;
				if (height[l] < height[l - 1]) {
					continue;
				}

			} else {
				r--;
				if (height[r] < height[r + 1]) {
					continue;
				}
			}
			max = Math.max(max, (Math.min(height[l], height[r])) * (r - l));
		}
		return max;
	}
}
