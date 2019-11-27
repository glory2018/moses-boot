/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.util.FileUtils
 * @version V1.0
 */
package com.ibm.mosesboot.util;

/**
 * @author Moses
 * @date 2019/11/27
 */
public class JFileUtils {
    public static String getFileSuffix(String srcRealPath) {
        return srcRealPath.substring(srcRealPath.lastIndexOf(".") + 1);
    }
}
