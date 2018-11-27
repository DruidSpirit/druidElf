package multithreading;

import c3p0Test.DruidNovleDealData;
import c3p0Test.dataDeal;
import com.druid.dao.DruidNovelResourceMapper;
import com.druid.entity.DruidNovelResource;
import com.druid.util.ConnectionPoolSetting;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadingTest {
    public static void main(String[] args) {
        //test2();
        test4();
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

    /**
     * 使用静态块的方式来创建线程池
     */
    public static void test3 () {
        MultithreadingService multithreadingService = new MultithreadingService();
        for (int i = 0;i<30;i++){
            ConnectionPoolSetting.executorService.submit(new Thread(multithreadingService));
        }
        ConnectionPoolSetting.executorService.shutdown();
    }

    /**
     * 连接mybatis并启动多线程测试
     */
    public static void test4 (){
        List<DruidNovelResource> novelResourceList = DruidNovleDealData.dealDruidNovel();
        for (DruidNovelResource novelResource:novelResourceList) {
            try {
                ConnectionPoolSetting.executorService.submit(new MultithreadingService(novelResource));
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        ConnectionPoolSetting.executorService.shutdown();

    }
}
