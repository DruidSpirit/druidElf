package com.druid.control;

import com.druid.entity.DruidUser;
import com.druid.service.DruidUserService;
import com.druid.util.ShiroMd5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class registerAboutControl {

    @Autowired
    private DruidUserService druidUserService;
    /**
     * 跳转注册页面
     * @return
     */
    @RequestMapping(value="/toRegister")
    public String toRegister(){
        System.out.println("进入了登入页面!");

        return "register";

    }

    /**
     * 开始注册
     * @return
     */
    @RequestMapping(value="/register")
    public String register(DruidUser user){

        if (user == null) return "register";

        user = ShiroMd5Util.SysMd5(user);
       int row = 0;
       row = druidUserService.save(user);
       if (row<=0) return "register";

        System.out.println("注册成功!");
        return "successful";

    }
}
