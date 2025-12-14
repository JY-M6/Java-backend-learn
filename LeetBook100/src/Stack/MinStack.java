package Stack;

//155.最小栈
import java.util.*;

public class MinStack {
    public static void main(String[] args) {
        MinStack2 minStack2 = new MinStack2();
        minStack2.push(-2);
        minStack2.push(0);
        minStack2.push(-3);
        System.out.println(minStack2.getMin());
        minStack2.pop();
        System.out.println(minStack2.top());
        System.out.println(minStack2.getMin());
    }
}

//标准栈实现
class MinStack1 {
    Deque<Integer> stack;
    Deque<Integer> minStack=new ArrayDeque<>();

    public MinStack1() {
        this.stack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()){
            minStack.push(val);
        }else {
            minStack.push(Math.min(val,minStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

    //数组实现
    class MinStack2 {
        private int[] stack;
        private int[] minStack;  // 辅助栈存储最小值
        private int size;
        private int capacity;

        public MinStack2() {
            capacity = 16;
            stack = new int[capacity];
            minStack = new int[capacity];
            size = 0;
        }

        public void push(int val) {
            if (size == capacity) {
                capacity *= 2;
                stack = Arrays.copyOf(stack, capacity);
                minStack = Arrays.copyOf(minStack, capacity);
            }

            stack[size] = val;
            minStack[size] = (size == 0) ? val : Math.min(minStack[size-1], val);
            size++;
        }

        public void pop() {
            size--;
        }

        public int top() {
            return stack[size-1];
        }

        public int getMin() {
            return minStack[size-1];
        }
    }

//最快
class MinStack3 {

    private record Node(int val, int min, Node prev){};
    private Node head;

    public MinStack3() {

    }

    public void push(int val) {
        head = head == null ? new Node(val, val, null) : new Node(val, Math.min(head.min, val), head);
    }

    public void pop() {
        head = head.prev;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
//    class Node{
//        int val;
//        int min;
//        Node prev;
//        public Node(int val, int min, Node prev){
//            this.val = val;
//            this.min = min;
//            this.prev = prev;
//        }
//    }
}