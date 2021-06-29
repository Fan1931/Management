package com.cy.yan.service;

import com.cy.yan.vo.YRoleMenus;

import java.util.List;

/**
 * (YRoleMenus)表服务接口
 *
 * @author if
 * @since 2021-06-08 13:33:18
 */
public interface YRoleMenusService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    YRoleMenus queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<YRoleMenus> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param yRoleMenus 实例对象
     * @return 实例对象
     */
    YRoleMenus insert(YRoleMenus yRoleMenus);

    /**
     * 修改数据
     *
     * @param yRoleMenus 实例对象
     * @return 实例对象
     */
    YRoleMenus update(YRoleMenus yRoleMenus);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
