package com.cy.yan.vo;

import com.cy.yan.entity.BasyEntity;
import com.cy.yan.entity.YDepts;

public class YUserDept extends BasyEntity{
    private static final long serialVersionUID = 8243442766152200082L;
    private Integer id;
    private String username;
    private String password;//md5
    private String salt;
    private String mobile;
    private Integer valid=1;
    private YDepts yDept; //private Integer deptId;
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSalt() {
        return salt;
    }
    public void setSalt(String salt) {
        this.salt = salt;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public YDepts getYDepts() {
        return yDept;
    }
    public void setYDepts(YDepts yDept) {
        this.yDept = yDept;
    }
    public Integer getValid() {
        return valid;
    }
    public void setValid(Integer valid) {
        this.valid = valid;
    }



}
