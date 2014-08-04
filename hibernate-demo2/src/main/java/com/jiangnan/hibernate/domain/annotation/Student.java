package com.jiangnan.hibernate.domain.annotation;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: yejunwu123@gmail.com
 * Date: 2014-07-20 20:30
 * Description:
 */
@Entity
@Table(name = "A_STUDENT")
public class Student {
    @Id
    @Column(name = "STUDENT_ID")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(generator = "nat")
    //@org.hibernate.annotations.GenericGenerator(name = "nat",strategy = "native")
    //@GeneratedValue(generator = "hi_lo")
    /*@org.hibernate.annotations.GenericGenerator(
            name = "hi_lo",
            strategy = "hilo",
            parameters = {
                    @Parameter(name = "table",value = "a_high_value"),
                    @Parameter(name = "column",value = "next_value"),
                    @Parameter(name = "max_lo",value = "4")
            })*/
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(generator = "id_increment")
    //@org.hibernate.annotations.GenericGenerator(name = "id_increment",strategy = "increment")
    private Long id;

    /*@Id
    @Column(name = "STUDENT_ID")
    @GeneratedValue(generator = "sys-uuid")
    @org.hibernate.annotations.GenericGenerator(
            name = "sys-uuid",
            strategy = "uuid",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "separator",value = "#")
            })
    private String id;*/
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
