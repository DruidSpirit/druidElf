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
		
				if(name.equals(this.getClass().getSimpleName())){//����ж���Ϊ����ע���name�͸���������Ƿ�һ��
					
					System.out.println("������name�����������-��������,�ڸ�����Χ��д�߼�����Χfalse��������������");
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
