package com.ht.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chenfeilong on 2017/10/18.
 */
public class Ueditor implements Serializable {
    private int id;
    private String title;
    private String content;
    private Date createTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Ueditor() {
    }

    public Ueditor(int id, String content, Date createTime) {
        this.id = id;
        this.content = content;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
