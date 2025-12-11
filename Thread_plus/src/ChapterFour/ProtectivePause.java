//设计模式之保护性暂停————邮件收发
package ChapterFour;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class ProtectivePause {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new People().start();
        }
        Thread.sleep(1);
        for (Integer id : MailBoxes.getIds()) {
            new Postman(id,"内容"+id).start();
        }
    }
}

class People extends Thread {
    public void run() {
        GuardedObject guardedObject = MailBoxes.createGuardedObject();
        System.out.println("开始收信"+guardedObject.getId());
        Object mail = guardedObject.get(5000);
        System.out.println("收到信"+guardedObject.getId()+",内容："+mail);
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
        System.out.println("送到信"+id+",内容："+mail);
        guardedObject.complete(mail);
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