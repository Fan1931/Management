package com.cy.yan.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (YDepts)实体类
 *
 * @author if
 * @since 2021-06-02 18:06:14
 */
public class YDepts implements Serializable {
    private static final long serialVersionUID = 692583327896722523L;

    private Integer id;

    private String name;

    private Date createdtime;

    private Date modifiedtime;

    private String createduser;

    private String modifieduser;

    @Override
    public String toString() {
        return "YDepts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdtime=" + createdtime +
                ", modifiedtime=" + modifiedtime +
                ", createduser='" + createduser + '\'' +
                ", modifieduser='" + modifieduser + '\'' +
                '}';
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

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public Date getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public String getCreateduser() {
        return createduser;
    }

    public void setCreateduser(String createduser) {
        this.createduser = createduser;
    }

    public String getModifieduser() {
        return modifieduser;
    }

    public void setModifieduser(String modifieduser) {
        this.modifieduser = modifieduser;
    }

}
