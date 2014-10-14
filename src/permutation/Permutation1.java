package permutation;

import java.util.ArrayList;

/**
 * Given a collection of numbers, return all possible permutations.
 *
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 *
 * @author Ricky
 *
 */
public class Permutation1 {
	/**
	 * Another good practice of DFS.
	 * 
	 * After several practices of DFS, I found that most of DFS questions can be
	 * solved in the same framework:
	 * --------------------------------------------------------------
	 * Find out the “exit” of DFS, namely, how can we end the dfs
	 * Recursively call the dfsWorker() function to solve a smaller sub-question
	 * Inside, the dfsWorker() function, we always do the same things:
	 * 
	 * pre-process: assign new values to variables, reduce the size of original
	 * question
	 * call dfsWorker() function
	 * post-precess: do some work to prepare to return to a higher level calling
	 * ----------------------------------------------------------------
	 * 
	 * reference: http://www.binglu.me/permutation-leetcode/
	 * 
	 * @param num
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> rtn = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();

		if (num == null) {
			return null;
		}

		dfsWorker(num, rtn, temp);
		return rtn;
	}

	private void dfsWorker(int[] num, ArrayList<ArrayList<Integer>> rtn, ArrayList<Integer> temp) {
		if (temp.size() == num.length) {
			rtn.add(new ArrayList<Integer>(temp));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (temp.contains(num[i])) {
				continue;
			}
			temp.add(num[i]);
			dfsWorker(num, rtn, temp);
			temp.remove(temp.size() - 1);
		}
	}
}
