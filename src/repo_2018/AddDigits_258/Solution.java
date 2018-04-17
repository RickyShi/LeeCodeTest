package repo_2018.AddDigits_258;

public class Solution {

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }

    public static int addDigits(int num) {
        if (num / 10 < 1) return num;
        return addDigits(num / 10 + num % 10);
    }

    /**
     * Explain, take 438 as an example
     * <p>
     * [Step 1]:
     * <p>
     * 438  == 40*10 +3*10 +8 ;
     * <p>
     * 4+3+8 == 4*(10%9)*(10%9)+3*(10%9)+8%9= 15   ;
     * [Step 2]:
     * <p>
     * 15  == 1*10 + 5 ;
     * <p>
     * 1+5 == 1*(10%9)+5%9= 6 ;
     * [So we can see]:
     * <p>
     * ab%9%9%9==ab%9;
     * <p>
     * just return num%9; and don't forget num==0 or num==9
     */
    public int addDigitsSmple(int num) {
        return num == 0 ? 0 : (num % 9 == 0 ? 9 : (num % 9));

    }
}
