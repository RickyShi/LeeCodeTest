package pascalTriangle;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> rtn = new ArrayList<List<Integer>>();
		List<Integer> inList = new ArrayList<Integer>();
		List<Integer> preInList = new ArrayList<Integer>();
		preInList.add(1);
		if (numRows == 0) {
			return rtn;
		}
		for (int i = 1; i <= numRows; i++) {
			for (int j = 0; j < i; j++) {
				if (j == 0 || j == i - 1) {
					inList.add(1);
				} else {
					inList.add(preInList.get(j - 1) + preInList.get(j));
				}
			}
			preInList.clear();
			preInList.addAll(inList);
			rtn.add(inList);
			// Could not use inList.clear();
			// It will clear the lnList stored in rtn and preInList
			inList = new ArrayList<Integer>();
		}

		return rtn;
	}
}
