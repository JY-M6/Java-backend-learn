package ChapterSix;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UnsafeExercise {
    public static void main(String[] args) {
        Account.demo(new MyAtomicInteger(10000));
    }
}
class MyAtomicInteger implements Account {
    private volatile int value;
    private static final long valueOffset;
    private static final Unsafe UNSAFE;
    static {
        UNSAFE = UnsafeAccessor.getUnsafe();
        try {
            valueOffset = UNSAFE.objectFieldOffset(MyAtomicInteger.class.getDeclaredField("value"));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public MyAtomicInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void decrement(int amount) {
        while(true) {
            int prev = this.value;
            int next = prev - amount;
            if(UNSAFE.compareAndSwapInt(this,valueOffset,prev,next)){
                break;
            }
        }
    }

    @Override
    public Integer getBalance() {
        return getValue();
    }

    @Override
    public void withdraw(int amount) {
        decrement(amount);
    }
}

class UnsafeAccessor {
    private static final Unsafe UNSAFE;
    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            UNSAFE = (Unsafe)theUnsafe.get(null);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    public static Unsafe getUnsafe() {
        return UNSAFE;
    }
}
//interface Account {
//    int Balance = 0;
//    public Integer getBalance();
//    public void withdraw(int amount);
//}
// 账户接口（移除冗余常量）
interface Account {
    int Balance = 0;

    public Integer getBalance();

    public void withdraw(int amount);

    // 补充的 demo 方法（核心：多线程测试原子性）
    static void demo(Account account) {
        // 线程数：100，每个线程扣减100
        int threadCount = 100;
        int perWithdraw = 100;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latch = new CountDownLatch(threadCount);
        long start = System.currentTimeMillis();

        // 启动多线程扣减
        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                try {
                    account.withdraw(perWithdraw);
                } finally {
                    latch.countDown();
                }
            });
        }
        // 等待所有线程执行完毕，输出结果
        try {
            latch.await();
            long end = System.currentTimeMillis();
            System.out.println("=== 多线程扣减结果 ===");
            System.out.println("初始余额：10000 | 线程数：100 | 单线程扣减：100");
            System.out.println("最终余额：" + account.getBalance());
            System.out.println("执行耗时：" + (end - start) + "ms");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            executor.shutdown();
        }
    }
}