package ssm_druid;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.druid.entity.Invoice;
import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)//指定单元测试模块
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:springmvc.xml"})
public class mvcTest {
	//传入springmvc的ioc
	@Autowired
	WebApplicationContext context;
	//虚拟MVC请求，获取到处理结果。
	MockMvc mockMvc;
	
	@Before
	public void initMocMvc(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPage() throws Exception{
		//模拟请求拿到返回值
		MvcResult result =  mockMvc.perform(MockMvcRequestBuilders.get("/updatestaff2").param("fenye", "1")).andReturn();
		//请求成功后取出pageinfo
		MockHttpServletRequest request = result.getRequest();
		PageInfo pi = (PageInfo)request.getAttribute("pageInfo");
		System.out.println("当前页码"+pi.getPageNum());
		System.out.println("总页码"+pi.getPages());
		System.out.println("当前页码"+pi.getTotal());
		System.out.println("在页面需要连续显示的页码");
		int[] nums = pi.getNavigatepageNums();
		for (int i : nums) {
			System.out.println(i);
		}
		//获取员工数据
		List<Invoice> list = pi.getList();
		for (Invoice invoice : list) {
			System.err.println("ID"+invoice.getId()+"==>InvoiceTitle"+invoice.getInvoiceTitle());
		}
	}
}
