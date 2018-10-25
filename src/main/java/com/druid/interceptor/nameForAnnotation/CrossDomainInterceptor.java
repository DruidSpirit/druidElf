package com.druid.interceptor.nameForAnnotation;

import com.druid.interceptor.annotationInterceptor.GeneralInterceptor;

import interfaces.HanderWithName;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CrossDomainInterceptor extends GeneralInterceptor{
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;
	@Override
	protected boolean toHanderName(String name) {
		// TODO Auto-generated method stub
		
				if(name.equals(this.getClass().getSimpleName())){//这个判断是为了让注解的name和该类的名称是否一致
					
					System.out.println("进入了name级别的拦截器-跨域拦截,在该区域范围内写逻辑，范围false怎将该请求拦截");
					String header = request.getHeader("Origin");
					System.out.println("header " + header);
					response.addHeader("Access-Control-Allow-Credentials", "true");
					response.addHeader("Access-Control-Allow-Origin", header);
					response.addHeader("Access-Control-Allow-Headers", "Content-Type,Access-Token");
					return true;
				}
					
				return true;
	}


}
