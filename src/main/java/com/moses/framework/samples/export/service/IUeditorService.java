package com.moses.framework.samples.export.service;

import com.moses.framework.samples.export.entity.Ueditor;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Moses
 * @date 2019/7/28
 */
public interface IUeditorService {
    void save(Ueditor ueditor);

    public void export(Integer id, HttpServletResponse response) throws Exception;

    Ueditor findUeditorById(Integer id);
}
