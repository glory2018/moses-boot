/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.service.MultipartFile
 * @version V1.0
 */
package com.ibm.mosesboot.moses.service;

import org.springframework.core.io.InputStreamSource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Moses
 * @date 2019/11/29
 */
public interface MultipartFile extends InputStreamSource {
    String getName();

    String getOriginalFilename();

    String getContentType();

    boolean isEmpty();

    long getSize();

    byte[] getBytes() throws IOException;

    @Override
    InputStream getInputStream() throws IOException;

    void transferTo(File dest) throws IOException, IllegalStateException;
}
