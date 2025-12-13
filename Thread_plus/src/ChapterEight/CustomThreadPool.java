package ChapterEight;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CustomThreadPool {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(2,1000,TimeUnit.MILLISECONDS,10);
        for (int i = 0; i < 5; i++) {
            int j = i;
            threadPool.execute(() -> {
                System.out.println(j);
            });
        }
    }
}
class ThreadPool {
    //任务队列
    private BlockingQueue<Runnable> taskQueue;
    //线程集合
    private HashSet<Worker> workers = new HashSet<Worker>();
    //核心线程数
    private int coreSize;
    //超时时间
    private long timeout;
    private TimeUnit timeUnit;

    //执行任务
    public void execute(Runnable task) {
        synchronized (workers) {
            if (workers.size() < coreSize) {
                Worker worker = new Worker(task);
                System.out.println("新增worker"+worker);
                workers.add(worker);
                worker.start();
            }else {
                System.out.println("加入任务队列"+task);
                taskQueue.put(task);
            }
        }
    }

    public ThreadPool(int coreSize, long timeout, TimeUnit timeUnit, int queueCapacity) {
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        this.taskQueue = new BlockingQueue<>(queueCapacity);
    }

    class Worker extends Thread {
        private Runnable task;

        public Worker(Runnable task) {
            this.task = task;
        }

        public void run() {
            //执行任务
            //（1）当task不为空，执行任务
            //（2）当task执行完毕，再接着从任务队列中获取
            //while (task != null||(task = taskQueue.take())!=null) {
            while (task != null||(task = taskQueue.pull(timeout,timeUnit))!=null) {
                try{
                    System.out.println("正在执行"+task);
                    task.run();
                }catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    task = null;
                }
            }
            synchronized (workers) {
                System.out.println(this+"被移除");
                workers.remove(this);
            }
        }
    }
}

class BlockingQueue<T>{
    private Deque<T> queue = new ArrayDeque<>();
    private ReentrantLock lock = new ReentrantLock();
    private Condition fullWaitSet = lock.newCondition();
    private Condition emptyWaitSet = lock.newCondition();
    private int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    //带超时等待的阻塞获取
    public T pull(long timeout, TimeUnit unit){
        lock.lock();
        try{
            long nanos = unit.toNanos(timeout);
            while (queue.isEmpty()){
                try {
                    if (nanos <= 0){
                        System.out.println("已超时");
                        return null;
                    }
                    nanos =emptyWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            T t = queue.removeFirst();
            fullWaitSet.signal();
            return t;
        }finally{
            lock.unlock();
        }
    }

    //阻塞获取
    public T take(){
        lock.lock();
        try{
            while (queue.isEmpty()){
                try {
                    emptyWaitSet.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            T t = queue.removeFirst();
            fullWaitSet.signal();
            return t;
        }finally {
            lock.unlock();
        }
    }

    //添加
    public void put(T element){
        lock.lock();
        try{
            while (queue.size() == capacity){
                try {
                    fullWaitSet.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.addLast(element);
            emptyWaitSet.signal();
        }finally{
            lock.unlock();
        }
    }

    public int size(){
        lock.lock();
        try{
            return queue.size();
        }finally {
            lock.unlock();
        }
    }
}