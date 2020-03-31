/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.pojo.Linker
 * @version V1.0
 */
package com.moses.framework.samples.file.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Moses
 * @date 2019/11/29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Linker {
    private String fileUrl;
    private String fileName;
}
