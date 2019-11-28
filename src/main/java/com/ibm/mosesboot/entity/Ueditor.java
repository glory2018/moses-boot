/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.entity.Payment
 * @version V1.0
 */
package com.ibm.mosesboot.entity;

/**
 * @author Moses
 * @date 2019/7/28
 */
public class Ueditor {
    private Integer id;
    private String title;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
