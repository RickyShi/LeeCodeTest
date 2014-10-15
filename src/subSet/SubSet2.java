package subSet;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a collection of integers that might contain duplicates, S, return all
 * possible subsets.
 *
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,2], a solution is:
 *
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 *
 * @author Ricky
 *
 */
public class SubSet2 {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		if (num == null) {
			return null;
		}
		ArrayList<ArrayList<Integer>> rtn = new ArrayList<ArrayList<Integer>>();
		// case: [[]]
		rtn.add(new ArrayList<Integer>());
		ArrayList<Integer> inList = new ArrayList<Integer>();

		Arrays.sort(num);

		dfsWorker(num, 0, inList, rtn);
		return rtn;
	}

	private void dfsWorker(int[] num, int position, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> rtn) {

		for (int i = position; i < num.length; i++) {
			temp.add(num[i]);
			dfsWorker(num, i + 1, temp, rtn);

			temp.remove(temp.size() - 1);

			// skip duplicate elements to avoid duplicate subsets
			while (i < num.length - 1 && num[i] == num[i + 1]) {
				i++;
			}
		}
	}

	// just by knowing whether the set is already in list, not very good
	// compared to dfsworker()
	@SuppressWarnings("unused")
	private void dfsWorker2(int[] num, int position, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> rtn) {

		for (int i = position; i < num.length; i++) {
			temp.add(num[i]);
			dfsWorker(num, i + 1, temp, rtn);

			if (!rtn.contains(temp)) {
				rtn.add(new ArrayList<Integer>(temp));
			}
			temp.remove(temp.size() - 1);
		}
	}
}
