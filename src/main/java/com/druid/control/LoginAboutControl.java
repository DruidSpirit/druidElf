package com.druid.control;

import java.io.Serializable;

import com.druid.service.DruidUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginAboutControl  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2821530132354966665L;

	/**
	 * 跳转登入页面
	 * @return
	 */
	@RequestMapping(value="/toLogin")
	public String toLogin(){
		System.out.println("进入了登入页面!");
		
		return "login";
		
	}
	
	/**
	 * 开始登入
	 * @return
	 */
	@RequestMapping(value="/login")
	public String login(String username,String password){
		Subject subject = SecurityUtils.getSubject();
		 UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		 try {
			 subject.login(token);
		 }catch (Exception e){
		 	System.out.println("账号或密码错误");
			 return "login";
		 	//e.printStackTrace();
		 }

		System.out.println("通过权限验证");
		return "index";
		
	}
	@RequestMapping(value="/test")
	public String test(){
		
		return "test";
		
	}
}
