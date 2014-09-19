package singleNumber;

import java.util.HashMap;
import java.util.Set;

public class SingleNumber {
	/**
	 * Use XOR to implement a linear runtime complexity, without using extra
	 * memory
	 *
	 * @param A
	 * @return
	 */
	public int singleNumber(int[] A) {
		int result = 0;
		for (int i : A) {
			result = result ^ i;
		}
		return result;
	}

	/**
	 * hashMap
	 */
	public int singleNumberHashMap(int[] A) {
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (int i : A) {
			if (hashMap.containsKey(i)) {
				hashMap.put(i, hashMap.get(i) + 1);
			} else {
				hashMap.put(i, 1);
			}
		}
		Set<Integer> keySet = hashMap.keySet();
		int k=-1;
		for (Integer k1 : keySet){
		    if (hashMap.get(k1)==1){
		    	k = k1;
		        break;
		    }
		}
		return k;
	}
}
