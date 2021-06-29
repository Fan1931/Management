package com.cy.yan.vo;

import java.io.Serializable;

/**
 * (YRoleMenus)实体类
 *
 * @author if
 * @since 2021-06-08 13:33:18
 */
public class YRoleMenus implements Serializable {
    private static final long serialVersionUID = 320857509882837418L;

    private Integer id;

    private Integer roleId;

    private Integer menuId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

}
