package com.slp.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainsiteErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @RequestMapping(value=ERROR_PATH)
    public String handleError(){
       System.out.println("进入web2模块中的403页面");
        return "403";
    }

    @Override
    public String getErrorPath() {
        // TODO Auto-generated method stub
        return ERROR_PATH;
    }

    @RequestMapping(value="/deny")
    public String handleDeny(){
        System.out.println("进入web2模块中的deny页面");
        return "deny";
    }

    @RequestMapping("/tosignout")
    public String tosso() {
        System.out.println("进入web2模块中的tosignout页面");
        return "tosignout";
    }

    @RequestMapping("/login")
    public String dashboard() {
        System.out.println("进入web2模块中的redirect:/#/页面");
        return "redirect:/#/";
    }

}
