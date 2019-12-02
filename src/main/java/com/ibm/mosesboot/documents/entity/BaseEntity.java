/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.documents.entity.BaseEntity
 * @version V1.0
 */
package com.ibm.mosesboot.documents.entity;

/**
 * @author Moses
 * @date 2019/12/2
 */
public class BaseEntity {
    private Integer id;
    private String templateName;
    private String locationPrex;
    private String nextPartId;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getLocationPrex() {
        return locationPrex;
    }

    public void setLocationPrex(String locationPrex) {
        this.locationPrex = locationPrex;
    }

    public String getNextPartId() {
        return nextPartId;
    }

    public void setNextPartId(String nextPartId) {
        this.nextPartId = nextPartId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
