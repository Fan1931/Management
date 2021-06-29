package com.cy.yan.service;

import com.cy.yan.entity.YUserLogs;

import java.util.List;

/**
 * (YUserLogs)表服务接口
 *
 * @author if
 * @since 2021-06-02 18:06:20
 */
public interface YUserLogsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    YUserLogs queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<YUserLogs> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param yUserLogs 实例对象
     * @return 实例对象
     */
    YUserLogs insert(YUserLogs yUserLogs);

    /**
     * 修改数据
     *
     * @param yUserLogs 实例对象
     * @return 实例对象
     */
    YUserLogs update(YUserLogs yUserLogs);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
