package com.cy.yan.controller;

import com.cy.common.vo.JsonResult;
import com.cy.common.vo.PageObject;
import com.cy.yan.entity.YLogs;
import com.cy.yan.service.YLogsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * (YLogs)表控制层
 *
 * @author if
 * @since 2021-06-02 18:06:19
 */
@Controller
@RequestMapping("yLogs")
public class YLogsController {
    /**
     * 服务对象
     */
    @Resource
    private YLogsService yLogsService;


    @RequestMapping(value= {"doLogListUI","logListUI"})
    public String doLogListUI(){
        return "sys/log_list";
    }

    @GetMapping("doFindPageObjects")
    @ResponseBody
    public JsonResult doFindPageObjects(String username,Integer pageCurrent){
        PageObject<YLogs> pageObject = yLogsService.findPageObjects(username, pageCurrent);
        return new JsonResult(pageObject);
    }

    @PostMapping("doDeleteObjects")
    @ResponseBody
    public JsonResult doDeleteObjects(Integer...ids){
        yLogsService.deleteObjects(ids);
        return new JsonResult("delete ok");
    }
}
