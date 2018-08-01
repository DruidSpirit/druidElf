package com.druid.service.impl;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.druid.dao.IStudentMapper;
import com.druid.entity.Invoice;
import com.druid.service.IStudentService;


@Service
public class StudentServiceImpl implements IStudentService{

	@Autowired
	private IStudentMapper istu;
	/*@Autowired
	private DepartmentMapper departmentMapper;*/
	/**
	 * ��ѯѧ����Ϣ
	 */

	@Override
	public List<Invoice> findstu() {
		return istu.findstu();
	}
	
	public List findSqlObject(String sqlString) {
		return istu.anyObject(sqlString);
	}
	
}
