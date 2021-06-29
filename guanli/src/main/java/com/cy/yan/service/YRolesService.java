package com.cy.yan.service;

import com.cy.common.vo.CheckBox;
import com.cy.common.vo.PageObject;
import com.cy.yan.entity.YRoles;
import com.cy.yan.vo.YRoleMenus;

import java.util.List;

/**
 * (YRoles)表服务接口
 *
 * @author if
 * @since 2021-06-02 18:06:19
 */
public interface YRolesService {

    PageObject<YRoles> doFindPageObjects(String name, Integer pageCurrent);

    YRoleMenus doFindObjectById(Integer id);

    int saveObject(YRoles entity, Integer[] menuIds);

    int updateObject(YRoles entity, Integer[] menuIds);

    int deleteObject(Integer id);

    List<CheckBox> findObjects();
}
