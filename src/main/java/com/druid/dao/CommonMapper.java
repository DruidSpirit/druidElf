package com.druid.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CommonMapper {
	public List anyObject(@Param("sqlString") String sqlString);
}
