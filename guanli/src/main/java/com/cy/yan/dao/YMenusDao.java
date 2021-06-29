package com.cy.yan.dao;

import com.cy.common.vo.Node;
import com.cy.yan.entity.YMenus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * (YMenus)表数据库访问层
 *
 * @author if
 * @since 2021-06-08 11:39:42
 */
@Mapper
public interface YMenusDao {

    List<String> findPermissions(@Param("menuIds") Integer[] menuIds);

    List<Map<String, Object>> findObjects();

    int  getChildCount(Integer id);

    int deleteObject(Integer id);

    List<Node> findZtreeMenuNodes();

    int insertObject(YMenus entity);

    int updateObject(YMenus entity);
}

