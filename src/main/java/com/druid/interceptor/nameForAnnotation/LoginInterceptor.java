package com.druid.interceptor.nameForAnnotation;

import com.druid.interceptor.annotationInterceptor.GeneralInterceptor;

import interfaces.HanderWithName;

public class LoginInterceptor extends GeneralInterceptor {

	@Override
	protected boolean toHanderName(String name) {
		// TODO Auto-generated method stub
		if(name.equals(this.getClass().getSimpleName())){//����ж���Ϊ����ע���name�͸���������Ƿ�һ��
			
			System.out.println("������name�����������-������������,�ڸ�����Χ��д�߼�����Χfalse��������������");
			
			return true;
		}
	return true;
	}
	
}
