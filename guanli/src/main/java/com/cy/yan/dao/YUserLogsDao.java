package com.cy.yan.dao;

import com.cy.yan.entity.YUserLogs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (YUserLogs)表数据库访问层
 *
 * @author if
 * @since 2021-06-02 18:06:20
 */
@Mapper
public interface YUserLogsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    YUserLogs queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<YUserLogs> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param yUserLogs 实例对象
     * @return 对象列表
     */
    List<YUserLogs> queryAll(YUserLogs yUserLogs);

    /**
     * 新增数据
     *
     * @param yUserLogs 实例对象
     * @return 影响行数
     */
    int insert(YUserLogs yUserLogs);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<YUserLogs> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<YUserLogs> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<YUserLogs> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<YUserLogs> entities);

    /**
     * 修改数据
     *
     * @param yUserLogs 实例对象
     * @return 影响行数
     */
    int update(YUserLogs yUserLogs);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

