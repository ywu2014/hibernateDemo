package com.jiangnan.hibernate.domain.annotation;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    @Column(name = "name")
    private String name;
    /**邮件列表*/
    @org.hibernate.annotations.CollectionOfElements(targetElement = java.lang.String.class)
    @JoinTable(
            name = "A_EMAIL_LIST",
            joinColumns = @JoinColumn(
                    name = "A_STUDENT_ID",
                    nullable = false
            ))
    @Column(name = "EMAIL",length = 30,unique = true,nullable = false)
    @org.hibernate.annotations.IndexColumn(name = "`ORDER`",base = 1,nullable = false)
    List<String> emails = new ArrayList<String>(0);

    /**头像列表*/
    @org.hibernate.annotations.CollectionOfElements(targetElement = com.jiangnan.hibernate.domain.annotation.Image.class)
    @JoinTable(
            name = "A_IMAGES",
            joinColumns = @JoinColumn(
                    name = "A_STUDENT_ID",
                    nullable = false
            )
    )
    /*@AttributeOverrides(
            value = {
                    @AttributeOverride(name = "path",column = @Column(name = "A_IMAGE_PATH")),
                    @AttributeOverride(name = "height",column = @Column(columnDefinition = "A_IMAGE_HEIGHT INT(10) NOT NULL"))
            }
    )*/
    /*@org.hibernate.annotations.CollectionId(
            columns = @Column(name = "IMAGE_ID"),
            type = @org.hibernate.annotations.Type(type = "int"),
            generator = "native"
    )*/
    //@AttributeOverride(name = "path",column = @Column(name = "A_IMAGE_PATH"))
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
