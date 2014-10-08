package jumpGame;

/**
 * Greedy Method 处理任何一个位置时，总是检测当前位置与当前位置前面的位置能够跳到的最远位置，
 *
 * 如果当前位置，小于前面位置能够跳到的最大位置，返回false
 *
 * 否则检查当前位置能够跳到比原来的最远位置更远的位置， 如果能，更新最远位置，如果最远位置已经达到了终点，返回true。
 *
 * @author Ricky
 *
 */
public class JumpGame1Greedy {
	public boolean canJump(int[] A) {
		if (A == null || A.length == 0) {
			return true;
		}
		int max = 0;
		for (int i=0;i<A.length;i++){
			if (max >=A.length-1){
				return true;
			}
			if (i > max) {
				return false;
			}
			if (i + A[i] > max) {
				max = i + A[i];
			}
		}
		return false;
	}
}
