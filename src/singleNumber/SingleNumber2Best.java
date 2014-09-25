package singleNumber;

public class SingleNumber2Best {
	public int singleNumber(int[] A) {
		int one = 0;
		int two = 0;
		int three = 0;
		for (int i = 0; i < A.length; i++) {
			three = (A[i] & two);
			two = two | (one & A[i]);
			one = one ^ A[i];
			one = one & (~three);
			two = two & (~three);
		}
		return one;
	}
}
