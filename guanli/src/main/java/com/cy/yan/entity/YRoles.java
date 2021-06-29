package com.cy.yan.entity;

/**
 * (YRoles)实体类
 *
 * @author if
 * @since 2021-06-02 18:06:19
 */
public class YRoles extends BasyEntity {

    private static final long serialVersionUID = -1753927692164118852L;
    private Integer id;
    private String name;
    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
}
