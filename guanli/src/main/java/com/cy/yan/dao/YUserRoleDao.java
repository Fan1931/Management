package com.cy.yan.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface YUserRoleDao {
    /**
     * 基于用户id获取用户对应的角色信息
     * @param id
     * @return
     */
    List<Integer> findRoleIdsByUserId(Integer id);

    int insertObjects(
            @Param("userId")Integer userId,
            @Param("roleIds")Integer[] roleIds);

    /**
     * 基于用户id删除角色和用户关系数据
     * @param id
     * @return
     */
    int deleteObjectsByUserId(Integer userId);
    /**
     * 基于角色id删除角色和用户关系数据
     * @param id
     * @return
     */
    int deleteObjectsByRoleId(Integer roleId);
}
