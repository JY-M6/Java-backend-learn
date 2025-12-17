package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class DeleteSpecificNodes {
}
class Solution_19 {
    //hashmap遍历
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if(head==null) return null;
        else if(head.next==null&&n==1) return null;
        else if(head.next==null&&n==0) return head;
        Map<Integer,ListNode> map=new HashMap<>();
        int num=1;
        ListNode temp=head;
        while(temp!=null){
            map.put(num,temp);
            temp=temp.next;
            num++;
        }
        if(n==num-1) return head.next;
        ListNode list1= map.get(num-n-1);
        list1.next=map.get(num-n).next;
        return head;
    }

    //先计数再用伪结点删除
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        for (int i = 0; i < n + 1; i++) {
            p = p.next;
        }
        ListNode p2 = dummy;
        while (p != null) {
            p2 = p2.next;
            p = p.next;
        }

        p2.next = p2.next.next;
        return dummy.next;
    }
}