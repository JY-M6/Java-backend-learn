import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("输入第一个链表");
        Node head1 = CreateNode();
        System.out.println("输入第二个链表");
        Node head2 = CreateNode();
        Node head3 = SortNode(head1, head2);
        System.out.println("第一个链表");
        while (head1 != null) {
            System.out.println(head1.getData());
            head1 = head1.getNext();
        }
        System.out.println("第二个链表");
        while (head2 != null) {
            System.out.println(head2.getData());
            head2 = head2.getNext();
        }
        System.out.println("合成后的链表");
        while (head3 != null) {
            System.out.println(head3.getData());
            head3 = head3.getNext();
        }
    }
    public static Node CreateNode() {
        Scanner sc = new Scanner(System.in);
        List<Node> list = new ArrayList<>();
        Node head = null;
        int counter = 0;
        while (true) {
            System.out.println("输入第"+counter+"个节点的数据");
            int data = sc.nextInt();
            if(data == -1&&counter == 0) {
                break;
            } else if (data == -1) {
                list.get(counter-1).setNext(null);
                break;
            }
            list.add(new Node(data));
            if (counter != 0) {
                list.get(counter).setPre(list.get(counter-1));
                list.get(counter-1).setNext(list.get(counter));
            }else{
                head = list.get(counter);
            }
            counter++;
        }
        return head;
    }
    public static Node SortNode(Node node1, Node node2) {
        if (node1 == null||node2 == null) {
            return node1 == null ? node2 : node1;
        }
        Node head = new Node(Math.min(node1.getData(), node2.getData()));
        Node node3 = head;
        if (head == node1) {
            node1 = node1.getNext();
        }else {
            node2 = node2.getNext();
        }
        while (node1 != null&& node2 != null) {
            if (node1.getData() <= node2.getData()) {
                node3.setNext(new Node(node1.getData()));
                node1 = node1.getNext();
            }else{
                node3.setNext(new Node(node2.getData()));
                node2 = node2.getNext();
            }
            node3 = node3.getNext();
        }
        node3.setNext(node1 == null ? node2 : node1);
        return head;
    }
}
class Node {
    private int data;
    private Node next;
    private Node pre;
    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }
}