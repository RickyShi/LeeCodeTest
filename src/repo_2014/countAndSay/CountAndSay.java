package repo_2014.countAndSay;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 *
 * Base case: n = 0 print "1"
 * for n = 1, look at previous string and write number of times a digit is seen
 * and the digit itself. In this case, digit 1 is seen 1 time in a row... so
 * print "1 1"
 * for n = 2, digit 1 is seen two times in a row, so print "2 1"
 * for n = 3, digit 2 is seen 1 time and then digit 1 is seen 1 so print
 * "1 2 1 1"
 * for n = 4 you will print "1 1 1 2 2 1" e.
 *
 * Note: The sequence of integers will be represented as a string.
 *
 * @author Ricky
 *
 */
public class CountAndSay {
	public String countAndSay(int n) {
        String s = "1";

        for (int i = 1; i<n; i++){
            int count=1;
            StringBuilder sb = new StringBuilder();
            for (int j=1;j<s.length();j++){
                if (s.charAt(j)==s.charAt(j-1)){
                    count++;
                } else {
                    sb.append(count).append(s.charAt(j-1));
                    count =1;
                }
            }
            sb.append(count).append(s.charAt(s.length()-1));
            s= sb.toString();
        }
        return s;
    }
}
