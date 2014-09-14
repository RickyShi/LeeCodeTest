package Sort;

public class heapSortExample {
	private static int[] input = new int[] {16, 14, 10, 8, 7, 9, 3, 2, 4, 1}; 
	 
    public static void main(String[] args) { 
        //堆排�? 
        heapSort(); 
        //打�?�数组 
        printArray(); 
    } 
     
    /** 
     * 堆排�?，《算法导论》原文摘�?： 
     * The heapsort algorithm starts by using BUILD-MAX-HEAP to build a max-heap on the input 
     * array A[1  n], where n = length[A]. Since the maximum element of the array is stored at the 
     * root A[1], it can be put into its correct final position by exchanging it with A[n].  
     * If we now "discard" node n from the heap (by decrementing heap-size[A]), we observe that  
     * A[1  (n -1)] can easily be made into a max-heap. The children of the root remain max-heaps,  
     * but the new root element may violate the max-heap property. All that is needed to restore  
     * the maxheap property, however, is one call to MAX-HEAPIFY(A, 1), which leaves a max-heap  
     * in A[1 (n - 1)]. The heapsort algorithm then repeats this process for the max-heap of size  
     * n - 1 down to a heap of size 2. 
     * �?�?�度： 
     * 由之�?分�?�?�知，buildMaxHeap�?�?�度为O(n lg n)，�?行一次。 
     * maxHeapify的�?�?�度为O(lg n)，�?行n-1次。 
     * 综上，�?�?�度为O(n lg n)。 
     */ 
    private static void heapSort() { 
        int length = input.length; 
        //构造max-heap 
        buildMaxHeap(input, length);//交�?��?置 
        for (int i = length - 1; i > 0; i--) { 
            int temp = input[i]; 
            input[i] = input[0]; 
            input[0] = temp; 
            maxHeapify(input, 1, i); 
        } 
    } 
 
    private static void buildMaxHeap(int[] array, int heapSize) { 
        for (int i = heapSize / 2; i > 0; i--) { 
            maxHeapify(array, i, heapSize); 
        } 
    } 
     
    private static void maxHeapify(int[] array, int index, int heapSize) { 
        int l = index * 2; 
        int r = l + 1; 
        int largest; 
        //如果左�?��?节点索引�?于堆大�?，比较当�?值和左�?��?节点的值，�?�值大的索引值 
        if (l <= heapSize && array[l-1] > array[index-1]) { 
            largest = l; 
        } else { 
            largest = index; 
        } 
        //如果�?��?��?节点索引�?于堆大�?，比较�?��?��?节点和之�?比较得出的较大值，�?�大的索引值 
        if (r <= heapSize && array[r-1] > array[largest-1]) { 
            largest = r; 
        } 
        //交�?��?置，并继续递归调用该方法调整�?置。 
        if (largest != index) { 
            int temp = array[index-1]; 
            array[index-1] = array[largest-1]; 
            array[largest-1] = temp; 
            maxHeapify(array, largest, heapSize); 
        } 
    } 
     
    private static void printArray() { 
        for (int i : input) { 
            System.out.print(i + " "); 
        } 
    } 
}
