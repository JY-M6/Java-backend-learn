//设计模式之保护性暂停————邮件收发
package ChapterFour;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class ProtectivePause {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            new People(latch).start();
        }
        latch.await();
        for (Integer id : MailBoxes.getIds()) {
            new Postman(id,"内容"+id).start();
        }
    }
}

class People extends Thread {
    private final CountDownLatch latch;

    public People(CountDownLatch latch) {
        this.latch = latch;
    }
    @Override
    public void run() {
        GuardedObject guardedObject = MailBoxes.createGuardedObject();
        System.out.println("开始收信"+guardedObject.getId());
        latch.countDown();
        Object mail = guardedObject.get(5000);
        if (mail != null) {
            System.out.println("收到信"+guardedObject.getId()+",内容："+mail);
        } else {
            System.out.println("超时：未收到信"+guardedObject.getId());
        }
    }
}
class Postman extends Thread {
    private int id;
    private String mail;

    public Postman(int id, String mail) {
        this.id = id;
        this.mail = mail;
    }

    public void run() {
        GuardedObject guardedObject = MailBoxes.getGuardedObject(id);
        if (guardedObject != null) {
            System.out.println("送到信"+id+",内容："+mail);
            guardedObject.complete(mail);
        } else {
            System.out.println("错误：找不到收件人" + id + "的邮箱");
        }
    }
}
class MailBoxes {
    private  static Map<Integer,GuardedObject> boxes = new Hashtable<>();
    private static int id = 1;

    private static synchronized int generateId() {
        return id++;
    }

    public static GuardedObject getGuardedObject(int id) {
        return boxes.remove(id);
    }

    public static GuardedObject createGuardedObject() {
        GuardedObject go = new GuardedObject(generateId());
        boxes.put(go.getId(), go);
        return go;
    }

    public static Set<Integer> getIds() {
        return boxes.keySet();
    }
}
class GuardedObject{
    private int id;

    public GuardedObject(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    private Object response;

    public Object get(long timeout) {
        synchronized(this) {
            long begin = System.currentTimeMillis();
            long passTime = 0;
            while(response == null) {
                long waitTime = timeout - passTime;
                if(waitTime <= 0) {
                    break;
                }
                try {
                    this.wait(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                passTime = System.currentTimeMillis() - begin;
            }
            return response;
        }
    }

    public void complete(Object response) {
        synchronized(this) {
            this.response = response;
            this.notifyAll();
        }
    }
}