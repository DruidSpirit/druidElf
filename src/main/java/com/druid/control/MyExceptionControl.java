package com.druid.control;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionControl {
    /**
     * 参数校验异常
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public void ExceptionHander ( Exception e)  throws Exception{
            e.printStackTrace();
            throw e;
    }
    /*@ModelAttribute
    //应用到所有@RequestMapping注解方法
    //此处将键值对添加到全局，注解了@RequestMapping的方法都可以获得此键值对
    public void addUser(Model model) {
        model.addAttribute("msg", "此处将键值对添加到全局，注解了@RequestMapping的方法都可以获得此键值对");
    }*/

   /* @InitBinder
    //应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
    //用来设置WebDataBinder，用于自动绑定前台请求参数到Model中。
    public void initBinder(WebDataBinder binder) {
    }*/
}
