package repo_2019_2020.first400.array;

import java.util.Arrays;

/**
 * Intuition
 * <p>
 * Think geometrically. Imagine plotting a histogram where the yy-axis represents the number of citations for each paper.
 * After sorting in descending order, hh-index is the length of the largest square in the histogram.
 */
public class q274_h_index {
    /**
     * Algorithm Comparison Sort
     * To find such a square length, we first sort the citations array in descending order.
     * After sorting, if \mathrm{citations}[i] \gt icitations[i]>i, then papers 00 to ii all have at least i + 1i+1 citations.
     * Thus, to find hh-index, we search for the largest ii (let's call it i') such that
     * citations[i]>i
     * and therefore the hh-index is i' + 1
     */
    public static int hIndexS1(int[] citations) {
        // sorting the citations in ascending order
        Arrays.sort(citations);
        // finding h-index by linear search
        int i = 0;
        while (i < citations.length && citations[citations.length - 1 - i] > i) {
            i++;
        }
        return i; // after the while loop, i = i' + 1
    }

    /**
     * However, in our problem, the keys are the citations of each paper which can be much larger than the number of papers nn.
     * It seems that we cannot use counting sort. The trick here is the following observation:
     * <p>
     * Any citation larger than nn can be replaced by nn and the hh-index will not change after the replacement
     * <p>
     * Apparently, cutting that area off will not change the largest square and the hh-index.
     * <p>
     * After we have the counts, we can get a sorted citations by traversing the counts array. And the rest is the same as Approach #1.
     * <p>
     * To explain this, let's look at the following example:
     * <p>
     * \mathrm{citations} = [1, 3, 2, 3, 100]citations=[1,3,2,3,100]
     * <p>
     * The counting results are:
     * <p>
     * kk	 0	1	2	3	4	5
     * count 0	1	1	2	0	1
     * s_k   5	5	4	3	1	1
     * <p>
     * The value s_k is defined as "the sum of all counts with citation \geq k≥k"
     * or "the number of papers having, at least, kk citations".
     * 注意 s_k[4] = s_k[5]+ count[4] = 1; s_k[3] = s_k[4]+count[3] = 1+2 = 3
     * By definition of the h-index, the largest k with k<= s_k is our answer.
     * <p>
     * After replacing 100100 with n = 5n=5, we have citations = [1, 3, 2, 3, 5]
     * Now, we count the number of papers for each citation number 0 to 5.
     * The counts are [0,1,1,2,0,1].
     * The first k from right to left (5 down to 0) that have k≤s_k is the h-index 3.
     */
    public static int hIndexCountingSort(int[] citations) {
        int n = citations.length;
        int[] counts = new int[n + 1];
        // counting papers for each citation number
        for (int c : citations) {
            counts[Math.min(n, c)]++;
        }
        // finding the h-index
        int k = n;
        for (int s = counts[n]; k > s; s += counts[k])
            k--;
        return k;
    }

    public static void main(String[] args) {
        int[] test = {10, 9, 3, 3, 1, 2, 5};
        System.out.println(hIndexS1(test));
    }
}
