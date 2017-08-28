package com.slp.model;

/**
 * Created by sangliping on 2017/8/28.
 */
public class DepartmentQo extends PageQo {
    private Long id;
    private String name;
    public DepartmentQo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
