package com.moses.framework.samples.export.service;

import com.moses.framework.samples.export.entity.Domestic;
import com.moses.framework.samples.export.entity.DomesticDetail;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Moses
 * @date 2019/7/28
 */
public interface DomesticService {
    /**
     * 保存
     */
    void save(Domestic domestic);

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
    Domestic findById(Integer id);

    List<DomesticDetail> getDetailList(Integer id);
}
