package LinkedList;

public class MergTwoSortedLinkedLists {
}

class Solution_21 {
    public ListNode_21 mergeTwoLists(ListNode_21 list1, ListNode_21 list2) {
        ListNode_21 head = null;
        ListNode_21 cur = null;
        if (list1 == null||list2 == null) {
            return list1==null?list2:list1;
        }
        while (list1 != null && list2 != null) {
            if (head == null) {
                if (list1.val <= list2.val) {
                    head = list1;
                    cur = list1;
                    list1 = list1.next;
                }else  {
                    head = list2;
                    cur = list2;
                    list2 = list2.next;
                }
            }else {
                if (list1.val <= list2.val) {
                    cur.next = list1;
                    cur = cur.next;
                    list1 = list1.next;
                }else {
                    cur.next = list2;
                    cur = cur.next;
                    list2 = list2.next;
                }
            }
        }
        cur.next = list1 != null ? list1 : list2;
        return head;
    }
}

//  Definition for singly-linked list.
class ListNode_21 {
    int val;
    ListNode_21 next;

    ListNode_21() {
    }

    ListNode_21(int val) {
        this.val = val;
    }

    ListNode_21(int val, ListNode_21 next) {
        this.val = val;
        this.next = next;
    }

}
