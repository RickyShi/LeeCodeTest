package repo_2019_2020.first400.array;

public class q198_houseRobber {
    public int rob(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for (int n: nums){
            int temp = currMax;
            currMax = Math.max(prevMax + n, currMax);
            prevMax = temp;
        }
        return  currMax;
    }
}
