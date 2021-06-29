package com.cy.yan.service;

import com.cy.common.vo.PageObject;

/**
 * (YLogs)表服务接口
 *
 * @author if
 * @since 2021-06-02 18:06:19
 */
public interface YLogsService<T> {

    PageObject<T> findPageObjects(String username, Integer pageCurrent);

    int deleteObjects(Integer[] ids);
}
