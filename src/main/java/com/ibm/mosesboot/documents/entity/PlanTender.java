package com.ibm.mosesboot.documents.entity;

public class PlanTender {
    private Integer id;
    private String templateName;
    private String title;
    private String locationPrex;
    private String parent;
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
        this.templateName = templateName == null ? null : templateName.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getLocationPrex() {
        return locationPrex;
    }

    public void setLocationPrex(String locationPrex) {
        this.locationPrex = locationPrex == null ? null : locationPrex.trim();
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent == null ? null : parent.trim();
    }

    public String getNextPartId() {
        return nextPartId;
    }

    public void setNextPartId(String nextPartId) {
        this.nextPartId = nextPartId == null ? null : nextPartId.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
