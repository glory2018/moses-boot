package com.ibm.mosesboot.documents.entity;

public class SingleSource {
    private String richId;

    private String richName;

    private String richContent;

    public String getRichId() {
        return richId;
    }

    public void setRichId(String richId) {
        this.richId = richId == null ? null : richId.trim();
    }

    public String getRichName() {
        return richName;
    }

    public void setRichName(String richName) {
        this.richName = richName == null ? null : richName.trim();
    }

    public String getRichContent() {
        return richContent;
    }

    public void setRichContent(String richContent) {
        this.richContent = richContent == null ? null : richContent.trim();
    }
}