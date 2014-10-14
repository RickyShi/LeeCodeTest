package subSet;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 *
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 * @author Ricky
 *
 */
public class SubSet1 {
	// reference: http://www.binglu.me/subsets-leetcode/
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		if (S == null) {
			return null;
		}
		ArrayList<ArrayList<Integer>> rtn = new ArrayList<ArrayList<Integer>>();
		// empty set is the subset of any set
		rtn.add(new ArrayList<Integer>());

		// sort array to statisfy the requirement of non-descending order
		Arrays.sort(S);

		dfsWorker(S, 0, rtn, new ArrayList<Integer>());

		return rtn;
	}

	@SuppressWarnings("unchecked")
	private void dfsWorker(int[] S, int position, ArrayList<ArrayList<Integer>> rtn, ArrayList<Integer> temp) {
		for (int i = 0; i < S.length; i++) {
			temp.add(S[i]);

			// call dfsWorker() recursively
			dfsWorker(S, i + 1, rtn, temp);

			rtn.add((ArrayList<Integer>) temp.clone());
			temp.remove(S[i]);
		}
	}
}
