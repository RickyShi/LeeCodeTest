package combinations;

import java.util.ArrayList;

/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 *
 * For example,
 * If n = 4 and k = 2, a solution is:
 *
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 *
 * @author Ricky
 *
 */
public class Combinations {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> rtn = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> inList = new ArrayList<Integer>();

		if (k <= 0 || n <= 0 || n < k) {
			return null;
		}

		dfsWorker(rtn, inList, n, k, 1);

		return rtn;
	}

	private void dfsWorker(ArrayList<ArrayList<Integer>> rtn, ArrayList<Integer> inList, int n, int k, int start) {
		if (inList.size() == k) {
			rtn.add(new ArrayList<Integer>(inList));
			return;
		}

		for (int i = start; i <= n; i++) {
			inList.add(i);
			dfsWorker(rtn, inList, n, k, i + 1);
			inList.remove(inList.size() - 1);
		}
		}
}
