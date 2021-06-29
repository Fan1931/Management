package com.cy.yan.service.impl;

import com.cy.common.annotation.RequiredLog;
import com.cy.common.exception.ServiceException;
import com.cy.common.vo.PageObject;
import com.cy.yan.dao.YLogsDao;
import com.cy.yan.entity.YLogs;
import com.cy.yan.service.YLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (YLogs)表服务实现类
 *
 * @author if
 * @since 2021-06-02 18:06:19
 */
@Service("yLogsService")
public class YLogsServiceImpl implements YLogsService {

    @Autowired
    private YLogsDao yLogsDao;


    @Override
    public PageObject findPageObjects(String username, Integer pageCurrent) {
        //1.判定pageCurrent参数合法性
        if(pageCurrent==null||pageCurrent<1)
            throw new IllegalArgumentException("当前页码值不正确");
        //2.查询日志总记录数,并进行判定
        int rowCount=yLogsDao.getRowCount(username);
        if(rowCount==0)
            throw new ServiceException("没有找到对应记录");
        //3.查询当前页日志记录
        int pageSize=3;
        int startIndex=(pageCurrent-1)*pageSize;
        List<YLogs> records= yLogsDao.findPageObjects(username, startIndex, pageSize);
        //4.对查询结果进行封装并返回
        PageObject<YLogs> po=new PageObject<>();
        po.setRowCount(rowCount);
        po.setRecords(records);
        po.setPageCurrent(pageCurrent);
        po.setPageSize(pageSize);
		/*int pageCount=rowCount/pageSize;
		if(rowCount%pageSize!=0) {
			pageCount++;
		}*/
        int pageCount=(rowCount-1)/pageSize+1;
        po.setPageCount(pageCount);
        return po;
    }

    @Override
    @RequiredLog("删除日志")
    public int deleteObjects(Integer[] ids) {
        //1.参数校验
        if(ids==null||ids.length==0)
            throw new IllegalArgumentException("参数无效");
        //2.执行删除操作
        int rows=yLogsDao.deleteObjects(ids);
        if(rows<0)
            throw new ServiceException("记录可能已经不存在");
        return rows;
    }
}
