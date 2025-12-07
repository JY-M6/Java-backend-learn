public class Main {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
        MyThread2 myThread2 = new MyThread2();
        Thread t2 = new Thread(myThread2);
        t2.start();
    }
}
class MyThread1 extends Thread {
    public void run() {
        int i = 0;
        while (true) {
            System.out.println("i = " + ++i);
            System.out.println(Thread.currentThread().getName()+"运行了一次");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (i==100){
                break;
            }
        }
    }
}
class MyThread2 implements Runnable {
    public void run() {
        int a =100;
        while (true){
            System.out.println("a = " + --a);
            System.out.println(Thread.currentThread().getName()+"运行了一次");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (a==0){
                break;
            }
        }
    }
}