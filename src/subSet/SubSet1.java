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

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		// empty set is the subset of any set
		result.add(new ArrayList<Integer>());

		// sort array to statisfy the requirement of non-descending order
		Arrays.sort(S);

		dfsWorker(S, 0, result, new ArrayList<Integer>());

		return result;
	}

	@SuppressWarnings("unchecked")
	public void dfsWorker(int[] S, int position, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp) {
		for (int i = position; i < S.length; i++) {
			temp.add(S[i]);

			// call dfsWorker() recursively
			dfsWorker(S, i + 1, result, temp);
			result.add((ArrayList<Integer>) temp.clone());
			// remove current element from temp before next interation
			temp.remove(temp.size() - 1);
		}
	}
}
