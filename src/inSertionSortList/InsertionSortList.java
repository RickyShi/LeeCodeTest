package inSertionSortList;


class ListNode {
	int val;
	ListNode next;
	ListNode(int x){
		this.val = x;
		this.next = null;
	}
}
/**
 * Insertion Sort Node 1
 * @author Ricky
 *
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
        ListNode newHead = head;
        if (head == null)
        return head;
        
        ListNode nextInsertNode = head.next;
        newHead.next = null;
        
        // loop through each element in the list
        while(nextInsertNode != null){
        	// insert this element to the new list
            ListNode bigNode = newHead;
            ListNode preNode = null;
            
            while(bigNode != null){
                if (bigNode.val>nextInsertNode.val)
                break;
                preNode = bigNode;
                bigNode = bigNode.next;
            }
            ListNode newNode = nextInsertNode;
            nextInsertNode = nextInsertNode.next;
            if (preNode==null){
                newNode.next = newHead;
                newHead = newNode;
            } else{
                preNode.next=newNode;
                newNode.next=bigNode;
            }
        }
        return newHead;
    }
}
