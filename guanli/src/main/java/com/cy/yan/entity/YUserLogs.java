package com.cy.yan.entity;

import java.io.Serializable;

/**
 * (YUserLogs)实体类
 *
 * @author if
 * @since 2021-06-02 18:06:20
 */
public class YUserLogs implements Serializable {
    private static final long serialVersionUID = 978372010758979963L;

    private Integer id;

    private Integer userId;

    private Integer roleId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}
