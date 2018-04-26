package repo_2018.KthLargestElementInAnArray_215;

public class Solution {
    /** Classic QuickSelect Problem, descending problems*/

    public static void main(String[] args){
        Solution solution = new Solution();

        System.out.print(solution.findKthLargest(new int[]{9, 3, 2, 4, 6, 5,0}, 5)+ " ");
        for (int i=1;i<=7;i++) {
            System.out.print(solution.findKthLargest(new int[]{9, 3, 2, 4, 6, 5,0}, i)+ " ");
        }

        System.out.println();

        int[] array = {9, 8, 7, 6, 5, 0, 1, 2, 3, 4};
        for (int i = 1; i <= array.length; i++) {
            System.out.print(solution.findKthLargest(array, i)+ " ");
        }

        System.out.println();

        int[] array2 = {3,3,3,3,3,3,3,3,3};
        for (int i = 1; i <= array2.length; i++) {
            System.out.print(solution.findKthLargest(array2, i)+ " ");
        }
    }

    public int findKthLargest(int[] nums, int k) {
        if (k>nums.length) return -1;
        return quickSelect(nums, k-1, 0,nums.length-1);
    }

    public int quickSelect(int[] a, int k, int l, int r){
        if (l == r) { // If the list contains only one element,
            return a[l]; // return that element
        }
        int pivotIndex = partition(a, l ,r);
        if (k==pivotIndex) return a[pivotIndex];
        if (k>pivotIndex) return quickSelect(a, k ,pivotIndex+1,r);
        else return quickSelect(a, k ,l,pivotIndex-1);
    }

    public int partition(int[] a, int l, int r){
        int pivotValue = a[(l+r)/2];
        swap(a,(l+r)/2,r);
        int storeIndex = l;
        for (int i = 0;i<r;i++){
            if(a[i]>pivotValue){
                swap(a,i,storeIndex);
                storeIndex++;
            }
        }
        swap(a,storeIndex,r);
        return storeIndex;
    }


    public  void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
