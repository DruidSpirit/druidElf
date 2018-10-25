package com.druid.interceptor;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.druid.definedAnnotation.Interceptors;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;



public abstract class BaseInterceptor extends HandlerInterceptorAdapter {

private Annotation interceptor;

    public boolean isMyHandler(Object handler) {
        if (!(handler instanceof HandlerMethod))
            return false;
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        /*Object bean = handlerMethod.getBean();
 		Method method = handlerMethod.getMethod();
 		Interceptor classAnnotation = bean.getClass().getAnnotation(Interceptor.class);
 		Interceptor methodAnnotation = method.getAnnotation(Interceptor.class);*/
        interceptor = handlerMethod.getMethodAnnotation(getAnnotation());
       // Object object =  handlerMethod.getMethodAnnotation(Interceptor.class);
        if (interceptor == null) {
            Object bean = handlerMethod.getBean();
            Method method = handlerMethod.getMethod();
            interceptor = bean.getClass().getAnnotation(Interceptors.class);
        }
        if (interceptor == null)
            return false;
        
        if (!interceptor.annotationType().isAnnotation())
        	return false;
      /*  System.out.println(interceptor.toString());
        System.out.println(interceptor.annotationType());
        System.out.println(interceptor.annotationType().getName());
        System.out.println(interceptor.annotationType().getSimpleName());
        System.out.println(interceptor.getClass().getSimpleName());*/
    /*    if (!interceptor.name().equals(this.getClass().getSimpleName()) && !interceptor.name().equals(this.getClass().getName()))
            return false;*/

        return true;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (isMyHandler(handler)) {
            return  runHandlers(request, response,interceptor);
        }
        return super.preHandle(request, response, handler);
    }
    
    //这个抽象方法是为了方便子类重写
    protected abstract boolean runHandlers(HttpServletRequest request, HttpServletResponse response,Annotation interceptor);
    //得到自定义注解
    protected abstract Class getAnnotation();

    /**
     * 运行结果
     * 
     * @param response
     * @param isInterceptor
     *            是否拦截,true拦截,跳转向failed指向页面,false:不拦截,跳转向success指向页面;
     *            success和failed为空时不做任何操作
     * @return
     * @throws Exception
     *//*
    public boolean runHandler(HttpServletResponse response, boolean isInterceptor) throws Exception {
        if (!isInterceptor) {
            if (!success.equals("")) {
                response.sendRedirect(success);
                return false;
            }
        } else {
            if (!failed.equals("")) {
                response.sendRedirect(failed);
                return false;
            }
        }
        return true;
    }
*/
  /*@Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Interceptor {
        public String name();

        public String success() default "";

        public String failed() default "";
    }*/
  
/*  public static boolean loadClassTool(){
	  Class class1 = Interceptor.class;
	  Method [] methods = class1.getDeclaredMethods();
	  for(Method method:methods){
	  TestZJ annotations = method.getAnnotation(Interceptor.class);
	  if(annotations !=null){
	  System.out.println(annotations.id());

	return false;
	  
  }*/
}

