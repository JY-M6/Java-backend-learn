//设计模式之生产者消费者——生产消费消息队列
package ChapterFour;

import java.util.LinkedList;

import static java.lang.Thread.sleep;


public class ProducerConsumer {
    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue(2);
        for (int i = 0; i < 3; i++) {
            int id = i;
            new Thread(() -> {
                queue.put(new Message(id, "值" + id));
            }, "生产者" + i).start();
        }
        new Thread(() -> {
            while (true) {
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Message message = queue.take();
            }
        }, "消费者").start();
    }
}

//消息队列类
class MessageQueue {
    //消息队列集合
    private LinkedList<Message> list = new LinkedList<Message>();
    //队列容量
    private int capacity;

    public MessageQueue(int capcity) {
        this.capacity = capcity;
    }

    public Message take() {
        synchronized (list) {
            while (list.isEmpty()) {
                try {
                    System.out.println("队列为空，消费者线程等待");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message message = list.removeFirst();
            System.out.println("已消费消息"+message);
            list.notifyAll();
            return message;
        }
    }

    public void put(Message message) {
        synchronized (list) {
            while (list.size() == capacity) {
                try {
                    System.out.println("队列已满，生产者线程等待");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            list.addLast(message);
            System.out.println("已生产消息"+message);
            list.notifyAll();
        }
    }
}
final class Message{
    private int id;
    private Object value;
    public Message(int id, Object value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
