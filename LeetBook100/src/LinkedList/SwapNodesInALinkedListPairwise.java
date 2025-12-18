package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class SwapNodesInALinkedListPairwise {
}

class Solution_24 {
    //hashmap
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) return head;
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            map.put(count, temp);
            temp = temp.next;
        }
        temp = head;
        ListNode h = null;
        ListNode t = null;
        for (int i = 1, j = 2; j <= count; i += 2, j += 2) {
            if (i == 1) {
                h = map.get(j);
                h.next = map.get(i);
                t = h.next;
            } else {
                t.next = map.get(j);
                t.next.next = map.get(i);
                t = t.next.next;
            }
        }
        if (count % 2 == 1) {
            t.next = map.get(count);
        } else {
            t.next = null;
        }
        return h;
    }

    //哑元节点
    public ListNode_24 swapPairs2(ListNode_24 head) {
        ListNode_24 dummy = new ListNode_24(-1, head);
        ListNode_24 cur = dummy;
        ListNode_24 firstNode;
        ListNode_24 secondNode;
        while (cur.next != null && cur.next.next != null) {
            ListNode_24 next = cur.next.next.next;
            firstNode = cur.next;
            secondNode = cur.next.next;
            cur.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = next;
            cur = firstNode;
        }
        return dummy.next;
    }
}

class ListNode_24 {
    int val;
    ListNode_24 next;

    ListNode_24() {
    }

    ListNode_24(int val) {
        this.val = val;
    }

    ListNode_24(int val, ListNode_24 next) {
        this.val = val;
        this.next = next;
    }
}