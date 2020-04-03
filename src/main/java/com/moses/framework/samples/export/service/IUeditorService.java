package com.moses.framework.samples.export.service;

import com.moses.framework.samples.export.entity.Ueditor;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Moses
 * @date 2019/7/28
 */
public interface IUeditorService {
    /**
     * 保存
     *
     * @param ueditor
     */
    void save(Ueditor ueditor);

    /**
     * 导出
     *
     * @param id       ID
     * @param response
     * @throws Exception
     */
    public void export(Integer id, HttpServletResponse response) throws Exception;

    /**
     * 查询
     *
     * @param id
     * @return
     */
    Ueditor findUeditorById(Integer id);
}
