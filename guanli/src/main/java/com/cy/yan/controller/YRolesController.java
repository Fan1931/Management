package com.cy.yan.controller;

import com.cy.common.vo.JsonResult;
import com.cy.yan.entity.YRoles;
import com.cy.yan.service.YRolesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (YRoles)表控制层
 *
 * @author if
 * @since 2021-06-02 18:06:19
 */
@Controller
@RequestMapping("/yRoles/")
public class YRolesController {

    @Resource
    private YRolesService yRolesService;


    @RequestMapping("doRoleListUI")
    public String doRoleListUI(){
        return "sys/role_list";
    }


    @RequestMapping("doFindPageObjects")
    @ResponseBody
    public JsonResult doFindPageObjects(String name,Integer pageCurrent){
        return new JsonResult(yRolesService.doFindPageObjects(name, pageCurrent));
    }

    @RequestMapping("doFindObjectById")
    @ResponseBody
    public JsonResult doFindObjectById(Integer id){
        return new JsonResult(yRolesService.doFindObjectById(id));
    }

    @RequestMapping("doRoleEditUI")
    public String doRoleEditUI(){
        return "sys/role_edit";
    }

    @RequestMapping("doSaveObject")
    @ResponseBody
    public JsonResult doSaveObject(YRoles entity,Integer[] menuIds){
        yRolesService.saveObject(entity,menuIds);
        return new JsonResult("save ok");
    }

    @RequestMapping("doUpdateObject")
    @ResponseBody
    public JsonResult doUpdateObject(YRoles entity,Integer[] menuIds){
        yRolesService.updateObject(entity,menuIds);
        return new JsonResult("update ok");
    }

    @RequestMapping("doDeleteObject")
    @ResponseBody
    public JsonResult doDeleteObject(Integer id) {
        yRolesService.deleteObject(id);
        return new JsonResult("delete ok");
    }

    @RequestMapping("doFindRoles")
    @ResponseBody
    public JsonResult doFindRoles(){
        return new JsonResult(yRolesService. findObjects());
    }
}
