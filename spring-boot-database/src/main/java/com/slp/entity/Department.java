package com.slp.entity;


import javax.persistence.*;

/**
 * Created by sangliping on 2017/8/18.
 * @Table指定关联的数据库的表名
 * @Id定义一条记录的唯一标识
 * @GeneratedValue设置为自动增长
 */

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Department() {
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
