package repo_2019_2020.first400.array;

import commonStructure.ListNode;


public class q21_megeTwoSortedList {
    /**
     * Iterative Way
     * The key to solve the problem is defining a fake head. Then compare the first
     * elements from each list. Add the smaller one to the merged list. Finally,
     * when one of them is empty, simply append it to the merged list, since it is
     * already sorted.
     *
     * @author Ricky
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(-1);
        ListNode preHead = fakeHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                preHead.next = l1;
                l1 = l1.next;
            } else {
                preHead.next = l2;
                l2 = l2.next;
            }
            preHead = preHead.next;
        }
        if (l1 != null) {
            preHead.next = l1;
        } else if (l2 != null) {
            preHead.next = l2;
        }
        return fakeHead.next;
    }

    /**
     * Recursive way
     *
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}
