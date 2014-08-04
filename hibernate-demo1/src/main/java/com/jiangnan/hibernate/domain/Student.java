package com.jiangnan.hibernate.domain;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2014/7/17.
 */
@Entity
@Table(name = "STUDENT")
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    //姓名
    @Column(name = "name",length = 10)
    private String name;
    //年龄
    @Column(name = "age")
    private Integer age;
    //入学年份
    @Temporal(value = TemporalType.DATE)
    @Column(name = "entrance_date")
    private Date entranceDate;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(Date entranceDate) {
        this.entranceDate = entranceDate;
    }
}
