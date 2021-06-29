package com.cy.yan.service.impl;

import com.cy.yan.vo.YRoleMenus;
import com.cy.yan.dao.YRoleMenusDao;
import com.cy.yan.service.YRoleMenusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (YRoleMenus)表服务实现类
 *
 * @author if
 * @since 2021-06-08 13:33:18
 */
@Service("yRoleMenusService")
public class YRoleMenusServiceImpl implements YRoleMenusService {
    @Resource
    private YRoleMenusDao yRoleMenusDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public YRoleMenus queryById(Integer id) {
        return this.yRoleMenusDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<YRoleMenus> queryAllByLimit(int offset, int limit) {
        return this.yRoleMenusDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param yRoleMenus 实例对象
     * @return 实例对象
     */
    @Override
    public YRoleMenus insert(YRoleMenus yRoleMenus) {
        this.yRoleMenusDao.insert(yRoleMenus);
        return yRoleMenus;
    }

    /**
     * 修改数据
     *
     * @param yRoleMenus 实例对象
     * @return 实例对象
     */
    @Override
    public YRoleMenus update(YRoleMenus yRoleMenus) {
        this.yRoleMenusDao.update(yRoleMenus);
        return this.queryById(yRoleMenus.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.yRoleMenusDao.deleteById(id) > 0;
    }
}
