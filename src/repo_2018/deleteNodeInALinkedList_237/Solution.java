package repo_2018.deleteNodeInALinkedList_237;

import repo_2018.commonStructure.ListNode;

public class Solution {
    public void deleteNode(ListNode node) {
        if(node==null) return;
        //node.next!=null (except the tail)
        node.val = node.next.val;
        node.next= node.next.next;
    }
}
