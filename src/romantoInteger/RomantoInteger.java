package romantoInteger;

/**
 * Roman defination: http://baike.baidu.com/view/42061.htm?fr=aladdin
 * 
 * @author Ricky
 * 
 */
public class RomantoInteger {
	private int getValueFromSingleRoman(char c) {
		int value;
		switch (c) {
		case 'I':
			value = 1;
			break;
		case 'V':
			value = 5;
			break;
		case 'X':
			value = 10;
			break;
		case 'L':
			value = 50;
			break;
		case 'C':
			value = 100;
			break;
		case 'D':
			value = 500;
			break;
		case 'M':
			value = 1000;
			break;
		default:
			value = 0;
			break;
		}
		return value;
	}

	private int[] setPreSum(int sum, int pre, char c) {
		int value = getValueFromSingleRoman(c);
		sum += value;
		if (pre < value) {
			sum -= 2 * pre;
		}
		pre = value;
		int[] keyPair = { sum, value };
		return keyPair;
	}

	public int romanToInt(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int pre = 0;
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int[] sumPre = setPreSum(sum, pre, ch);
			sum = sumPre[0];
			pre = sumPre[1];
		}
		return sum;
	}

	/**
	 * Not Good Looking; redundant code
	 * 
	 * @param s
	 * @return
	 */
	public int romanToIntBadLooking(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int pre = 0;
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == 'I') {
				sum += 1;
				pre = 1;
			} else if (ch == 'V') {
				sum += 5;
				if (pre < 5) {
					sum -= 2 * pre;
				}
				pre = 5;
			} else if (ch == 'X') {
				sum += 10;
				if (pre < 10) {
					sum -= 2 * pre;
				}
				pre = 10;
			} else if (ch == 'L') {
				sum += 50;
				if (pre < 50) {
					sum -= 2 * pre;
				}
				pre = 50;
			} else if (ch == 'C') {
				sum += 100;
				if (pre < 100) {
					sum -= 2 * pre;
				}
				pre = 100;
			} else if (ch == 'D') {
				sum += 500;
				if (pre < 500) {
					sum -= 2 * pre;
				}
				pre = 500;
			} else if (ch == 'M') {
				sum += 1000;
				if (pre < 1000) {
					sum -= 2 * pre;
				}
				pre = 1000;
			}
		}
		return sum;
	}
}
