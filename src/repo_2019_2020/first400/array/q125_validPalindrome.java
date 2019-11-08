package repo_2019_2020.first400.array;

public class q125_validPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j) {

            while (i < s.length() && !isAlpha(s.charAt(i))) i++;
            while (j >= 0 && !isAlpha(s.charAt(j))) j--;
            if (i < j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            }

        }
        return true;
    }

    public boolean isAlpha(char s) {
        if ((s >= 'a' && s <= 'z') || (s >= '0' && s <= '9')) return true;
        return false;
    }

    public boolean isPalindrome2(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while (head < tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if (!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        q125_validPalindrome test = new q125_validPalindrome();
        System.out.println(test.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
