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