package com.cy.yan.entity;

/**
 * (YUser)实体类
 *
 * @author if
 * @since 2021-06-02 18:06:19
 */
public class YUser extends BasyEntity {
    private static final long serialVersionUID = -29780659656699124L;

    private Integer id;

    private String username;

    private String password;

    private String salt;

    private String mobile;

    private Integer valid = 1;

    private Integer deptId;


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

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}
