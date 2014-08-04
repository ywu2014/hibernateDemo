package com.jiangnan.hibernate.domain;

/**
 * Created with IntelliJ IDEA.
 * User: yejunwu123@gmail.com
 * Date: 2014-07-30 17:40
 * Description:
 */
public class Image {
    /**图片名称*/
    private String name;
    /**图片路径*/
    private String path;
    /**宽度*/
    private int width;
    /**高度*/
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
