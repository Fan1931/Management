package com.cy.yan.dao;

import com.cy.yan.vo.YRoleMenus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (YRoleMenus)表数据库访问层
 *
 * @author if
 * @since 2021-06-08 13:33:18
 */
@Mapper
public interface YRoleMenusDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    YRoleMenus queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<YRoleMenus> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param yRoleMenus 实例对象
     * @return 对象列表
     */
    List<YRoleMenus> queryAll(YRoleMenus yRoleMenus);

    /**
     * 新增数据
     *
     * @param yRoleMenus 实例对象
     * @return 影响行数
     */
    int insert(YRoleMenus yRoleMenus);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<YRoleMenus> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<YRoleMenus> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<YRoleMenus> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<YRoleMenus> entities);

    /**
     * 修改数据
     *
     * @param yRoleMenus 实例对象
     * @return 影响行数
     */
    int update(YRoleMenus yRoleMenus);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    int deleteObjectsByMenuId(Integer menuId);

    int insertObjects(@Param("roleId")Integer roleId,
                      @Param("menuIds")Integer[] menuIds);

    int deleteObjectsByRoleId(Integer roleId);

    List<Integer> findMenuIdsByRoleIds(
            @Param("roleIds")Integer[] roleIds);
}

