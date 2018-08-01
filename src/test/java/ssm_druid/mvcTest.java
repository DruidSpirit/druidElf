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

@RunWith(SpringJUnit4ClassRunner.class)//ָ����Ԫ����ģ��
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:springmvc.xml"})
public class mvcTest {
	//����springmvc��ioc
	@Autowired
	WebApplicationContext context;
	//����MVC���󣬻�ȡ����������
	MockMvc mockMvc;
	
	@Before
	public void initMocMvc(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPage() throws Exception{
		//ģ�������õ�����ֵ
		MvcResult result =  mockMvc.perform(MockMvcRequestBuilders.get("/updatestaff2").param("fenye", "1")).andReturn();
		//����ɹ���ȡ��pageinfo
		MockHttpServletRequest request = result.getRequest();
		PageInfo pi = (PageInfo)request.getAttribute("pageInfo");
		System.out.println("��ǰҳ��"+pi.getPageNum());
		System.out.println("��ҳ��"+pi.getPages());
		System.out.println("��ǰҳ��"+pi.getTotal());
		System.out.println("��ҳ����Ҫ������ʾ��ҳ��");
		int[] nums = pi.getNavigatepageNums();
		for (int i : nums) {
			System.out.println(i);
		}
		//��ȡԱ������
		List<Invoice> list = pi.getList();
		for (Invoice invoice : list) {
			System.err.println("ID"+invoice.getId()+"==>InvoiceTitle"+invoice.getInvoiceTitle());
		}
	}
}
