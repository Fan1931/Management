package com.cy.yan.dao;

import com.cy.yan.entity.YLogs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (YLogs)表数据库访问层
 *
 * @author if
 * @since 2021-06-02 18:06:18
 */
@Mapper
public interface YLogsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    YLogs queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<YLogs> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param yLogs 实例对象
     * @return 对象列表
     */
    List<YLogs> queryAll(YLogs yLogs);

    /**
     * 新增数据
     *
     * @param yLogs 实例对象
     * @return 影响行数
     */
    int insert(YLogs yLogs);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<YLogs> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<YLogs> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<YLogs> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<YLogs> entities);

    /**
     * 修改数据
     *
     * @param yLogs 实例对象
     * @return 影响行数
     */
    int update(YLogs yLogs);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    int insertObject(YLogs entity);

    int getRowCount(@Param("username")String username);

    List<YLogs> findPageObjects(@Param("username")String username,
                                @Param("startIndex")Integer startIndex,
                                @Param("pageSize")Integer pageSize);

    int deleteObjects(@Param("ids")Integer... id);
}

