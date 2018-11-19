package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadingTest {
    public static void main(String[] args) {
        test2();
    }

    /**
     * 线程同步快测试、线程锁测试
     */
    public static void test1 () {
        MultithreadingService multithreadingService = new MultithreadingService();
        MultithreadingService multithreadingService1  = new MultithreadingService();
        Thread thread = new Thread(multithreadingService,"线程1");
        Thread thread1 = new Thread(multithreadingService,"线程2");
        Thread thread2 = new Thread(multithreadingService,"线程3");
        Thread thread3 = new Thread(multithreadingService,"线程4");
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }

    /**
     * 线程池测试
     */
    public static void test2 () {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        MultithreadingService multithreadingService = new MultithreadingService();
        MultithreadingService multithreadingService2 = new MultithreadingService();
        Thread thread = new Thread(multithreadingService,"线程1");
        Thread thread1 = new Thread(multithreadingService,"线程2");
        Thread thread2 = new Thread(multithreadingService,"线程3");
        Thread thread3 = new Thread(multithreadingService2,"线程4");
        pool.submit(thread);
        pool.submit(thread1);
        pool.submit(thread2);
        pool.submit(thread3);
        pool.shutdown();
    }
}
