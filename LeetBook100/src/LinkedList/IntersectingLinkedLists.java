//https://leetcode.cn/problems/intersection-of-two-linked-lists/
package LinkedList;
import java.util.HashSet;
import java.util.Scanner;

public class IntersectingLinkedLists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入第一个链表数据");
        ListNode_160 CommonPart = null;
        ListNode_160 ListA = new ListNode_160(4);
        ListNode_160 headA = ListA;
        for (int i = 0; i < 2; i++) {
            ListA.next = new ListNode_160(sc.nextInt());
            ListA = ListA.next;
        }
        System.out.println("正在对接公共部分");
        CommonPart = ListA;
        System.out.println("继续输入");
        for (int i = 0; i < 2; i++) {
            ListA.next = new ListNode_160(sc.nextInt());
            ListA = ListA.next;
        }
        System.out.println("输入第二个链表数据");
        ListNode_160 ListB = new ListNode_160(5);
        ListNode_160 headB = ListB;
        for (int i = 0; i < 2; i++) {
            ListB.next = new ListNode_160(sc.nextInt());
            ListB = ListB.next;
        }
        ListB.next = CommonPart;
        Solution_160 s = new Solution_160();
        ListNode_160 intersectval = s.getIntersectionNode_2(headA, headB);
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
    public ListNode_160 getIntersectionNode_1(ListNode_160 headA, ListNode_160 headB) {
        ListNode_160 intersectVal = null;
        while (headA != null ) {
            ListNode_160 list = headB;
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
    public ListNode_160 getIntersectionNode_2(ListNode_160 headA, ListNode_160 headB) {
        HashSet<ListNode_160> hashSetA = new HashSet<ListNode_160>();
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
    public ListNode_160 getIntersectionNode_3(ListNode_160 headA, ListNode_160 headB) {
        ListNode_160 p = headA;
        ListNode_160 q = headB;
        while (p != q) {
            p = p != null ? p.next : headB;
            q = q != null ? q.next : headA;
        }
        return p;
    }
    //最优解
    public ListNode_160 getIntersectionNode_4(ListNode_160 headA, ListNode_160 headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode_160 p = headA;
        ListNode_160 q = headB;
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

class ListNode_160 {
    int data;
    ListNode_160 next;

    public ListNode_160(int data) {
        this.data = data;
    }
}