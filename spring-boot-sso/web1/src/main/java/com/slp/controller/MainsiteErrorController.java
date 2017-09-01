package com.slp.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class MainsiteErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @RequestMapping(value=ERROR_PATH)
    public String handleError(){
        System.out.println("进入web1模块的403页面");
        return "403";
    }

    @Override
    public String getErrorPath() {
        // TODO Auto-generated method stub
        return ERROR_PATH;
    }

    @RequestMapping(value="/deny")
    public String handleDeny(){
        System.out.println("进入web1模块的deny页面");
        return "deny";
    }

    @RequestMapping("/tosignout")
    public String tosso() {
        System.out.println("进入web1模块的tosignout页面");
        return "tosignout";
    }

    @RequestMapping("/login")
    public String login() {
        System.out.println("进入web1模块的redirect:/#/页面");
        return "redirect:/#/";
    }

    @RequestMapping("/")
    public String index(ModelMap model, Principal user) throws Exception{
        model.addAttribute("user", user);
        System.out.println("进入web1中/请求中");
        return "home";
    }

}
