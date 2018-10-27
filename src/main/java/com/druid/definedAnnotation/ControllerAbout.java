package com.druid.definedAnnotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@CrossOrigin(origins = "http://192.168.2.192:8089", allowCredentials = "true",methods = RequestMethod.POST)
@Controller
@ResponseBody
@Documented
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface ControllerAbout {
    @AliasFor(
            annotation = Controller.class
    )
    String value() default "";
}
