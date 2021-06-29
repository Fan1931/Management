package com.cy.yan.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (YMenus)实体类
 *
 * @author if
 * @since 2021-06-08 11:39:42
 */
public class YMenus implements Serializable {
    private static final long serialVersionUID = -51870592925227129L;

    private Integer id;

    private String name;

    private Integer type;

    private Integer parentId;

    private String permission;

    private Date createdTime;

    private Date modifiedTime;

    private String createdUser;

    private String modifiedUser;

    private Integer sort;

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentid) {
        this.parentId = parentid;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Date getCreatedtime() {
        return createdTime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdTime = createdtime;
    }

    public Date getModifiedtime() {
        return modifiedTime;
    }

    public void setModifiedtime(Date modifiedtime) {
        this.modifiedTime = modifiedtime;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreateduser(String createduser) {
        this.createdUser = createduser;
    }

    public String getModifieduser() {
        return modifiedUser;
    }

    public void setModifieduser(String modifieduser) {
        this.modifiedUser = modifieduser;
    }

}
