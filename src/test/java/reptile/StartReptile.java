package reptile;

import com.druid.dao.DruidNovelResourceMapper;
import com.druid.entity.DruidNovelResource;
import com.druid.util.ConnectionPoolSetting;
import com.github.pagehelper.PageHelper;
import multithreading.MultithreadingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//ָ����Ԫ����ģ��
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class StartReptile {
    @Autowired
    private DruidNovelResourceMapper novelResourceMapper;
    @Test
    public void toStart () {
        PageHelper.startPage(1,10);
        List<DruidNovelResource> novelResourceList = novelResourceMapper.selectByExample(null);
        for (DruidNovelResource novelResource:novelResourceList) {
            ConnectionPoolSetting.executorService.submit(new MultithreadingService(novelResource));
        }
        ConnectionPoolSetting.executorService.shutdown();
    }
}
