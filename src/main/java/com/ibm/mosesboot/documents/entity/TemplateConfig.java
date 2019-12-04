package com.ibm.mosesboot.documents.entity;

public class TemplateConfig {
    private String templateId;
    private String templateName;
    private String locationPrex;
    private String nextPartId;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId == null ? null : templateId.trim();
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName == null ? null : templateName.trim();
    }

    public String getLocationPrex() {
        return locationPrex;
    }

    public void setLocationPrex(String locationPrex) {
        this.locationPrex = locationPrex == null ? null : locationPrex.trim();
    }

    public String getNextPartId() {
        return nextPartId;
    }

    public void setNextPartId(String nextPartId) {
        this.nextPartId = nextPartId == null ? null : nextPartId.trim();
    }
}
