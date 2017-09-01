package com.slp.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainsiteErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @RequestMapping(value=ERROR_PATH)
    public String handleError(){
        System.out.println("进入login模块的403页面");
        return "403";
    }

    @Override
    public String getErrorPath() {
        System.out.println("进入login模块的403页面");
        return "403";
    }

    @RequestMapping(value="/deny")
    public String deny(){
        System.out.println("进入login模块的deny页面");
        return "deny";
    }
}
