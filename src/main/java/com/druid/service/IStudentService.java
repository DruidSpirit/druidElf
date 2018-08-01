package com.druid.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.druid.entity.Invoice;


public interface IStudentService {

	/**
	 * ��ѯѧ����Ϣ
	 * @return
	 */
	public List<Invoice> findstu();
	public List findSqlObject(String sqlString);
}
