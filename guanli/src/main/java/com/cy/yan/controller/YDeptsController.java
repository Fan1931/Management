package com.cy.yan.controller;

import com.cy.common.vo.JsonResult;
import com.cy.yan.entity.YDepts;
import com.cy.yan.service.YDeptsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (YDepts)表控制层
 *
 * @author if
 * @since 2021-06-02 18:06:17
 */
@Controller
@RequestMapping("/yDepts/")
public class YDeptsController {
    /**
     * 服务对象
     */
    @Resource
    private YDeptsService yDeptsService;

    @RequestMapping("doDeptListUI")
    public String doDeptListUI() {
        return "sys/dept_list";
    }

    @RequestMapping("doDeptEditUI")
    public String doDeptEditUI() {
        return "sys/dept_edit";
    }

    /**
     * 查找所有数据
     *
     * @return
     */
    @RequestMapping("doFindObjects")
    @ResponseBody
    public JsonResult doFindObjects() {
        return new JsonResult(yDeptsService.findObjects());
    }

    @RequestMapping("doSaveObject")
    @ResponseBody
    public JsonResult doSaveObject(YDepts yDepts) {
        yDeptsService.save(yDepts);
        return new JsonResult("save ok");
    }

    @RequestMapping("doUpdateObject")
    @ResponseBody
    public JsonResult doUpdateObject(YDepts yDepts) {
        yDeptsService.update(yDepts);
        return new JsonResult("update ok");
    }

    @RequestMapping("doDeleteObject")
    @ResponseBody
    public JsonResult doDeleteObject(Integer id){
        yDeptsService.deleteById(id);
        return new JsonResult("delete ok");
    }


    @RequestMapping("doFindZTreeNodes")
    @ResponseBody
    public JsonResult doFindZTreeNodes(){
        return new JsonResult(yDeptsService.findZTreeNodes());
    }
}
