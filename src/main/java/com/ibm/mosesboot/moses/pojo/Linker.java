/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.pojo.Linker
 * @version V1.0
 */
package com.ibm.mosesboot.moses.pojo;

/**
 * @author Moses
 * @date 2019/11/29
 */
public class Linker {
    private String fileUrl;
    private String fileName;

    public Linker(String fileUrl, String fileName) {
        this.fileUrl = fileUrl;
        this.fileName = fileName;
    }

    public Linker() {
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
