/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.config.StorageProperties
 * @version V1.0
 */
package com.ibm.mosesboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Moses
 * @date 2019/11/29
 */
@ConfigurationProperties("storage")
public class StorageProperties {
    private String location = "C:\\\\Project\\\\Moses\\\\moses-boot\\\\src\\\\main\\\\resources\\upload-files";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
