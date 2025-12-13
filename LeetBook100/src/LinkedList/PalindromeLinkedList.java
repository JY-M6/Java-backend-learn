package LinkedList;

public class PalindromeLinkedList {
}
class Solution_234 {
    public boolean isPalindrome(ListNode_234 head) {
        ListNode_234 temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        temp = head;
        int[] arr =  new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = temp.val;
            temp = temp.next;
        }
        for (int i = 0; i < length; i++) {
            if (arr[i] != arr[length -i - 1]) {
                return false;
            }
        }
        return true;
    }
}

class ListNode_234 {
      int val;
      ListNode_234 next;
      ListNode_234() {}
      ListNode_234(int val) {
          this.val = val; }
      ListNode_234(int val, ListNode_234 next) {
          this.val = val; this.next = next; }
  }

//最快解
class Solution {
    public boolean isPalindrome(ListNode_234 head) {
        if(null==head || null==head.next)
            return true;

        ListNode_234 slow=head,quick=head;

        while(quick!=null && quick.next!=null){
            quick=quick.next.next;
            slow=slow.next;
        }
        //LinkListUtil.printLinkedList(slow);
        //	if(quick==null){
        // 偶数个
        //slow=slow.next;
        slow=reverseLinkedList(slow);
        //	}else{
        // 奇数个
        //		slow=reverseLinkedList(slow);
        //	}

        //System.out.println("slow");LinkListUtil.printLinkedList(slow);
        //	System.out.println("head");LinkListUtil.printLinkedList(head);

        while(slow!=null){
            if(slow.val!=head.val)
                return false;
            slow=slow.next;
            head=head.next;
        }


        return true;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */

    public ListNode_234 reverseLinkedList(ListNode_234 head){
        if(head==null||head.next==null)
            return head;

        ListNode_234 last=null;
        while(head!=null){
            ListNode_234 tmp=head.next;
            head.next=last;
            last=head;
            head=tmp;

        }

        return last;
    }
}

