package ChapterFour.AlternatingOutput;

public class Wait_notify {
    public static void main(String[] args) {
        WaitNotify wn = new WaitNotify(1,5);
        new Thread(() -> {
            wn.print("a",1,2);
        }).start();
        new Thread(() -> {
            wn.print("b",2,3);
        }).start();
        new Thread(() -> {
            wn.print("c",3,1);
        }).start();
    }
}
class WaitNotify{
    public void print(String str,int waitFlag,int nextFlag){
        for (int i = 0; i < loopNumber; i++) {
            synchronized (this){
                while(flag != waitFlag){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(str);
                flag = nextFlag;
                this.notifyAll();
            }
        }
    }

    private int flag;
    private int loopNumber;

    public WaitNotify(int flag,int loopNumber){
        this.flag = flag;
        this.loopNumber = loopNumber;
    }
}