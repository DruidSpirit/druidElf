package com.druid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.druid.dao.DruidUserMapper;
import com.druid.entity.DruidUser;
import com.druid.service.DruidUserService;

@Service
public class DruidUserServiceImpl implements DruidUserService{
	@Autowired
	private DruidUserMapper druidUserMapper;

	@Override
	public List<DruidUser> selectAll() {
		// TODO Auto-generated method stub
		return druidUserMapper.selectAll();
	}
	
	

	
}
