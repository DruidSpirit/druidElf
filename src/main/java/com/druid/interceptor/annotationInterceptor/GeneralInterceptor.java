package com.druid.interceptor.annotationInterceptor;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.druid.definedAnnotation.Interceptors;
import com.druid.interceptor.BaseInterceptor;

import interfaces.HanderWithName;


public abstract class GeneralInterceptor extends BaseInterceptor{
	

	@Override
	public boolean runHandlers(HttpServletRequest request, HttpServletResponse response,Annotation interceptor) {
		// TODO Auto-generated method stub
		
		Interceptors interceptors = (Interceptors) interceptor;
		
		if(toHander(interceptors.name())){//进入注解级别的拦截器
			
			if(!interceptors.name().equals("")&&interceptors.name()!=null)//进入name级别的拦截器
				return toHanderName(interceptors.name());
						
		}
				
		return false;
	}

	//这个方法是用于自定义新的注解的
	@Override
	protected Class getAnnotation() {
		// TODO Auto-generated method stub
		return Interceptors.class;
	}

	public boolean toHander(String name) {
		System.out.println("进入了注解级别的拦截器");
		return true;
	}

	protected abstract boolean toHanderName(String name);

	
}
