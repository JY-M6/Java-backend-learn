//设计模式之固定运行顺序
package ChapterFour;

import java.util.concurrent.locks.LockSupport;

public class FixedOperatingSequence {
    static final Object lock = new Object();
    static boolean t2runned = false;

    public static void main(String[] args) {
        //wait-notify
        {
            System.out.println("wait-notify");
            Thread t1 = new Thread(() -> {
                synchronized (lock) {
                    while (!t2runned) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("1");
                }
            }, "t1");
            Thread t2 = new Thread(() -> {
                synchronized (lock) {
                    System.out.println("2");
                    t2runned = true;
                    lock.notify();
                }
            }, "t2");

            t1.start();
            t2.start();
        }
        //park-unpark
        {
            System.out.println("park-unpark");
            Thread t3 = new Thread(() -> {
                LockSupport.park();
                System.out.println("3");
            },"t3");
            t3.start();
            new Thread(() -> {
                System.out.println("4");
                LockSupport.unpark(t3);
            },"t4").start();
        }
    }
}
