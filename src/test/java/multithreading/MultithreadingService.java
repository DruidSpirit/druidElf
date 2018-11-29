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

        String root = "C:\\Users\\Administrator\\Desktop\\testNovel\\";
        String result = null; // txt小说下载结果
        // text 小说下载
       if (!this.novelResource.getHasLoaddown()) {
           String storeAdress = root + this.novelResource.getRepositoryPath();
           System.out.println("开始下载text："+this.novelResource.getName());

           // 开始下载TXT文本小说
           try {
               result = HttpGetDownFile.filterLinkAndDownloadAndSave(this.novelResource.getLinkTxt(),storeAdress,true);
           } catch (IOException e) {
               result = null;
               e.printStackTrace();
           }
           // 下载成功后修改数据库状态
           if ( result != null ){
               String getSuccessRepositoryPath = this.novelResource.getRepositoryPath()+result;
               String sql = "UPDATE druid_novel_resource SET has_loaddown=1,repository_path='"+getSuccessRepositoryPath+"' where id = "+this.novelResource.getId()+"";
               dataDeal.updateByc3p0(sql);
           }
       }

        // src图片下载
        if (!this.novelResource.getSrcHasLoaddown()) {
            String storeAdress2 = root + this.novelResource.getSrcRepositoryPath();
            if ( result != null ) {
                storeAdress2 +=  "\\"+result.split("\\.")[0] +"\\";
            }
            System.out.println("开始下载图片："+this.novelResource.getName());
            String result2 = null; // src图片下载结果

            // 开始下载小说对应的图片
            try {
                result2 = HttpGetDownFile.filterLinkAndDownloadAndSave(this.novelResource.getLinkSrc(),storeAdress2,false);
            } catch (IOException e) {
                result2 = null;
                e.printStackTrace();
            }
            // 下载成功后修改数据库状态
            if ( result2 != null ){
                String getSuccessRepositoryPath = this.novelResource.getSrcRepositoryPath()+result2;
                String sql = "UPDATE druid_novel_resource SET src_has_loaddown=1,src_repository_path='"+getSuccessRepositoryPath+"' where id = "+this.novelResource.getId()+"";
                dataDeal.updateByc3p0(sql);
            }
        }
    }
}
