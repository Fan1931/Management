package com.cy.yan.entity;
import java.io.Serializable;
import java.util.Date;
/**
 * POJO:普通的java对象
 * 1)PO(持久化对象):实现与数据库表记录之间的映射
 * 2)VO(值对象):封装数据
 * 3)...
 * @author Administrator
 */
public class YLogs implements Serializable{
    private static final long serialVersionUID = -1479538995581206701L;
    private Integer id;
    private String username;
    private String operation;
    private String method;
    private String params;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    private Long  time;
    private Date createdTime;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getOperation() {
        return operation;
    }
    public void setOperation(String operation) {
        this.operation = operation;
    }
    public Date getCreatedTime() {
        return createdTime;
    }
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

}
