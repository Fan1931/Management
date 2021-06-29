package com.cy.yan.dao;

import com.cy.common.vo.CheckBox;
import com.cy.yan.entity.YRoles;
import com.cy.yan.vo.YRoleMenus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (YRoles)表数据库访问层
 *
 * @author if
 * @since 2021-06-02 18:06:19
 */
@Mapper
public interface YRolesDao {

    int getRowCount(@Param("name") String name);

    List<YRoles> findPageObjects(
            @Param("name") String name,
            @Param("startIndex") Integer startIndex,
            @Param("pageSize") Integer pageSize);
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    YRoles queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<YRoles> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param yRoles 实例对象
     * @return 对象列表
     */
    List<YRoles> queryAll(YRoles yRoles);

    /**
     * 新增数据
     *
     * @param yRoles 实例对象
     * @return 影响行数
     */
    int insert(YRoles yRoles);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<YRoles> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<YRoles> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<YRoles> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<YRoles> entities);

    /**
     * 修改数据
     *
     * @param yRoles 实例对象
     * @return 影响行数
     */
    int update(YRoles yRoles);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    YRoleMenus findObjectById(Integer id);

    int insertObject(YRoles entity);

    int updateObject(YRoles entity);

    List<CheckBox> findObjects();
}

