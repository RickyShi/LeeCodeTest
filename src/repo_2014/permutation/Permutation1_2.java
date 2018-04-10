package repo_2014.permutation;

import java.util.ArrayList;

// time is less than permutation1
// space O(n)
public class Permutation1_2 {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> rtn = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		if (num == null) {
			return null;
		}
		// array to store visiting status
		boolean[] visited = new boolean[num.length];

		dfsWorker(num, rtn, temp, visited);
		return rtn;
	}

	private void dfsWorker(int[] num, ArrayList<ArrayList<Integer>> rtn, ArrayList<Integer> temp, boolean[] visited) {
		if (temp.size() == num.length) {
			rtn.add(new ArrayList<Integer>(temp));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			temp.add(num[i]);
			dfsWorker(num, rtn, temp, visited);
			temp.remove(temp.size() - 1);
			visited[i] = false;
		}
	}
}
