package com.druid.control.FrontEndSeparationControl;

import com.druid.definedAnnotation.ControllerAbout;
import com.druid.entity.DruidUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAbout
@RequestMapping(value = "/toLogin",produces = {"text/html;charset=utf-8"})
public class LoginCo {

    /**
     * �˺ŵ���
     * @param user
     * @return
     */
    @RequestMapping(value="/loginSubmit")
    public String login(@RequestBody DruidUser user){

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(token);
        }catch (Exception e){
            System.out.println("�˺Ż��������");
            return "�˺Ż��������";
            //e.printStackTrace();
        }

        System.out.println("ͨ��Ȩ����֤");
        return "����ɹ�";

    }
}
