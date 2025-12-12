package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CircularLinkedList {

}
class Solution_141 {
    public boolean hasCycle_1(ListNode head) {
        int pos=-1;
        if(head == null) return false;
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode temp = head;
        int label=0;
        while(temp != null) {
            if(map.containsKey(temp)) {
                pos=map.get(temp);
                return true;
            }
            map.put(temp, label++);
            temp = temp.next;
        }
        return false;
    }
    //官解（快慢指针）
    public boolean hasCycle_2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        return true;
    }
}