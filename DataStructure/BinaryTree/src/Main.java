import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Map<Node, Integer> map = new HashMap<>();
        BinaryTree bt = new BinaryTree();
        Node root = bt.getRoot();
        root.data = 9;
        Node node1 = bt.addleft(root, 1);
        Node node2 = bt.addright(root, 2);
        Node node11 = bt.addleft(node1, 3);
        Node node12 = bt.addright(node1, 4);
        Node node21 = bt.addleft(node2, 5);
        Node node22 = bt.addright(node2, 6);
        bt.preOrder(root);
        System.out.println();
        bt.preOrder2(root);
        bt.postOrder(root);
        System.out.println();
        bt.postOrder2(root);
        bt.postOrder3(root);
    }
}

class BinaryTree {
    private Node root;

    BinaryTree() {
        root = new Node(0);
    }

    public Node getRoot() {
        return root;
    }

    //加左枝元素
    public Node addleft(Node node, int data) {
        node.left = new Node(data);
        return node.left;
    }

    //加右枝元素
    public Node addright(Node node, int data) {
        node.right = new Node(data);
        return node.right;
    }

    //先序
    public void preOrder(Node current) {
        if (current == null) {
            return;
        } else {
            System.out.print(current.data + " ");
            preOrder(current.left);
            preOrder(current.right);
        }
    }

    //中序
    public void inOrder(Node current) {
        if (current == null) {
            return;
        } else {
            inOrder(current.left);
            System.out.print(current.data + " ");
            inOrder(current.right);
        }
    }

    //后序
    public void postOrder(Node current) {
        if (current == null) {
            return;
        } else {
            postOrder(current.left);
            postOrder(current.right);
            System.out.print(current.data + " ");
        }
    }

    //非递归先序
    public void preOrder2(Node current) {
        if (current != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(current);
            while (!stack.isEmpty()) {
                current = stack.pop();
                System.out.print(current.data + " ");
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }
            System.out.println();
        }
    }

    //非递归中序
    public void inOrder2(Node current) {
        if (current != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || current != null) {
                if (current != null) {
                    stack.push(current);
                    current = current.left;
                } else {
                    current = stack.pop();
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
            System.out.println();
        }
    }

    //非递归后续(双栈)
    public void postOrder2(Node current) {
        if (current != null) {
            Stack<Node> stack = new Stack<>();
            Stack<Node> collect = new Stack<>();
            stack.push(current);
            while (!stack.isEmpty()) {
                current = stack.pop();
                collect.push(current);
                if (current.left != null) {
                    stack.push(current.left);
                }
                if (current.right != null) {
                    stack.push(current.right);
                }
            }
            while (!collect.isEmpty()) {
                System.out.print(collect.pop().data+ " ");
            }
            System.out.println();
        }
    }

    //非递归后续(单栈)
    public void postOrder3(Node h) {
        if (h != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(h);
            while (!stack.isEmpty()) {
                Node current = stack.peek();
                if (current.left != null
                            && h != current.left
                            && h != current.right) {
                    stack.push(current.left);
                }else if(current.right != null
                                  && h != current.right){
                    stack.push(current.right);
                }else{
                    System.out.print(current.data + " ");
                    h = stack.pop();
                }
            }
            System.out.println();
        }
    }
}


class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}