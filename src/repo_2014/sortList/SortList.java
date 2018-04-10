package repo_2014.sortList;
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
 * Using Merge repo_2014.Sort
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
	   
	    /**
	     * Using QuickSort
	     * @param head
	     * @return
	     */
	    public ListNode sortList2(ListNode head) {
	        if (head == null) {
				return null;
			}
			if(head.next==null){
				return head;
			}
			
			int val = head.val;
			ListNode preChangeLast = null;
			ListNode changeLast = head;
			ListNode nextNode = head.next;
			while (nextNode != null) {
				if (nextNode.val < val) {
					if (nextNode.val != changeLast.next.val) {
						int ex = nextNode.val;
						nextNode.val = changeLast.next.val;
						changeLast.next.val = ex;
					}
					preChangeLast = changeLast;
					changeLast = changeLast.next;
				}
				nextNode = nextNode.next;
			}
			int ex = changeLast.val;
			changeLast.val = val;
			head.val = ex;
			ListNode nextLeft = changeLast.next;
			while(nextLeft!=null){
				if(nextLeft.val>changeLast.val){
					break;
				}
				nextLeft=nextLeft.next;
			}
			if(nextLeft!=null&&nextLeft.next!=null){
				sortList(nextLeft);
			}
			if(preChangeLast!=null){
				preChangeLast.next=null;
				sortList(head);
				preChangeLast.next = changeLast;
			}
			return head;
	    }
}
