package com.cy.yan.service.impl;

import com.cy.yan.entity.YUserLogs;
import com.cy.yan.dao.YUserLogsDao;
import com.cy.yan.service.YUserLogsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (YUserLogs)表服务实现类
 *
 * @author if
 * @since 2021-06-02 18:06:20
 */
@Service("yUserLogsService")
public class YUserLogsServiceImpl implements YUserLogsService {
    @Resource
    private YUserLogsDao yUserLogsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public YUserLogs queryById(Integer id) {
        return this.yUserLogsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<YUserLogs> queryAllByLimit(int offset, int limit) {
        return this.yUserLogsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param yUserLogs 实例对象
     * @return 实例对象
     */
    @Override
    public YUserLogs insert(YUserLogs yUserLogs) {
        this.yUserLogsDao.insert(yUserLogs);
        return yUserLogs;
    }

    /**
     * 修改数据
     *
     * @param yUserLogs 实例对象
     * @return 实例对象
     */
    @Override
    public YUserLogs update(YUserLogs yUserLogs) {
        this.yUserLogsDao.update(yUserLogs);
        return this.queryById(yUserLogs.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.yUserLogsDao.deleteById(id) > 0;
    }
}
