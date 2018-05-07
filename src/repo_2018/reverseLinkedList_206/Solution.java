package repo_2018.reverseLinkedList_206;

import repo_2018.commonStructure.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode nextTmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTmp;
        }
        return prev;
    }

    public ListNode reverseListRecursive(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode t = reverseList(head.next);
        head.next.next = head;
        head.next = null;//This is important
        return t;
    }
}
