package com.druid.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.druid.definedAnnotation.Interceptors;
import com.druid.entity.Area;
import com.druid.entity.Invoice;
import com.druid.service.AreaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class AreaAboutControl implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 79747256122152833L;
	
	@Autowired
	private AreaService areaService;
	@Interceptors(name = "CrossDomainInterceptor")
	@RequestMapping(value="/areaOfProvince",method=RequestMethod.GET)
	public String serviceCrossing2(HttpServletRequest request,
			@RequestParam(value="fenye",required=false) Integer page){
		List<Area> list = new ArrayList<Area>();
		PageHelper.startPage(1, 10);
		list=areaService.selectByArea();
		PageInfo<Area> p=new PageInfo<Area>(list);
		request.setAttribute("pageInfo", p);
		return "service";
	}
}
