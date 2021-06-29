package com.cy.yan.controller;

import com.cy.common.vo.JsonResult;
import com.cy.yan.entity.YUser;
import com.cy.yan.service.YUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * (YUser)表控制层
 *
 * @author if
 * @since 2021-06-02 18:06:20
 */
@Controller
@RequestMapping("/yUser/")
public class YUserController {

    @Autowired
    private YUserService yUserService;

    @RequestMapping("doUserListUI")
    public String doUserListUI() {
        return "sys/user_list";
    }

    @RequestMapping("doFindPageObjects")
    @ResponseBody
    public JsonResult doFindPageObjects(String username, Integer pageCurrent) {
        return new JsonResult(yUserService.findPageObjects(username, pageCurrent));
    }

    @RequestMapping("doFindObjectById")
    @ResponseBody
    public JsonResult doFindObjectById(Integer id) {
        return new JsonResult(yUserService.findObjectById(id));
    }

    @RequestMapping("doUserEditUI")
    public String doUserEditUI() {
        return "sys/user_edit";
    }

    @RequestMapping("doValidById")
    @ResponseBody
    public JsonResult doValidById(Integer id, Integer valid) {
        YUser yUser = (YUser) SecurityUtils.getSubject().getPrincipal();
        yUserService.validById(id, valid, yUser.getUsername());
        return new JsonResult("update ok");
    }

    @RequestMapping("doPwdEditUI")
    public String doPwdEditUI() {
        return "sys/pwd_edit";
    }

    @RequestMapping("doLogin")
    @ResponseBody
    public JsonResult doLogin(boolean isRememberMe, String username, String password) {
        //1.封装用户信息
        UsernamePasswordToken token =
                new UsernamePasswordToken(username, password);
        if (isRememberMe) {
            token.setRememberMe(true);
        }
        //2.提交用户信息
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);//token会提交给securityManager
        return new JsonResult("login ok");
    }

    @RequestMapping("doSaveObject")
    @ResponseBody
    public JsonResult doSaveObject(YUser entity, Integer[] roleIds) {
        yUserService.saveObject(entity, roleIds);
        return new JsonResult("save ok");
    }

    @RequestMapping("doDeleteObjectById")
    @ResponseBody
    public JsonResult doDeleteObjectById(Integer id) {
        yUserService.deleteObjectById(id);
        return new JsonResult("delete ok");
    }

    @RequestMapping("doUpdateObject")
    @ResponseBody
    public JsonResult doUpdateObject(YUser entity, Integer[] roleIds) {
        yUserService.updateObject(entity, roleIds);
        return new JsonResult("update ok");
    }

    @RequestMapping("doUpdatePassword")
    @ResponseBody
    public JsonResult doUpdatePassword(String pwd, String newPwd, String cfgPwd) {
        yUserService.updatePassword(pwd, newPwd, cfgPwd);
        return new JsonResult("save ok");
    }


    @RequestMapping("check")
    @ResponseBody
    public JsonResult check(String username) {
        yUserService.userNameIsOk(username);
        return new JsonResult("ok");
    }

    /**
     * 注册
     */
    @RequestMapping("doRegister")
    @ResponseBody
    public JsonResult register(YUser entity, Integer[] roleIds) {
        yUserService.saveObject(entity, roleIds);
        return new JsonResult("register ok");
    }

    @RequestMapping("doNameOK")
    @ResponseBody
    public JsonResult doNameOK(String username){
        boolean b = yUserService.doNameOK(username);
        if (b == true) {
            return new JsonResult("用户名重复");
        }else{
            return new JsonResult("用户名可以使用");
        }
    }
}
