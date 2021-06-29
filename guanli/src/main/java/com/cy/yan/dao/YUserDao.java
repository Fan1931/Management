package com.cy.yan.dao;

import com.cy.yan.entity.YUser;
import com.cy.yan.vo.YUserDept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (YUser)表数据库访问层
 *
 * @author if
 * @since 2021-06-02 18:06:20
 */
@Mapper
public interface YUserDao {

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    int getRowCount(@Param("username")String username);

    List<YUserDept> findPageObjects(
            @Param("username")String username,
            @Param("startIndex")Integer startIndex,
            @Param("pageSize")Integer pageSize);

    int validById(
            @Param("id")Integer id,
            @Param("valid")Integer valid,
            @Param("modifiedUser")String modifiedUser);

    YUser findUserByUserName(String username);

    YUserDept findObjectById(Integer id);

    int insertObject(YUser entity);

    int updateObject(YUser entity);

    int updatePassword(@Param("password")String password,
                       @Param("salt")String salt,
                       @Param("id")Integer id);

    YUser queryUserById(int id);

    YUser findByUsername(String username);

}

