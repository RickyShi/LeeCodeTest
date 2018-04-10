package repo_2014.singleNumber;

import java.util.HashMap;
import java.util.Set;

public class SingleNumber2HashMap {
	public int singleNumber(int[] A) {
		int rtn = -1;
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (int i : A) {

			if (hashMap.containsKey(i)) {
				hashMap.put(i, hashMap.get(i) + 1);
			} else {
				hashMap.put(i, 1);
			}
		}

		Set<Integer> keySet = hashMap.keySet();
		for (int key : keySet) {
			if (hashMap.get(key) == 1) {
				rtn = key;
				break;
			}
		}
		return rtn;
	}
}
