/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.service.MultipartFile
 * @version V1.0
 */
package com.ibm.mosesboot.documents.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Moses
 * @date 2019/11/29
 */
public interface SingleSourceService {
    void export(HttpServletRequest request, HttpServletResponse response, String tmplId, String prjId) throws Exception;
}
