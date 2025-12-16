package LinkedList;

class AddTwoNumbers {
    public ListNode_2 addTwoNumbers(ListNode_2 l1, ListNode_2 l2) {
        ListNode_2 head = null;
        ListNode_2 tail = null;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = val1 + val2 + carry;

            carry = sum / 10;
            ListNode_2 newNode = new ListNode_2(sum % 10);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return head;
    }
}

/**
 * Definition for singly-linked list.
 **/
class ListNode_2 {
    int val;
    ListNode_2 next;

    ListNode_2() {
    }

    ListNode_2(int val) {
        this.val = val;
    }

    ListNode_2(int val, ListNode_2 next) {
        this.val = val;
        this.next = next;
    }
}

