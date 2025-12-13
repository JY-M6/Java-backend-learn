package ChapterEight;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WorkThread {
    static final List<String> MENU = Arrays.asList("地三鲜","宫保鸡丁","辣子鸡丁","烤鸡翅");
    static Random rand = new Random();
    static String cooking(){return MENU.get(rand.nextInt(MENU.size()));}
    public static void main(String[] args) {
        ExecutorService waiterpool = Executors.newFixedThreadPool(1);
        ExecutorService cookpool = Executors.newFixedThreadPool(1);

        waiterpool.execute(() -> {
            System.out.println("处理点餐...");
            Future<String> f = cookpool.submit(() -> {
                System.out.println("做菜");
                return cooking();
            });
            try {
                System.out.println("上菜:"+f.get());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        waiterpool.execute(() -> {
            System.out.println("处理点餐...");
            Future<String> f = cookpool.submit(() -> {
                System.out.println("做菜");
                return cooking();
            });
            try {
                System.out.println("上菜:"+f.get());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
