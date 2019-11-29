package com.ibm.mosesboot.documents.service;

import com.ibm.mosesboot.documents.entity.Ueditor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Moses
 * @date 2019/7/28
 */
public interface IUeditorService {
    void save(Ueditor ueditor);

    void export(Ueditor ueditor, HttpServletResponse response, HttpServletRequest request) throws Exception;

    Ueditor findUeditorById(Integer id);
}
