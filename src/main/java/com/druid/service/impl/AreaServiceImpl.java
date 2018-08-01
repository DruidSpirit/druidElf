package com.druid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.druid.dao.AreaMapper;
import com.druid.entity.Area;
import com.druid.service.AreaService;
@Service
public class AreaServiceImpl implements AreaService{
	@Autowired
	private AreaMapper areaMapper;
	private Area area = new Area();
	
	@Override
	public List<Area> selectByArea() {
		// TODO Auto-generated method stub
		area.setPid(0);
		return areaMapper.selectByArea(area);
	}
	

}
