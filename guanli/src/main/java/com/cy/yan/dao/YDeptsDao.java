package com.cy.yan.dao;

import com.cy.common.vo.Node;
import com.cy.yan.entity.YDepts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * (YDepts)表数据库访问层
 *
 * @author if
 * @since 2021-06-02 18:06:15
 */
@Mapper
public interface YDeptsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    YDepts queryById(Integer id);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param yDepts 实例对象
     * @return 对象列表
     */
    List<YDepts> queryAll(YDepts yDepts);

    /**
     * 新增数据
     *
     * @param yDepts 实例对象
     * @return 影响行数
     */
    int insert(YDepts yDepts);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<YDepts> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<YDepts> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<YDepts> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<YDepts> entities);

    /**
     * 修改数据
     *
     * @param yDepts 实例对象
     * @return 影响行数
     */
    int update(YDepts yDepts);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 查询表中所有数据
     * @return
     */
    List<Map<String, Object>> findObjects();

    List<Node> findZTreeNodes();
}

