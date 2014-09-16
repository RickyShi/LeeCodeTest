package sortList;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/**
 * Using Merge Sort
 * @author Ricky
 */
public class SortList {
	 public ListNode sortList(ListNode head) {
	        if (head==null||head.next==null){
	            return head;
	        }
	    
	    //find the middle place using the runner tech
	    ListNode fast = head, slow = head;   
	    while(fast.next!=null && fast.next.next!=null){
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	        fast = slow.next;
	        slow.next = null;
	    //recursive
	    ListNode l = sortList(head);
	    ListNode r = sortList(fast);
	    
	    return merge(l,r);
	    }
	    
	    public ListNode merge(ListNode l, ListNode r){
	        if (l==null)
	            return r;
	        else if (r==null)
	            return l;
	        
	        ListNode rtn;
	        if (l.val<r.val){
	            rtn = l;
	            l = l.next;
	        } else{
	            rtn = r;
	            r = r.next;
	        }
	        ListNode tmp = rtn;
	        while (l!=null && r!=null){
	            if (l.val < r.val){
	                tmp.next = l;
	                tmp = tmp.next;
	                l = l.next;
	            } else {
	                tmp.next = r;
	                tmp = tmp.next;
	                r = r.next;
	            }
	        }
	        tmp.next = (r==null)? l : r;
	    return rtn;
	    }
}
