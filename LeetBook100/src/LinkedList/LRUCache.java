package LinkedList;

import java.util.HashMap;
import java.util.Map;
//力扣146题

//public class LRUCache {
//    private int capacity;
//    private ListNode head;
//    private ListNode tail;
//    private ListNode cur;
//    Map<Integer, ListNode> map = new HashMap<>();
//    int size;
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        update(key);
//        return map.get(key).val;
//    }
//
//    public void put(int key, int value) {
//        if (size < capacity) {
//            if(map.isEmpty()){
//                head = new ListNode(value);
//                head.prev = null;
//                cur = head;
//                map.put(key, head);
//                size++;
//            }else {
//                if(map.containsKey(key)){
//                    map.get(key).val = value;
//                    update(key);
//                }else {
//                    size++;
//                    tail = new ListNode(value);
//                    map.put(key, tail);
//                    cur.next = tail;
//                    tail.prev = cur;
//                    cur = tail;
//                }
//            }
//        }else{
//            if(map.containsKey(key)){
//                map.get(key).val = value;
//                update(key);
//            }else {
//                head.val = -1;
//                head= head.next;
//                head.prev = null;
//                tail = new ListNode(value);
//                map.put(key, tail);
//                cur.next = tail;
//                cur = tail;
//            }
//        }
//    }
//
//    public void update(int key) {
//        ListNode pre = map.get(key);
//        pre.prev.next = pre.next;
//        pre.next.prev = pre.prev;
//        pre.prev = tail;
//        pre.next = null;
//        tail.next = pre;
//        tail = pre;
//        cur = tail;
//    }
//}
import java.util.HashMap;
import java.util.Map;

//普通双向链表
class LRUCache1 {
    private class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private Map<Integer, ListNode> map;
    private ListNode head; // 伪头节点
    private ListNode tail; // 伪尾节点
    private int size;

    public LRUCache1(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.size = 0;

        // 创建伪头节点和伪尾节点，简化边界条件处理
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        ListNode node = map.get(key);
        // 将节点移动到链表头部（最近使用）
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // 如果key已存在，更新值并移动到头部
            ListNode node = map.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            // 创建新节点
            ListNode newNode = new ListNode(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            size++;

            // 如果超出容量，移除最久未使用的节点
            if (size > capacity) {
                ListNode tailNode = removeTail();
                map.remove(tailNode.key);
                size--;
            }
        }
    }

    // 将节点添加到链表头部
    private void addToHead(ListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // 将节点移动到链表头部
    private void moveToHead(ListNode node) {
        removeNode(node);
        addToHead(node);
    }

    // 从链表中移除节点
    private void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 移除链表尾部的节点（最久未使用）
    private ListNode removeTail() {
        ListNode res = tail.prev;
        removeNode(res);
        return res;
    }
}

//循环双向链表
class LRUCache2 {
    class Node{
        Node next;
        Node pre;
        int val;
        int key;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private Node[] map = new Node[10001];
    private int cap = 0;
    private int cacheSize = 0;
    private Node cache; // 作为循环链表的哨兵节点

    public LRUCache2(int capacity) {
        cap = capacity;
        cache = new Node(-1, -1);
        cache.pre = cache;
        cache.next = cache; // 初始化为循环链表
    }

    public int get(int key) {
        if (map[key] != null) {
            Node kp = map[key];
            // 从当前位置移除节点
            removeNode(kp);
            // 插入到头部（cache.next的位置）
            addToHead(kp);
            return kp.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map[key] != null) {
            // 已存在，更新值并移动到头部
            Node kp = map[key];
            kp.val = value;
            removeNode(kp);
            addToHead(kp);
        } else {
            if (cacheSize < cap) {
                // 缓存未满，创建新节点
                cacheSize++;
                Node newNode = new Node(key, value);
                addToHead(newNode);
                map[key] = newNode;
            } else {
                // 缓存已满，重用最久未使用的节点（cache.pre）
                Node last = cache.pre;
                map[last.key] = null; // 删除旧key的映射

                // 更新节点的key和value
                last.key = key;
                last.val = value;

                // 从当前位置移除
                removeNode(last);
                // 移动到头部
                addToHead(last);
                map[key] = last;
            }
        }
    }

    // 从链表中移除节点
    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    // 将节点添加到链表头部（cache.next的位置）
    private void addToHead(Node node) {
        node.next = cache.next;
        node.pre = cache;
        cache.next.pre = node;
        cache.next = node;
    }
}