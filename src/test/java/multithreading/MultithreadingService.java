package multithreading;

import com.druid.entity.DruidNovelResource;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultithreadingService implements Runnable {
    private Lock lock = new ReentrantLock();
    private DruidNovelResource novelResource;
    int i = 0;
    int j = 50;

    public MultithreadingService() {
    }

    public MultithreadingService(DruidNovelResource novelResource) {
        this.novelResource = novelResource;
    }

    @Override
    public void run() {
        startRun ();
       // test2();
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
          System.out.println(Thread.currentThread().getName()+":"+novelResource.getName());
    }
}
