package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CircularLinkedList_2 {
}
class Solution_142 {
    public ListNode detectCycle_1(ListNode head) {
        int pos=-1;
        if(head == null) return null;
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode temp = head;
        int label=0;
        while(temp != null) {
            if(map.containsKey(temp)) {
                pos=map.get(temp);
                return temp;
            }
            map.put(temp, label++);
            temp = temp.next;
        }
        return temp;
    }

    //最优解
    public ListNode detectCycle_2(ListNode head) {
        ListNode fastNode=head;
        ListNode slowNode=head;
        while(fastNode!=null&&fastNode.next!=null){

            fastNode=fastNode.next.next;
            slowNode=slowNode.next;
            if(fastNode==slowNode){
                ListNode index=head;
                while(index!=slowNode){
                    index=index.next;
                    slowNode=slowNode.next;
                }
                return slowNode;
            }


        }
        return null;
    }
}