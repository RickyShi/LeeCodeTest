package repo_2014.roman_Integer;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author Ricky
 * 
 */
public class IntegerToRoman {
	public static String intToRoman(int num) {
		String symbol = "IVXLCDM", ret = "";
		int div = 1000;
		for (int i = 6; i >= 0; i -= 2) {
			int tmp = num / div;
			if (tmp == 0) {
				div /= 10;
				continue;
			}
			if (tmp <= 3) {
				for (int k = 0; k < tmp; k++) {
					ret = ret.concat(String.valueOf(symbol.charAt(i)));
				}
			} else if (tmp == 4) {

				ret = ret.concat(String.valueOf(symbol.charAt(i)));
				ret = ret.concat(String.valueOf(symbol.charAt(i + 1)));

			} else if (tmp == 5) {
				ret = ret.concat(String.valueOf(symbol.charAt(i + 1)));
			} else if (tmp <= 8) {
				ret = ret.concat(String.valueOf(symbol.charAt(i + 1)));
				for (int k = 0; k < tmp - 5; k++) {
					ret = ret.concat(String.valueOf(symbol.charAt(i)));
				}

			} else {
				ret = ret.concat(String.valueOf(symbol.charAt(i)));
				ret = ret.concat(String.valueOf(symbol.charAt(i + 2)));
			}
			num = num % div;
			div = div / 10;
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.print(intToRoman(1));
	}
}
