package com.cy.yan.service;

import com.cy.common.vo.PageObject;
import com.cy.yan.entity.YUser;

import java.util.Map;

public interface YUserService<T> {

    boolean deleteById(Integer id);

    PageObject<T> findPageObjects(String username, Integer pageCurrent);

    int validById(Integer id, Integer valid,String modifiedUser);

    Map<String,Object> findObjectById(Integer id);

    int saveObject(YUser entity, Integer[] roleIds);

    int deleteObjectById(Integer id);

    int updateObject(YUser entity, Integer[] roleIds);

    int updatePassword(String password, String newPassword, String cfgPassword);

    boolean userNameIsOk(String username);

    boolean doNameOK(String username);
}
