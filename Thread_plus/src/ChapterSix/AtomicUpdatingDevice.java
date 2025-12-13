package ChapterSix;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicUpdatingDevice {

    // 需要原子更新的字段必须是volatile且非private
    volatile int count;

    // 创建更新器（通常是static final）
    private static final AtomicIntegerFieldUpdater<AtomicUpdatingDevice> UPDATER =
            AtomicIntegerFieldUpdater.newUpdater(AtomicUpdatingDevice.class, "count");

    public AtomicUpdatingDevice() {
        this.count = 0;
    }

    // 各种原子操作方法
    public int incrementAndGet() {
        return UPDATER.incrementAndGet(this);
    }

    public int decrementAndGet() {
        return UPDATER.decrementAndGet(this);
    }

    public int getAndIncrement() {
        return UPDATER.getAndIncrement(this);
    }

    public int getAndAdd(int delta) {
        return UPDATER.getAndAdd(this, delta);
    }

    public boolean compareAndSet(int expect, int update) {
        return UPDATER.compareAndSet(this, expect, update);
    }

    public int get() {
        return UPDATER.get(this);
    }

    // 测试代码
    public static void main(String[] args) throws InterruptedException {
        AtomicUpdatingDevice counter = new AtomicUpdatingDevice();

        // 创建多个线程并发操作
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.incrementAndGet();
                }
            });
            threads[i].start();
        }

        // 等待所有线程完成
        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Final count: " + counter.get());  // 应该是10000
    }
}