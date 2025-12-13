package ChapterFour.AlternatingOutput;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockWay {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始...");
        AwaitSignal awaitSignal = new AwaitSignal(5);
        Condition a = awaitSignal.newCondition();
        Condition b = awaitSignal.newCondition();
        Condition c = awaitSignal.newCondition();
        new Thread(() -> {
            awaitSignal.print("a",0,a,b);
        }).start();
        new Thread(() -> {
            awaitSignal.print("b",1,b,c);
        }).start();
        new Thread(() -> {
            awaitSignal.print("c",2,c,a);
        }).start();
        Thread.sleep(1000);
        awaitSignal.lock();
        try {
            a.signal();
        } finally {
            awaitSignal.unlock();
        }
    }
}
class AwaitSignal extends ReentrantLock {
    private int loopNumber;
    private int flag = 0;
    public AwaitSignal(int loopNumber) {
        this.loopNumber = loopNumber;
    }
    public void print(String str, int target, Condition current, Condition next) {
        for (int i = 0; i < loopNumber; i++) {
            lock();
            try {
                while (flag != target) {
                    current.await();
                }
                System.out.print(str);
                flag = (flag + 1) % 3;
                next.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                unlock();
            }
        }
    }
}