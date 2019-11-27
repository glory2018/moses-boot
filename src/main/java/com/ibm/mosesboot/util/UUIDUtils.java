/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.util.ueditor.UUIDUtils
 * @version V1.0
 */
package com.ibm.mosesboot.util;

import java.util.UUID;

/**
 * @author Moses
 * @date 2019/11/27
 */
public class UUIDUtils {
    public static String get32UUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
