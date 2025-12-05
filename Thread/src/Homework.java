import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        Random random = new Random();
        random.start();
        MyThread myThread = new MyThread(random);
        Thread thread = new Thread(myThread);
        thread.start();
    }
}
class Random extends Thread{
    private Boolean loop = true;

    public void setLoop(Boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while(loop){
            System.out.println(Thread.currentThread().getName()+"输出了"+(int)(Math.random()*100+1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Random类运行完毕...");
    }
}
class MyThread implements Runnable{
    Random random = new Random();
    public MyThread(Random random) {
        this.random = random;
    }

    public void run() {

        while(true){
            System.out.println("请输入一个字母来控制程序（‘Q’为结束）");
            Scanner scanner = new Scanner(System.in);
            char a = scanner.next().toUpperCase().charAt(0);
            if(a=='Q'){
                random.setLoop(false);
                break;
            }
        }
        System.out.println("MyThread类运行完毕...");
    }
}
