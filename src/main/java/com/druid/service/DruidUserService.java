package com.druid.service;

import java.util.List;

import com.druid.entity.DruidUser;

public interface DruidUserService extends IService<DruidUser>{
	List<DruidUser> selectAll();
}
