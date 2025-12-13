//https://leetcode.cn/problems/intersection-of-two-linked-lists/
package LinkedList;
import java.util.HashSet;
import java.util.Scanner;

public class IntersectingLinkedLists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入第一个链表数据");
        ListNode CommonPart = null;
        ListNode ListA = new ListNode(4);
        ListNode headA = ListA;
        for (int i = 0; i < 2; i++) {
            ListA.next = new ListNode(sc.nextInt());
            ListA = ListA.next;
        }
        System.out.println("正在对接公共部分");
        CommonPart = ListA;
        System.out.println("继续输入");
        for (int i = 0; i < 2; i++) {
            ListA.next = new ListNode(sc.nextInt());
            ListA = ListA.next;
        }
        System.out.println("输入第二个链表数据");
        ListNode ListB = new ListNode(5);
        ListNode headB = ListB;
        for (int i = 0; i < 2; i++) {
            ListB.next = new ListNode(sc.nextInt());
            ListB = ListB.next;
        }
        ListB.next = CommonPart;
        Solution_160 s = new Solution_160();
        ListNode intersectval = s.getIntersectionNode_2(headA, headB);
        System.out.println("正在输出第一个链表");
        while (headA != null) {
            System.out.print(headA.data + ", ");
            headA = headA.next;
        }
        System.out.println("\n");
        System.out.println("正在输出第二个链表");
        while (headB != null) {
            System.out.print(headB.data + ", ");
            headB = headB.next;
        }
        System.out.println("\n");
        System.out.println("正在输出答案链表");
        while (intersectval != null) {
            System.out.print(intersectval.data + ", ");
            intersectval = intersectval.next;
        }
        System.out.println("\n");
        System.out.println("正在输出公共链表");
        while (CommonPart != null) {
            System.out.print(CommonPart.data + ", ");
            CommonPart = CommonPart.next;
        }
        System.out.println("\n");
        if (intersectval == null) {
            System.out.println("无公共部分");
        }
    }
}

class Solution_160 {
    public ListNode getIntersectionNode_1(ListNode headA, ListNode headB) {
        ListNode intersectVal = null;
        while (headA != null ) {
            ListNode list = headB;
            while (list != null) {
                if (headA == list) {
                    intersectVal = headA;
                    return intersectVal;
                }
                list = list.next;
            }
            headA = headA.next;
        }
        return intersectVal;
    }
    public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
        HashSet<ListNode> hashSetA = new HashSet<ListNode>();
        while (headA != null) {
            hashSetA.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (hashSetA.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
    //双指针
    public ListNode getIntersectionNode_3(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            p = p != null ? p.next : headB;
            q = q != null ? q.next : headA;
        }
        return p;
    }
    //最优解
    public ListNode getIntersectionNode_4(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode p = headA;
        ListNode q = headB;
        while(p!=null){
            lenA++;
            p = p.next;
        }
        while(q!=null){
            lenB++;
            q = q.next;
        }
        p = headA;
        q = headB;
        if(lenA >= lenB){
            for(int i=0;i<lenA-lenB;i++){
                p=p.next;
            }
        }
        else{
            for(int i=0;i<lenB-lenA;i++){
                q=q.next;
            }
        }
        while(p != null){
            if(p == q){
                return p;
            }
            p = p.next;
            q = q.next;
        }
        return null;
    }
}

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
    }
}