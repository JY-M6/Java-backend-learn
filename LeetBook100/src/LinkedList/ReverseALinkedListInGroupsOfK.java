package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class ReverseALinkedListInGroupsOfK {
}
class Solution_25 {
    public ListNode reverseKGroup1(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;

        Map<Integer, ListNode> map = new HashMap<>();
        ListNode temp = head;
        int count = 0;

        // 存储所有节点到map中
        while (temp != null) {
            count++;
            map.put(count, temp);
            temp = temp.next;
        }

        // 如果节点数小于k，不反转
        if (count < k) return head;

        ListNode dummy = new ListNode(0);
        ListNode prevGroupEnd = dummy; // 上一组的尾节点

        // 处理每一组
        for (int j = 0; j < count / k; j++) {
            int startIndex = j * k + 1; // 当前组开始索引
            int endIndex = (j + 1) * k; // 当前组结束索引

            // 反转当前组
            for (int i = endIndex; i > startIndex; i--) {
                map.get(i).next = map.get(i - 1);
            }

            // 连接上一组到当前组
            prevGroupEnd.next = map.get(endIndex);

            // 更新上一组尾节点为当前组的尾节点（即反转前的头节点）
            prevGroupEnd = map.get(startIndex);

            // 设置当前组与下一组的连接
            if (j < count / k - 1) {
                // 如果不是最后一组，连接到下一组的头节点
                map.get(startIndex).next = map.get(endIndex + k);
            } else {
                // 如果是最后一组，连接到剩余节点或null
                map.get(startIndex).next = (endIndex < count) ? map.get(endIndex + 1) : null;
            }
        }

        return dummy.next;
    }

    //最优解
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode pre=dummy,end=dummy;
        while(end!=null){
            for(int i=0;i<k&&end!=null;i++){
                end=end.next;
            }
            if(end==null){
                break;
            }
            ListNode temp=end.next;
            end.next=null;
            ListNode start=pre.next;
            pre.next=reverse(start);
            start.next=temp;
            pre=start;
            end=start;
        }
        return dummy.next;
    }
    public ListNode reverse(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
}