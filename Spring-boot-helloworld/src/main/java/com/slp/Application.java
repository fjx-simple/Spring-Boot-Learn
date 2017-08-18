package com.slp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sangliping on 2017/8/18.
 * @SpringBootApplication代表这是一个Spring Boot应用
 * main方法使他成为一个主程序，程序启动时将被有限执行
 * @RestController表明这是一个控制器
 */
@SpringBootApplication
@RestController
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }

    @RequestMapping("/")
    String home(){
        return "hello";
    }
}
