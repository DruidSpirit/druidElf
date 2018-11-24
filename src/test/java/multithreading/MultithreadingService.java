package multithreading;

import com.druid.dao.DruidNovelResourceMapper;
import com.druid.entity.DruidNovelResource;
import com.druid.service.DruidNovelResourceService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class MultithreadingService implements Runnable {
    private Lock lock = new ReentrantLock();
    private DruidNovelResource novelResource;
    private DruidNovelResourceMapper druidNovelResourceService;
    /**
     * 代理工厂类
     */
    private SqlSessionFactory sqlSessionFactory;
    int i = 0;
    int j = 50;

    public MultithreadingService() {
    }

    public MultithreadingService(DruidNovelResource novelResource, DruidNovelResourceMapper druidNovelResourceService) {
        this.novelResource = novelResource;
        this.druidNovelResourceService = druidNovelResourceService;
    }

    public MultithreadingService(DruidNovelResource novelResource, SqlSessionFactory sqlSessionFactory) {
        this.novelResource = novelResource;
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void run() {
        startRun2 ();
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
        if (novelResource.getHasLoaddown()){
            System.out.println(Thread.currentThread().getName()+":"+novelResource.getName());
                DruidNovelResource druidNovelResource2 = DruidNovelResource.builder()
                        .id(novelResource.getId())
                        .hasLoaddown(false)
                        .build();
                novelResource.setHasLoaddown(false);
                // 在spring中配置SqlSessionTemplate保证线程安全
            try {
                druidNovelResourceService.updateByPrimaryKeySelective(druidNovelResource2);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    void startRun2 () {
        if (novelResource.getHasLoaddown()){
            System.out.println(Thread.currentThread().getName()+":"+novelResource.getName());
            DruidNovelResource druidNovelResource2 = DruidNovelResource.builder()
                    .id(novelResource.getId())
                    .hasLoaddown(false)
                    .build();
            novelResource.setHasLoaddown(false);
            // 在spring中配置SqlSessionTemplate保证线程安全
            SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
            DruidNovelResourceMapper mapper = sqlSessionTemplate.getMapper(DruidNovelResourceMapper.class);
            try {
                mapper.updateByPrimaryKeySelective(druidNovelResource2);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
