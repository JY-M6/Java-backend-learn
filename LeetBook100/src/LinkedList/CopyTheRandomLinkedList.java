package LinkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CopyTheRandomLinkedList {
}


class Solution_138 {
    public Node_138 copyRandomList1(Node_138 head) {
        Node_138 temp = head;
        if (head == null) {
            return null;
        }
        int count = 0;
        temp = head;
        Map<Node_138,Integer > map = new HashMap<>();
        while (temp != null) {
            map.put(temp ,count);
            temp = temp.next;
            count++;
        }
        map.put(null,count);
        temp = head;
        Node_138[] nodes = new Node_138[count+1];
        for (int i = 0; i < count+1; i++) {
            if(i == count){
                nodes[i] = null;
                break;
            }
            nodes[i] = new Node_138(temp.val);
            temp = temp.next;
        }
        temp = head;
        for (int i = 0; i < count+1; i++) {
            if (i == count-1) {
                nodes[i].next = null;
                nodes[i].random = nodes[map.get(temp.random)];
                break;
            }
            nodes[i].next = nodes[i+1];
            nodes[i].random = nodes[map.get(temp.random)];
            temp = temp.next;
        }
        return nodes[0];
    }

    public Node_138 copyRandomList2(Node_138 head) {
        if (head==null)
            return null;
        Map<Node_138, Node_138> map=new HashMap<>();
        Node_138 cur=head;
        while (cur!=null){
            map.put(cur,new Node_138(cur.val));
            cur=cur.next;
        }
        cur=head;
        while (cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);
    }
}

class Node_138 {
    int val;
    Node_138 next;
    Node_138 random;

    public Node_138(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}