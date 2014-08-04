package com.jiangnan.hibernate.domain.annotation;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created with IntelliJ IDEA.
 * User: yejunwu123@gmail.com
 * Date: 2014-07-30 17:40
 * Description:
 */
@Embeddable
public class Image {
    /**图片名称*/
    @Column(name = "IMAGE_NAME")
    private String name;
    /**图片路径*/
    @Column(name = "IMAGE_PATH")
    private String path;
    /**宽度*/
    @Column(name = "IMAGE_WIDTH")
    private int width;
    /**高度*/
    @Column(name = "IMAGE_HEIGHT")
    private int height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
