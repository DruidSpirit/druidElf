package com.druid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.druid.dao.CommonMapper;
import com.druid.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService{
	@Autowired
	private CommonMapper commonMapper;

	@Override
	public List findSqlObject(String sqlString) {
		// TODO Auto-generated method stub
		return commonMapper.anyObject(sqlString);
	}
}
