package repo_2019_2020.first400.array;

/**
 * Given a sorted list citations of size n in ascending order,
 * one is asked to find the first number citations[i] which meets the constraint of citations[i] >= n - i
 */
public class q275_h_index_2 {
    /**
     * Binary Search
     */
    public int hIndexBinarySearch(int[] citations) {
        int idx = 0, n = citations.length;
        int pivot, left = 0, right = n - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (citations[pivot] == n - pivot) return n - pivot;
            if (citations[pivot] < n - pivot) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return n - left;
    }

    public int hIndex(int[] citations) {
        int idx = 0, n = citations.length;
        for (int c : citations) {
            if (c >= n - idx) return n - idx;
            else idx++;
        }
        return 0;
    }

}
