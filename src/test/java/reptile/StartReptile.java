package reptile;

import com.druid.dao.NovelResourceMapper;
import com.druid.entity.NovelResource;
import com.druid.entity.NovelResourceExample;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//指定单元测试模块
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class StartReptile {
    @Autowired
    private NovelResourceMapper novelResourceMapper;
    @Test
    public void toStart () {
        PageHelper.startPage(1,10);
        List<NovelResource> novelResourceList = novelResourceMapper.selectByExample(null);
        System.out.println(novelResourceList.size());

    }
}
