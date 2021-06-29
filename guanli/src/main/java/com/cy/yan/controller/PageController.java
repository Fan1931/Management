package com.cy.yan.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class PageController {

    @RequestMapping("doIndexUI")
    public String doIndexUI() {
        return "starter";
    }

    @RequestMapping("doPageUI")
    public String doPageUI() {
        return "common/page";
    }

    @RequestMapping("doLoginUI")
    public String doLoginUI() {
        return "login";
    }

    @RequestMapping("/")
    public String Logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:doLoginUI";
    }

    @RequestMapping("doRegisterUI")
    public String doRegister(){
        return "register";
    }
}
