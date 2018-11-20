package multithreading;

import com.druid.entity.NovelResource;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultithreadingService implements Runnable {
    private Lock lock = new ReentrantLock();
    private List<NovelResource> list;
    int i = 0;
    int j = 50;

    public MultithreadingService() {
    }

    public MultithreadingService(List<NovelResource> list) {
        this.list = list;
    }

    @Override
    public void run() {
       test2();
    }
    void test1 (){
        synchronized (new Object()) {
            // lock.lock();
            for (i = 0; i < 5; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            // lock.unlock();
        }
    }
    void test2 () {
        synchronized (new Object()) {

            for (; j > 0;) {
                lock.lock();
                if (j>0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + j);
                    j--;
                }
                lock.unlock();
            }

        }
    }
    void startRun () {
        synchronized (new Object()) {
            for (NovelResource novelResource:list) {
                lock.lock();
            }
        }
    }
}
