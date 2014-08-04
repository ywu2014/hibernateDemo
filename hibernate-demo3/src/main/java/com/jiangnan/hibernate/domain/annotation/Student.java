package com.jiangnan.hibernate.domain.annotation;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: yejunwu123@gmail.com
 * Date: 2014-07-20 20:30
 * Description:
 */
@Entity
@Table(name = "A_STUDENT")
public class Student {
    /**主键*/
    @Id
    @GeneratedValue
    private Long id;
    /**姓名*/
    @Column(name = "name",length = 20,nullable = false,unique = true)
    @org.hibernate.annotations.Index(name = "sku_index_name")
    private String name;
    /**性别*/
    @Column(name = "sex",nullable = false,columnDefinition = "char(1) not null default'男'")
    @org.hibernate.annotations.Generated(value = GenerationTime.ALWAYS)
    private char sex;
    /**年龄*/
    private Short age;
    /**身高*/
    private Integer height;
    /**体重*/
    @Column(precision = 10,scale = 2)
    private Float weight;
    /**学费*/
    @Column(precision = 8,scale = 2)
    private BigDecimal tuition;
    /**自我介绍*/
    @Lob
    private String selfIntroduction;
    /**状态*/
    private boolean status;
    /**出生时间*/
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthTime;
    /**入学日期*/
    @Temporal(TemporalType.DATE)
    private Date entranceDay;
    /**记录插入时间*/
    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = true,updatable = false)
    private Date insertTime;
    /**记录更新时间*/
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    /**国籍*/
    private Locale nationality;
    /**身高体重比*/
    @org.hibernate.annotations.Formula(value = "height/weight")
    private Double bmi;

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

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public BigDecimal getTuition() {
        return tuition;
    }

    public void setTuition(BigDecimal tuition) {
        this.tuition = tuition;
    }

    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(Date birthTime) {
        this.birthTime = birthTime;
    }

    public Date getEntranceDay() {
        return entranceDay;
    }

    public void setEntranceDay(Date entranceDay) {
        this.entranceDay = entranceDay;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Locale getNationality() {
        return nationality;
    }

    public void setNationality(Locale nationality) {
        this.nationality = nationality;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }
}
