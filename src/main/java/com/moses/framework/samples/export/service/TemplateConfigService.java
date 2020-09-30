/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.moses.framework.samples.service.MultipartFile
 * @version V1.0
 */
package com.moses.framework.samples.export.service;

import com.moses.framework.samples.export.entity.TemplateConfig;

/**
 * @author Moses
 * @date 2019/11/29
 */
public interface TemplateConfigService {
    TemplateConfig selectByPrimaryKey(Integer templateId);
}
