package multithreading;

import c3p0Test.dataDeal;
import com.druid.dao.DruidNovelResourceMapper;
import com.druid.entity.DruidNovelResource;
import com.druid.service.DruidNovelResourceService;
import com.druid.util.HttpGetDownFile;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;

import java.io.IOException;
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

    public MultithreadingService(DruidNovelResource novelResource) {
        this.novelResource = novelResource;
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
        startRun4 ();
      //  test2();
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

    void startRun3 () {
        if (!this.novelResource.getHasLoaddown()) {
            System.out.println(Thread.currentThread().getName() + ":" + this.novelResource.getName());
            String storeAdress = "D:\\" + this.novelResource.getRepositoryPath();
            lock.lock();
            try {
                Boolean result = HttpGetDownFile.downloadAndSaveFile(this.novelResource.getLinkTxt(),storeAdress);
                System.out.println("结果是："+result);
            } catch (IOException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }

    }

    void startRun4 () {
       if (!this.novelResource.getHasLoaddown()) {
           String storeAdress = "D:\\" + this.novelResource.getRepositoryPath();
           System.out.println("开始下载："+this.novelResource.getName());
           String result = null;
           /*try {
               result = HttpGetDownFile.filterLinkAndDownloadAndSave(this.novelResource.getLinkTxt(),storeAdress);
           } catch (IOException e) {
               e.printStackTrace();
           }*/
           result = "test";
           if ( result != null ){
               String getSuccessRepositoryPath = this.novelResource.getRepositoryPath()+result;
               String sql = "UPDATE druid_novel_resource SET has_loaddown=1,repository_path='"+getSuccessRepositoryPath+"' where id = "+this.novelResource.getId()+"";
               dataDeal.updateByc3p0(sql);
           }
       }
    }
}
