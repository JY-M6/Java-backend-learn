import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class Synchronized {
    public static void main(String[] args) throws InterruptedException {
        Room room = new Room();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                room.increaseCounter();
            }
        },"t1");
        Thread t2 =new Thread(() ->{
            for (int i = 0; i < 5000; i++) {
                room.decreaseCounter();
            }
        },"t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final Counter: " + room.getCounter());
    }
}
class Room{
    private int counter = 0;
    public void increaseCounter(){
        synchronized(this){
            counter++;
        }
    }
    public void decreaseCounter(){
        synchronized(this){
            counter--;
        }
    }
    public int getCounter(){
        synchronized(this){
            return counter;
        }
    }
}
