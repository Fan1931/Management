package com.cy.common.util;
import com.cy.common.vo.PageObject;

import java.util.List;

public class PageUtil {
    //alt+shift+m
    public static <T> PageObject<T> newInstance(Integer pageCurrent, int rowCount, int pageSize, List<T> records) {
        PageObject<T> po=new PageObject<>();
        po.setRowCount(rowCount);  //总记录
        po.setRecords(records);  //当前页的记录
        po.setPageCurrent(pageCurrent);  //当前页码
        po.setPageSize(pageSize);  //页面大小
			/*int pageCount=rowCount/pageSize;
					if(rowCount%pageSize!=0) {
						pageCount++;
					}*/
        int pageCount=(rowCount-1)/pageSize+1;  //总页数
        po.setPageCount(pageCount);
        return po;
    }

}
