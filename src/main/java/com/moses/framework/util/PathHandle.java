/********************************************
 *                                           *
 * Project farsighted Maven Webapp                  *
 * Package   org.framework.file                 *
 * File    PathHandle.java                     *
 * Copyright (C)  2014 INSCRIBE            *
 *                                           *
 **********K*I*N*G**********B*A*C*K**********/
package com.moses.framework.util;

import java.io.File;
import java.net.URL;

/**
 * @author STEVE FRANK
 */
public class PathHandle {
    // 当前类目录
    public static URL getClassCatalogue() {
        // PathHandle.class.getClassLoader().getResource("").toString();
        return PathHandle.class.getResource("");
    }

    // 当前类路径
    public static URL getClassPath() {
        return PathHandle.class.getResource("PathHandle.class");
    }

    // classes路径
    public static URL getClassesPath() {
        return Thread.currentThread().getContextClassLoader().getResource("");
    }

    // 项目所在磁盘
    public static String getDisc() {
        return new File("/").getAbsolutePath();
    }

    // 项目绝对路径
    public static String getAbsolutePath() {
        return System.getProperty("user.dir");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // System.out.println(getAbsolutePath());
    }
}
