package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class MergeKAscendingLinkedLists {
    public static void main(String[] args) {
        ListNode[] lists ={new ListNode(1,new ListNode(4,new ListNode(5))),
                new ListNode(1,new ListNode(3,new ListNode(4))),
                new ListNode(2,new ListNode(6)),};
        Solution_23 solution_23 = new Solution_23();
        solution_23.mergeKLists1(lists);
        for (ListNode node : lists) {
            while (node != null) {
                System.out.print(node.val + " ");
                node = node.next;
            }
        }
    }
}

class Solution_23 {
    //循环暴力解法
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode[] cur = lists;
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        for (int i = 0; i < cur.length; i++) {
            if (i == 0) {
                temp.next = cur[i];
            }
            temp = dummy;
            while (i != 0 && cur[i] != null) {
                ListNode next = null;
                if(cur[i].next != null){
                next = cur[i].next;
                }
                if(temp.next != null){
                temp = cur[i].val < temp.next.val ? InsertNode(temp, cur[i]) : temp.next;
                if (temp == cur[i] && next != null) {
                    cur[i] = next;
                } else if (temp == cur[i] && next == null) {
                    cur[i] = null;
                }
                }else{
                    temp.next = cur[i];
                }
            }
        }
        return dummy.next;
    }

    public ListNode InsertNode(ListNode head, ListNode newNode) {
        newNode.next = head.next;
        head.next = newNode;
        return newNode;
    }

        //分治
        public ListNode mergeKLists2(ListNode[] lists) {
            if(lists.length < 1)return null;

            while(lists.length > 1){
                List<ListNode> list = new ArrayList();

                for(int i = 0; i < lists.length; i += 2){
                    ListNode first = lists[i];
                    ListNode second = null;
                    if(i + 1< lists.length){
                        second = lists[i + 1];
                    }

                    list.add(mergeTwo(first, second));
                }

                lists = list.toArray(new ListNode[0]);
            }

            return lists[0];
        }

        public ListNode mergeTwo(ListNode first, ListNode second){
            ListNode dummy = new ListNode();
            ListNode next = dummy;

            while(first != null && second != null){
                if(first.val < second.val){
                    next.next = first;
                    first = first.next;
                }else{
                    next.next = second;
                    second = second.next;
                }
                next  = next.next;
            }

            if(first != null){
                next.next = first;
            }

            if(second != null){
                next.next = second;
            }

            return dummy.next;
        }

}