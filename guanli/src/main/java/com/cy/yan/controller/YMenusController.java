package com.cy.yan.controller;

import com.cy.common.vo.JsonResult;
import com.cy.yan.entity.YMenus;
import com.cy.yan.service.YMenusService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (YMenus)表控制层
 *
 * @author if
 * @since 2021-06-08 11:39:43
 */
@Controller
@RequestMapping("/yMenus/")
public class YMenusController {

    @Resource
    private YMenusService yMenusService;


    @RequestMapping("doMenusListUI")
    public String doMenusListUI(){
        return "sys/menu_list";
    }

    @RequestMapping("doFindObjects")
    @ResponseBody
    public JsonResult doFindObjects(){
        return new JsonResult(yMenusService.findObjects());
    }

    @RequestMapping("doDeleteObject")
    @ResponseBody
    public JsonResult doDeleteObject(Integer id){
        yMenusService.doDeleteObject(id);
        return new JsonResult("delete ok");
    }

    @RequestMapping("doMenuEditUI")
    public String doMenuEditUI(){
        return "sys/menu_edit";
    }

    @RequestMapping("doFindZtreeMenuNodes")
    @ResponseBody
    public JsonResult doFindZtreeMenuNodes(){
        return new JsonResult(yMenusService.doFindZtreeMenuNodes());
    }

    @RequestMapping("doSaveObject")
    @ResponseBody
    public JsonResult doSaveObject(YMenus entity){
        yMenusService.saveObject(entity);
        return new JsonResult("save ok");
    }

    @RequestMapping("doUpdateObject")
    @ResponseBody
    public JsonResult doUpdateObject(YMenus entity){
        yMenusService.updateObject(entity);
        return new JsonResult("update ok");
    }
}
