package com.moses.framework.samples.export.service;

import com.moses.framework.samples.export.entity.Abroad;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Moses
 * @date 2019/7/28
 */
public interface AbroadService {
    /**
     * 保存
     */
    void save(Abroad abroad);

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
    Abroad findById(Integer id);
}
