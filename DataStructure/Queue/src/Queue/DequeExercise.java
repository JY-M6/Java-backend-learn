package Queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

public class DequeExercise{
    public static void main(String[] args) {
        Deque1 deque1=new Deque1();
        deque1.test();
        Deque2 deque2 = new Deque2(5);
        deque2.addFirst(1);
        deque2.addFirst(2);
        deque2.addLast(3);
        System.out.println(deque2);
        deque2.addLast(4);
        deque2.addLast(5);
        System.out.println(deque2);
    }
}

//标准队列
class Deque1 {
    Deque<Integer> deque = new LinkedBlockingDeque<>(5);

    public void test() {
        // 队首操作
        System.out.println("队首操作");
        deque.addFirst(1);    // 头部添加
        deque.offerFirst(2);  // 头部添加（推荐）
        deque.removeFirst();  // 头部移除
        deque.pollFirst();    // 头部移除（推荐）
        deque.addFirst(3);
        deque.offerFirst(4);
        System.out.println(deque);

        // 队尾操作
        System.out.println("队尾操作");
        deque.addLast(3);     // 尾部添加
        deque.offerLast(4);   // 尾部添加（推荐）
        deque.removeLast();   // 尾部移除
        deque.pollLast();     // 尾部移除（推荐）
        deque.addLast(5);
        System.out.println(deque);

        // 查看元素（不删除）
        System.out.println("查看元素（不删除）");
        System.out.println(deque.getFirst());     // 查看头部
        System.out.println(deque.peekFirst());    // 查看头部（推荐）
        System.out.println(deque.getLast());      // 查看尾部
        System.out.println(deque.peekLast());     // 查看尾部（推荐）
    }
}

//数组实现
class Deque2 {
    int[] deque;
    int head = 0;
    int tail = 0;
    int size;
    int limit;

    public Deque2(int limit) {
        this.limit = limit;
        deque = new int[limit];
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    public Boolean isFull() {
        return size == limit;
    }

    public boolean addFirst(int x) {
        if(isFull()) {
            return false;
        }else {
            if(isEmpty()){
                head =tail = 0;
                deque[head] = x;
            }else {
                head = head==0?limit-1:head-1;
                deque[head] = x;
            }
            size++;
            return true;
        }
    }

        public boolean addLast ( int x){
            if(isFull()) {
                return false;
            }else {
                if(isEmpty()){
                    head = tail = 0;
                    deque[tail] = x;
                }else {
                    tail = tail == limit-1 ? 0 : tail+1;
                    deque[tail] = x;
                }
                size++;
                return true;
            }
        }

        public boolean removeFirst () {
            if(isEmpty()) {
                return false;
            }else {
                head = head == limit-1 ? 0 : head+1;
                size--;
                return true;
            }
        }

        public boolean removeLast () {
            if(isEmpty()) {
                return false;
            }else {
                tail = tail == 0 ? limit-1 : tail-1;
                size--;
                return true;
            }
        }

    @Override
    public String toString() {
        return "Deque2{" +
                "deque=" + Arrays.toString(deque) +
                ", head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                ", limit=" + limit +
                ", isFull=" + isFull() +
                ", isEmpty=" + isEmpty() +
                '}';
    }
}