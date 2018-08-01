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
 * ����dao
 * @author wangyang
 * �Ƽ�spring����Ŀ����spring�ĵ�Ԫ���ԣ������Զ�ע��������Ҫ�����
 * 1.����springTestģ��
 * 2.@ContextConfiguration�����ļ���λ��
 * 3.ֱ��autowiredҪʹ�õ��������
 */
@RunWith(SpringJUnit4ClassRunner.class)//ָ����Ԫ����ģ��
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MpperTest {
	
	@Autowired
	DepartmentMapper departmentMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	SqlSession sqlSession;
	/**
	 * ����department��Mapper
	 */
	@Test
	public void testCRUD(){
		System.out.println(departmentMapper);
		
		//1.���뼸������
		/*departmentMapper.insertSelective(new Department(null,"������"));
		departmentMapper.insertSelective(new Department(null,"���Բ�"));*/
		
		//2.����Ա������
		//employeeMapper.insertSelective(new Employee(null,"jerry","M","jerryatdruid",1));
		
		//3.����������Ա��,���Խ������������sqlsession
			//	����sqlsession�õ�һ��������EmployeeMapper(�����ļ���������������sqlsession)
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i=0;i<1000;i++){
			String uuid = UUID.randomUUID().toString().substring(0,5)+i;
			mapper.insertSelective(new Employee(null, uuid, "M", uuid+"@druid.com", 1));
		}
		System.out.println("�����ɹ�!");
	}

}
