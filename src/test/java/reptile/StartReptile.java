package reptile;

import com.druid.dao.DruidNovelResourceMapper;
import com.druid.entity.DruidNovelResource;
import com.druid.service.DruidNovelResourceService;
import com.druid.util.ConnectionPoolSetting;
import com.github.pagehelper.PageHelper;
import multithreading.MultithreadingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//?????????????
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class StartReptile {
    @Autowired
    private DruidNovelResourceService druidNovelResourceService;
    @Test
    public void toStart () {
        PageHelper.startPage(1,10);
        List<DruidNovelResource> novelResourceList = druidNovelResourceService.selectByExample(null);
       // MultithreadingService multithreadingService = new MultithreadingService(novelResourceList.get(0),druidNovelResourceService);
       // multithreadingService.run();
        for (DruidNovelResource novelResource:novelResourceList) {
            ConnectionPoolSetting.executorService.submit(new MultithreadingService(novelResource,druidNovelResourceService));
        }
        ConnectionPoolSetting.executorService.shutdown();
    }
}
