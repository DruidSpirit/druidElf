package ssm_druid;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.druid.dao.DepartmentMapper;
import com.druid.dao.EmployeeMapper;
import com.druid.entity.Department;
import com.druid.entity.Employee;

/**
 * 测试dao
 * @author wangyang
 * 推荐spring的项目就用spring的单元测试，可以自动注入我们需要的组件
 * 1.导入springTest模块
 * 2.@ContextConfiguration配置文件的位置
 * 3.直接autowired要使用的组件即可
 */
@RunWith(SpringJUnit4ClassRunner.class)//指定单元测试模块
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MpperTest {
	
	@Autowired
	DepartmentMapper departmentMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	SqlSession sqlSession;
	/**
	 * 测试department的Mapper
	 */
	@Test
	public void testCRUD(){
		System.out.println(departmentMapper);
		
		//1.插入几个部门
		/*departmentMapper.insertSelective(new Department(null,"开发部"));
		departmentMapper.insertSelective(new Department(null,"测试部"));*/
		
		//2.生成员工数据
		//employeeMapper.insertSelective(new Employee(null,"jerry","M","jerryatdruid",1));
		
		//3.批量插入多个员工,可以进行批量插入的sqlsession
			//	根据sqlsession拿到一个批量的EmployeeMapper(配置文件中配置了批量的sqlsession)
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i=0;i<1000;i++){
			String uuid = UUID.randomUUID().toString().substring(0,5)+i;
			mapper.insertSelective(new Employee(null, uuid, "M", uuid+"@druid.com", 1));
		}
		System.out.println("批量成功!");
	}

}
