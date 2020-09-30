/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.moses.framework.samples.service.MultipartFile
 * @version V1.0
 */
package com.moses.framework.samples.file.service;

import org.springframework.core.io.InputStreamSource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Moses
 * @date 2019/11/29
 */
public interface MultipartFile extends InputStreamSource {
    /**
     * @return 名称
     */
    String getName();

    /**
     * @return 原始文件名
     */
    String getOriginalFilename();

    /**
     * @return 内容类型
     */
    String getContentType();

    /**
     * @return 是否为空
     */
    boolean isEmpty();

    /**
     * @return 大小
     */
    long getSize();

    /**
     * @return 字节
     * @throws IOException
     */
    byte[] getBytes() throws IOException;

    /**
     * @return 文件流
     * @throws IOException
     */
    @Override
    InputStream getInputStream() throws IOException;

    /**
     * 转换
     *
     * @param dest 目标
     * @throws IOException
     * @throws IllegalStateException
     */
    void transferTo(File dest) throws IOException, IllegalStateException;
}
