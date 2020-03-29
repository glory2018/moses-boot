package com.ibm.mosesboot.export.entity;

public class TemplateConfig {
    private Integer templateId;
    private String templateName;
    private String locationPrex;
    private String nextPartId;

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
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
}
