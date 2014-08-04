package com.jiangnan.hibernate.domain;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: yejunwu123@gmail.com
 * Date: 2014-07-20 20:30
 * Description:
 */
public class Student {
    /**主键*/
    private Long id;
    /**姓名*/
    private String name;
    /**邮件列表*/
    List<String> emails = new ArrayList<String>(0);
    /**头像列表*/
    List<Image> images = new ArrayList<Image>(0);

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

    public List<String> getEmails() {
        return Collections.unmodifiableList(emails);
    }

    private void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public void addEmail(String email){
        this.emails.add(email);
    }

    public List<Image> getImages() {
        return images;
    }

    private void setImages(List<Image> images) {
        this.images = images;
    }

    public void addImage(Image image){
        this.images.add(image);
    }
}
