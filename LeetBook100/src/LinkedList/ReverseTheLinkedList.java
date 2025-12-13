package LinkedList;

class Solution_206 {
    public ListNode reverseList(ListNode head) {
        if(head==null)return null;
        int i =0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            i++;
        }
        ListNode[] list = new ListNode[i];
        int j =0;
        while(head!=null){
            list[j]=head;
            head=head.next;
            j++;
        }
        for(j=j-1;j>0;j--){
            list[j].next = list[j-1];
        }
        list[0].next=null;
        return list[i-1];
    }

    //官方答案
    public ListNode reverseList_2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}