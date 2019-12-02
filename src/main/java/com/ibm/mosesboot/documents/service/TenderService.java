/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.service.MultipartFile
 * @version V1.0
 */
package com.ibm.mosesboot.documents.service;

import com.ibm.mosesboot.documents.entity.PlanTender;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Moses
 * @date 2019/11/29
 */
public interface TenderService {
    PlanTender selectByPrimaryKey(Integer id);

    void export(PlanTender planTender, HttpServletResponse response, HttpServletRequest request) throws Exception;

    void save(PlanTender planTender);
}
