package com.druid.control;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionControl {
    /**
     * ����У���쳣
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public void ExceptionHander ( Exception e)  throws Exception{
            e.printStackTrace();
            throw e;
    }
    /*@ModelAttribute
    //Ӧ�õ�����@RequestMappingע�ⷽ��
    //�˴�����ֵ����ӵ�ȫ�֣�ע����@RequestMapping�ķ��������Ի�ô˼�ֵ��
    public void addUser(Model model) {
        model.addAttribute("msg", "�˴�����ֵ����ӵ�ȫ�֣�ע����@RequestMapping�ķ��������Ի�ô˼�ֵ��");
    }*/

   /* @InitBinder
    //Ӧ�õ�����@RequestMappingע�ⷽ��������ִ��֮ǰ��ʼ�����ݰ���
    //��������WebDataBinder�������Զ���ǰ̨���������Model�С�
    public void initBinder(WebDataBinder binder) {
    }*/
}
