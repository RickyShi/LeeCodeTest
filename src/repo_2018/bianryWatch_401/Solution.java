package repo_2018.bianryWatch_401;

import java.util.ArrayList;
import java.util.List;

/**
 * backTracking Problem 回溯法
 */
class Solution {

    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int[] a1 = new int[]{8, 4, 2, 1};
        int[] a2 = new int[]{32, 16, 8, 4, 2, 1};

        for (int i = 0; i <= num; i++) {
            List<Integer> ls1 = genDigits(a1, i);
            List<Integer> ls2 = genDigits(a2, num - i);
            for (int i1 : ls1) {
                if (i1 > 11) continue;
                for (int i2 : ls2) {
                    if (i2 > 59) continue;
                    res.add(i1 + ":" + (i2 < 10 ? "0" + i2 : i2));
                }
            }
        }
        return res;
    }

    public List<Integer> genDigits(int[] digits, int count) {
        List<Integer> res = new ArrayList<>();
        helper(res, digits, count, 0, 0);
        return res;
    }

    public void helper(List<Integer> res, int[] digits, int count, int start, int sum) {
        if (count == 0) {
            res.add(sum);
            return;
        }
        for (int i = start; i < digits.length; i++) {
            helper(res, digits, count - 1, i + 1, sum + digits[i]);
        }
    }

}

class SolutionRicky {

    String[][] hour = {{"0"},
            {"1", "2", "4", "8"},
            {"3", "5", "6", "9", "10"},
            {"7", "11"}};
    String[][] minute = {{"00"},
            {"01", "02", "04", "08", "16", "32"},
            {"03", "05", "06", "09", "10", "12", "17", "18", "20", "24", "33", "34", "36", "40", "48"},
            {"07", "11", "13", "14", "19", "21", "22", "25", "26", "28", "35", "37", "38", "41", "42", "44", "49", "50", "52", "56"},
            {"15", "23", "27", "29", "30", "39", "43", "45", "46", "51", "53", "54", "57", "58"},
            {"31", "47", "55", "59"}};

    public List<String> readBinaryWatch(int num) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i <= 3 && i <= num; i++) {
            if (num - i <= 5) {
                for (String str1 : hour[i]) {
                    for (String str2 : minute[num - i]) {
                        ret.add(str1 + ":" + str2);
                    }
                }
            }
        }
        return ret;
    }

}
