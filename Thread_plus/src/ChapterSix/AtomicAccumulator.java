package ChapterSix;

import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AtomicAccumulator {
    public static void main(String[] args) throws InterruptedException {
        LongAdder adder = new LongAdder();

        System.out.println("程序开始执行...");

        // 创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // 使用CountDownLatch确保所有任务完成
        int totalTasks = 100;
        CountDownLatch latch = new CountDownLatch(totalTasks);

        // 提交100个累加任务
        for (int i = 0; i < totalTasks; i++) {
            final int taskId = i + 1;
            executor.submit(() -> {
                try {
                    System.out.println("任务 " + taskId + " 开始执行");
                    for (int j = 0; j < 1000; j++) {
                        adder.add(1);           // 累加
                        // adder.increment();   // 加1的快捷方法
                        // adder.decrement();   // 减1
                        // adder.add(5);        // 加任意值
                    }
                    System.out.println("任务 " + taskId + " 执行完成，已累加1000");
                } finally {
                    latch.countDown();  // 任务完成，计数器减1
                }
            });
        }

        System.out.println("所有任务已提交，等待执行完成...");

        // 等待所有任务完成
        latch.await();
        System.out.println("所有任务已完成，准备关闭线程池...");

        // 关闭线程池
        executor.shutdown();
        boolean terminated = executor.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("线程池是否已关闭: " + terminated);

        System.out.println("\n=== 结果输出 ===");

        // 获取结果
        System.out.println("最终总和: " + adder.sum());  // 应该是 100 * 1000 = 100000

        // 获取并重置
        long sumBeforeReset = adder.sumThenReset();
        System.out.println("调用sumThenReset()后得到的值: " + sumBeforeReset);  // 应该是100000

        // 重置后的值
        System.out.println("重置后的值: " + adder.sum());  // 应该是0，因为已经重置了

        System.out.println("\n=== 类型转换 ===");
        // 转换为其他类型
        System.out.println("int值: " + adder.intValue());    // 应该是0
        System.out.println("long值: " + adder.longValue());  // 应该是0
        System.out.println("float值: " + adder.floatValue());  // 应该是0.0
        System.out.println("double值: " + adder.doubleValue());  // 应该是0.0

        System.out.println("\n程序执行完毕！");
    }
}