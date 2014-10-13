package pascalTriangle;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 *
 * For example, given k = 3,
 * Return [1,3,3,1].
 *
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 * @author Ricky
 *
 */
public class PascalTriangle2 {
	/**
	 * For O(K) Space
	 * 1 0 0 0 k = 0
	 * 1 1 0 0 k = 1
	 * 1 1 1 0
	 * 1 2 1 0 k = 2
	 * 1 2 1 1
	 * 1 2 3 1
	 * 1 3 3 1 k = 3
	 * 上述过程实际上就是一个in-place的迭代过程。每当生成下一行的时候，首先数组相应位置1，
	 *
	 * 然后从右向左计算每一个系数。
	 */

}
