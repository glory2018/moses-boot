/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.documents.dto.PlanTenderDto
 * @version V1.0
 */
package com.ibm.mosesboot.documents.dto;

/**
 * @author Moses
 * @date 2019/12/2
 */
public class PlanTenderDto {
    /**
     * 模板id
     */
    private String templateId;
    /**
     * 项目id
     */
    private String projectId;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
