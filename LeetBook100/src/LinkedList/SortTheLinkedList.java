package LinkedList;

import java.util.Arrays;

public class SortTheLinkedList {

}
class Solution_148 {
    //归并分治
    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode left = sortList1(head);
        ListNode right = sortList1(slow);

        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 != null) curr.next = l1;
        if (l2 != null) curr.next = l2;

        return dummy.next;
    }

    //2.把节点放入到数组然后进行排序最后链接
    public ListNode sortList2(ListNode head) {
        if(head == null || head.next == null){
        return head;
    }
    int length = 0,i= 0;
    ListNode pre = head;
        while(pre!= null){
        length++;
        pre = pre.next;
    }
    pre = head;
    ListNode[] arrayNode = new ListNode[length];
        while(pre!= null){
        arrayNode[i++] = pre;
        pre = pre.next;
    }
    //对数组节点进行排序
        Arrays.sort(arrayNode,(a,b)->a.val-b.val);
    pre = arrayNode[0];
        for(i = 0;i<length-1;i++){
        arrayNode[i].next = arrayNode[i+1];
    }
    arrayNode[i].next = null;
        return pre;
}
}
