package singleNumber;

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
}
