package com.druid.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.druid.entity.DruidUser;
import com.druid.service.DruidUserService;

@Controller
@Scope("prototype")
public class DruidUserControl {
	
	@Autowired
	private DruidUserService druidUserService;
	
	@RequestMapping(value="/userList.go")
	public ModelAndView userList(){
		ModelAndView  mvc = new ModelAndView();
		List<DruidUser> list = druidUserService.selectAll();
		mvc.addObject("list", list);
		mvc.setViewName("test");
		
		return mvc;
	}
}
