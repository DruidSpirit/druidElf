package reptile;

import com.druid.dao.DruidNovelResourceMapper;
import com.druid.dao.EmployeeMapper;
import com.druid.entity.DruidNovelResource;
import com.druid.service.DruidNovelResourceService;
import com.druid.util.ConnectionPoolSetting;
import com.github.pagehelper.PageHelper;
import multithreading.MultithreadingService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//?????????????
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class StartReptile {
    @Autowired
    private DruidNovelResourceService druidNovelResourceService;
    @Autowired
    SqlSession sqlSession2;
    @Autowired
    SqlSessionFactory sqlSessionFactory;
    @Test
    public void toStart () {
        test2();
    }
    void test1 () {
        PageHelper.startPage(1,10);
        List<DruidNovelResource> novelResourceList = druidNovelResourceService.selectByExample(null);
        // DruidNovelResourceMapper mapper = sqlSession2.getMapper(DruidNovelResourceMapper.class);
        for (DruidNovelResource novelResource:novelResourceList) {
            try {
                 SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
                 DruidNovelResourceMapper mapper = sqlSessionTemplate.getMapper(DruidNovelResourceMapper.class);
                ConnectionPoolSetting.executorService.submit(new MultithreadingService(novelResource,mapper));
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        ConnectionPoolSetting.executorService.shutdown();
    }
    void test2(){
        PageHelper.startPage(1,10);
        List<DruidNovelResource> novelResourceList = druidNovelResourceService.selectByExample(null);
        // DruidNovelResourceMapper mapper = sqlSession2.getMapper(DruidNovelResourceMapper.class);
        // for (DruidNovelResource novelResource:novelResourceList) {
            try {
                ConnectionPoolSetting.executorService.submit(new MultithreadingService(novelResourceList.get(0),sqlSessionFactory));
            }catch (Exception e){
                e.printStackTrace();
         //   }

        }
        ConnectionPoolSetting.executorService.shutdown();
    }
}
