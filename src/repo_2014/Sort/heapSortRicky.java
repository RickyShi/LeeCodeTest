package repo_2014.Sort;
/**
 * index from 0
 * left(i) = 2i + 1;
 * right(i) = 2i + 2;
 * parent(i) = (i-1)/2 (automatically choose roof of the int value)
 * @author Ricky
 *
 */
public class heapSortRicky {
	public int[] heapSort(int[] unSorted){
		buildMaxHeap(unSorted);		        
		for (int i=unSorted.length-1;i>0;i--){
			swap(unSorted,0,i);
			maxHeapify(unSorted, 0, i-1);
//			printArray("sort", unSorted);
		}
		return unSorted;
	}

	private void buildMaxHeap(int[] unSorted) {
		// keep calling Heapify from down to top
		for (int i=(unSorted.length-1)/2; i>=0; i--){
			maxHeapify(unSorted, i, unSorted.length-1);
//			printArray("maxHeap", unSorted);
		}
		
	}
	
	/**
	 * to make the sub-tree whose root is index to be the max heap
	 * By iterating the function from top to down
	 * @param subTree
	 * @param index
	 * @param lastIndex
	 */
	private void maxHeapify(int[] subTree, int index, int lastIndex) {
		int left = index*2 + 1;
		int right = left + 1;
		int largestIndex;
		if (left<=lastIndex && subTree[left]>subTree[index]){
			largestIndex = left;
		} else {
			largestIndex = index;
		}
		if (right<=lastIndex && subTree[right]>subTree[largestIndex]){
			largestIndex = right;
		}
		if (largestIndex != index){
			swap(subTree, index, largestIndex);
			maxHeapify(subTree, largestIndex, lastIndex);
		}
//		printArray("subtree max", subTree);
	}

	public void swap(int[] unSorted, int firstIndex, int anotherIndex){
		int temp = unSorted[firstIndex];
		unSorted[firstIndex] = unSorted[anotherIndex];
		unSorted[anotherIndex] = temp;
	}
	
	public String toString(int[] array){
		StringBuffer t = new StringBuffer();
		for (int e : array){
			t.append(e).append(",");
		}
		return t.substring(0, t.length()-1).toString();
	}
	
	public static void main(String[] args){
		heapSortRicky ex = new heapSortRicky();
		int[] unsorted = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51,-1};
		System.out.println(ex.toString(unsorted));
		int[] sorted = ex.heapSort(unsorted);		
		System.out.println(ex.toString(sorted));
	}
	
	public void printArray(String tag, int[] array){
		System.out.println(tag);
		for (int i : array) { 
            System.out.print(i + " "); 
        }
		System.out.print("\r\n");
	}
}
