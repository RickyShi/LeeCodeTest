package permutation;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [1,1,2], [1,2,1], and [2,1,1].
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//ref: http://fisherlei.blogspot.com/2012/12/leetcode-permutations-ii.html
public class Permutation2 {
	public List<List<Integer>> permuteUnique(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> rtn = new ArrayList<List<Integer>>();
		List<Integer> inList = new ArrayList<Integer>();
		boolean[] visited = new boolean[num.length];

		dfs(rtn, inList, num, visited);

		return rtn;
	}

	private static void dfs(List<List<Integer>> rtn, List<Integer> inList, int[] num, boolean[] visited) {
		if (inList.size() == num.length) {
			rtn.add(new ArrayList<Integer>(inList));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (visited[i] == true || (i > 0 && num[i] == num[i - 1] && visited[i - 1] == false)) {
				continue;
			}
			visited[i] = true;
			inList.add(num[i]);
			dfs(rtn, inList, num, visited);
			inList.remove(inList.size() - 1);
			visited[i] = false;
		}
	}
}
